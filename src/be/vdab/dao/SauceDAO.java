package be.vdab.dao;

import be.vdab.entities.Sauce;
import be.vdab.exceptions.DAOException;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guillaume.vandecasteele
 */
public class SauceDAO extends AbstractDAO {
    private static final String BEGIN_SELECT = "SELECT sauces.sauceid, sauces.saucename, ingredients.ingredientname FROM sauces INNER JOIN (saucerecipes INNER JOIN ingredients ON saucerecipes.ingredientid = ingredients.ingredientid) ON  sauces.sauceid = saucerecipes.sauceid";
    private static final String FIND_ALL = " ORDER BY sauces.sauceid";
    private static final String FIND_SAUCE_BY_INGREDIENT = " WHERE sauces.sauceid IN (SELECT sauceid FROM saucerecipes INNER JOIN ingredients ON saucerecipes.ingredientid = ingredients.ingredientid WHERE ingredientname = ?) ORDER BY sauces.sauceid";
    private static final String FIND_SAUCE_BY_ID = " WHERE sauces.sauceid = ? ORDER BY sauces.sauceid";
    private static final String DELETE_UPDATE = "DELETE sauces.*, saucerecipes.* FROM sauces INNER JOIN saucerecipes ON sauces.sauceid = saucerecipes.sauceid WHERE sauces.sauceid = ?";
    private static final String SAUCE_NAME = "saucename";
    private static final String SAUCE_ID = "sauceid";
    private static final String INGREDIENT_NAME = "ingredientname";
    private static final Logger logger = Logger.getLogger(SauceDAO.class.getName());
    private static final String ERROR_MESSAGE = "frituurfrida DB FUBAR";

    public Map<Long, Sauce> findAll() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(BEGIN_SELECT + FIND_ALL)) {
            return convertResultSetToMap(resultSet);
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ERROR_MESSAGE, ex);
            throw new DAOException(ex);
        }
    }

    public Map<Long, Sauce> contains(String ingredient) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(BEGIN_SELECT + FIND_SAUCE_BY_INGREDIENT)) {
            statement.setString(1, ingredient);
            try (ResultSet resultSet = statement.executeQuery()) {
                return convertResultSetToMap(resultSet);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ERROR_MESSAGE, ex);
            throw new DAOException(ex);
        }
    }

    public Map<Long, Sauce> convertResultSetToMap(ResultSet resultSet) throws SQLException {
        Map<Long, Sauce> sauceMap = new HashMap<>();
        while (resultSet.next()) {
            long id = resultSet.getLong(SAUCE_ID);
            String ingredientName = resultSet.getString(INGREDIENT_NAME);
            if (sauceMap.containsKey(id)) {
                sauceMap.get(id).addIngredient(ingredientName);
            } else {
                sauceMap.put(id, new Sauce(id, resultSet.getString(SAUCE_NAME), ingredientName));
            }
        }
        return sauceMap;
    }

    public void remove(Set<Long> ids) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_UPDATE)) {
            for (long id : ids) {
                statement.setLong(1, id);
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ERROR_MESSAGE, ex);
            throw new DAOException(ex);
        }
    }

    public Sauce read(long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(BEGIN_SELECT + FIND_SAUCE_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                return convertResultSetToMap(resultSet).get(id);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ERROR_MESSAGE, ex);
            throw new DAOException(ex);
        }
    }
}