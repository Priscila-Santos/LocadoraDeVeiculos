package Service.Cliente;

import Model.Pessoa.Cliente;
import Repository.Cliente.ClienteRepository;
import Utils.ScannerUtil;

import java.util.List;

public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void cadastrar(Cliente cliente) {
        Cliente clienteExistente = clienteRepository.getById(cliente.getId());
        if (clienteExistente == null) {
            clienteRepository.salvar(cliente);
            ScannerUtil.exibirSucesso("Cliente cadastrado.");
        } else {
            ScannerUtil.exibirInvalido("Cliente com ID " + cliente.getId() + " já existe.");
        }
    }

    @Override
    public void editarCliente(Cliente cliente) {
        Cliente clienteExistente = clienteRepository.getById(cliente.getId());
        if (clienteExistente != null) {
            clienteRepository.editar(cliente);
            ScannerUtil.exibirSucesso("Cliente editado.");
        } else {
            ScannerUtil.exibirInvalido("Agência não encontrada.");
        }
    }

    @Override
    public List<Cliente> buscarPorNome(String nome) {
        List<Cliente> clientes = clienteRepository.procurarPeloNome(nome);

        if (clientes.isEmpty()) {
            ScannerUtil.exibirInvalido("Nenhum cliente encontrado com o nome: " + nome);
        } else {
            ScannerUtil.exibirSucesso(clientes.size() + " cliente(s) encontrado(s) com o nome: " + nome);
            clientes.forEach(cliente -> System.out.println("Nome: " + cliente.getNome()));
        }
        return clientes;
    }

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = clienteRepository.listarTodas();
        if (clientes.isEmpty()) {
            ScannerUtil.exibirInvalido(" nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
        return clientes;
    }

    @Override
    public void removerCliente(String nomeCliente) {
        List<Cliente> clientes = clienteRepository.procurarPeloNome(nomeCliente);
        if (!clientes.isEmpty()) {
            Cliente cliente = clientes.get(0);
            clienteRepository.remover(cliente);
            ScannerUtil.exibirSucesso("Cliente removido.");
        } else {
            ScannerUtil.exibirInvalido("Cliente com nome " + nomeCliente + " não encontrado.");
        }
    }

}

