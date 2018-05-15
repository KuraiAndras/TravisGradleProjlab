package projabModel;

/**
 * <h1>MapException</h1>
 * Map exception class
 */
public class MapException extends Exception {
    private static final long serialVersionUID = 8738966951762478424L;

    /**
     *We get MapExceptiont if our map is not surrounded with walls,
     * and we call its super method with the exception message.
     * @param message Exception message.
     */
    MapException(String message) {
        super(message);
    }
}
