package Service.Cliente;

import Model.Pessoa.Cliente;

import java.util.List;

public interface ClienteService {
    void cadastrar(Cliente cliente);

    void editarCliente(Cliente cliente);

    List<Cliente> buscarPorNome(String nome);

    void listarClientes();

    void removerCliente(String idCliente);
}