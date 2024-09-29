package Service.Cliente;

import Model.Pessoa.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl implements ClienteService {
    private final List<Cliente> clientes;

    public ClienteServiceImpl() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void cadastrar(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
            System.out.println("Cliente cadastrado com sucesso.");
        } else {
            System.out.println("Cliente já está cadastrado.");
        }
    }

    @Override
    public void editarCliente(Cliente clienteAtualizado) {
        Optional<Cliente> clienteExistente = buscarPorNome(clienteAtualizado.getNome());

        if (clienteExistente.isPresent()) {
            clienteRepository.editar(clienteAtualizado);
        } else {
            System.out.println("Agência não encontrada.");
        }
    }

    @Override
    public Cliente buscarPorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        System.out.println("Cliente não encontrado.");
        return null;
    }

    @Override
    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    @Override
    public void removerCliente(String cliente) {
        if (clientes.contains(cliente)) {
            clientes.remove(cliente);
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}

