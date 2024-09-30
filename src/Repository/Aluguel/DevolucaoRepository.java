
package Repository.Aluguel;

import Model.Aluguel.Devolucao;

import java.util.List;

public interface DevolucaoRepository {
    void salvar(Devolucao devolucao);

    void editar(Devolucao devolucao);

    void remover(Devolucao devolucao);

    Devolucao getById(String id);

    List<Devolucao> listarTodos();

    List<Devolucao> procurarPeloNomeCliente(String nomeCliente);
}
