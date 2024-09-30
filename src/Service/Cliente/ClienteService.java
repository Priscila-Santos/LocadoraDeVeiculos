package Service.Cliente;

import Model.Pessoa.Cliente;

import java.util.List;

public interface ClienteService {
    void cadastrar(Cliente cliente);

    void editarCliente(Cliente cliente);

    List<Cliente> buscarPorNome(String nome);

    List<Cliente> listarClientes();

    void removerCliente(String idCliente);
}