package Repository;

import Model.Veiculo.Veiculo;

import java.util.List;
import java.util.Optional;

public interface Repositorio<T, S>{
    void salvar(T elemento);
    void remover(String placa);
    Optional<Veiculo> buscarPorPlaca(String placa);
    List<T> listarTodos();
}
