package <%= packageName %>.common;

/**
 * Exception thrown when a resource does not exist; converted to a 404
 * response by the global exception handler.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
