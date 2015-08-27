package be.vdab.dao;

import javax.sql.DataSource;

/**
 * @author guillaume.vandecasteele on 25/08/2015 at 11:51.
 */
abstract class AbstractDAO {
    public static final String JNDI_NAME = "jdbc/frituurfrida";
    protected DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
