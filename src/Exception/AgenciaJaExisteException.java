package Exception;

public class AgenciaJaExisteException extends RuntimeException {
    public AgenciaJaExisteException(String message) {
        super(message);
    }
}
