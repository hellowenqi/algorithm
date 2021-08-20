package json;

/**
 * @author wuwenqi04
 */
public class JsonException extends RuntimeException {
    public JsonException(String message) {
        super(message);
    }

    public JsonException(String message, Exception e) {
        super(message, e);
    }
}
