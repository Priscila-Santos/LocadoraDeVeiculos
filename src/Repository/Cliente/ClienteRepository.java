package Repository.Cliente;

import Model.Pessoa.Cliente;

import java.util.List;

public interface ClienteRepository {

    void salvar(Cliente cliente);

    void editar(Cliente cliente);

    void remover(Cliente cliente);

    List<Cliente> procurarPeloNome(String nome);

    List<Cliente> listarTodas();

    Cliente getById(String id);
}
