package exception;

public class PlacaNaoEncontradaException extends Exception {
    public PlacaNaoEncontradaException() {
        super("Placa não encontrada");
    }
}
