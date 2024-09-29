package View;

import Model.Pessoa.Cliente;
import Model.Pessoa.TipoCliente;
import Service.Cliente.ClienteService;
import Utils.ScannerUtil;

import java.util.Optional;

public class ClienteView {
    private final ClienteService clienteService;

    public ClienteView(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void exibirClienteView() {
        while (true) {
            System.out.println("\n===== Menu de Clientes =====");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Editar Cliente");
            System.out.println("3. Remover Cliente");
            System.out.println("4. Buscar Cliente por Nome");
            System.out.println("5. Listar Todos os Clientes");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.println("=============================\n");

            int opcao = ScannerUtil.lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    editarCliente();
                    break;
                case 3:
                    removerCliente();
                    break;
                case 4:
                    buscarClientePorNome();
                    break;
                case 5:
                    listarClientes();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void cadastrarCliente() {
        String nome = ScannerUtil.lerString("Digite o nome do cliente: ");
        String telefone = ScannerUtil.lerString("Digite o telefone do cliente: ");
        String email = ScannerUtil.lerString("Digite o email do cliente: ");
        String tipoClienteString = ScannerUtil.lerString("Digite o tipo de cliente (PF ou PJ): ");

        TipoCliente tipoCliente = TipoCliente.valueOf(tipoClienteString.toUpperCase());

        Cliente cliente = new Cliente(nome, telefone, email, tipoCliente) {
        };

        clienteService.cadastrar(cliente);

        System.out.println("Cliente cadastrado com sucesso: ");
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Tipo: " + cliente.getTipo());
    }

    private void editarCliente() {
        String nome = ScannerUtil.lerString("Digite o nome do cliente a ser editado: ");
        Optional<Cliente> clienteProcurado = clienteService.buscarPorNome(nome);

        if (clienteProcurado.isPresent()) {
            Cliente cliente = clienteProcurado.get();

            String novoNome = ScannerUtil.lerString("Digite o novo nome do cliente: ");
            String novoTelefone = ScannerUtil.lerString("Digite o novo telefone: ");
            String novoEmail = ScannerUtil.lerString("Digite o novo email: ");
            String novoTipoClienteString = ScannerUtil.lerString("Digite o novo tipo de cliente (PF ou PJ): ");

            TipoCliente tipoClienteAtualizado = TipoCliente.valueOf(novoTipoClienteString.toUpperCase());

            cliente.setNome(novoNome);
            cliente.setTelefone(novoTelefone);
            cliente.setEmail(novoEmail);
            cliente.setTipo(tipoClienteAtualizado);

            clienteService.editarCliente(cliente);
            System.out.println("Cliente editado com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void removerCliente() {
        String nome = ScannerUtil.lerString("Digite o nome do cliente: ");
        clienteService.removerCliente(nome);
    }

    private void buscarClientePorNome() {
        String nome = ScannerUtil.lerString("Digite o nome do cliente: ");
        Optional<Cliente> clienteProcurado = clienteService.buscarPorNome(nome);

        if (clienteProcurado.isPresent()) {
            Cliente cliente = clienteProcurado.get();
            System.out.println("Cliente encontrado: ");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Tipo: " + cliente.getTipo());
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void listarClientes() {
        clienteService.listarClientes();
    }
}
