package be.vdab.exceptions;

/**
 * @author guillaume.vandecasteele on 25/08/2015 at 13:15.
 */
public class DAOException extends RuntimeException {
    public DAOException(Throwable cause) {
        super(cause);
    }

    public DAOException(String fuckup) {
        super(fuckup);
    }
}
