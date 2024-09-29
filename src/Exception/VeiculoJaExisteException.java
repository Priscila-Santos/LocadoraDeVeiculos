package Exception;

public class VeiculoJaExisteException extends Exception {
    public VeiculoJaExisteException() {
        super("O veiculo já existe");
    }
}
