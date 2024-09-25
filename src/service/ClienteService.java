package service;

import Model.Pessoa.Cliente;

public interface ClienteService {
    void cadastrar(Cliente cliente);
    Cliente buscarPorNome(String nome);
    void listarClientes();
    void removerCliente(Cliente cliente);
}