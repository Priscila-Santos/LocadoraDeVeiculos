package repository;

import Model.Veiculo.Veiculo;

import java.util.List;
import java.util.Optional;

public interface Repositorio<T, S>{
    void salvar(T elemento);
    void remover(S placa);
    Optional<T> buscarPorPlaca(S placa);
    List<T> listarTodos();
}
