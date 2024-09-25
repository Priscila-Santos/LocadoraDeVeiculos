package Repository;

import java.util.List;

public interface Repositorio<T>{
    void salvar(T elemento);
    void remover(String placa);
    T buscarPorPlaca(String placa);
    List<T> listarTodos();
}
