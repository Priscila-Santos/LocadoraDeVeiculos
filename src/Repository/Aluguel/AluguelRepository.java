
package Repository.Aluguel;

import Model.Aluguel.Aluguel;

import java.util.List;

public interface AluguelRepository {
    void salvar(Aluguel aluguel);

    void editar(Aluguel aluguel);

    void remover(Aluguel aluguel);

    Aluguel getById(String id);

    List<Aluguel> listarTodos();

    List<Aluguel> procurarPeloNomeCliente(String nomeCliente);
}
