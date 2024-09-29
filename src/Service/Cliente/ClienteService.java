package Service.Cliente;

import Model.Pessoa.Cliente;

public interface ClienteService {
    void cadastrar(Cliente cliente);

    void editarCliente(Cliente cliente);

    Cliente buscarPorNome(String nome);

    void listarClientes();

    void removerCliente(String cliente);
}