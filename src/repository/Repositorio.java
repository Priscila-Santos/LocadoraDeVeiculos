package repository;

import java.util.List;

public interface Repositorio<T>{
    void salvar(T elmento);
    void remover(String placa);
    T buscarPorPlaca(String placa);
    List<T> listarTodos();
}
