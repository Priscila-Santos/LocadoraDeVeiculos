package View;

import Model.Pessoa.Cliente;
import Model.Pessoa.PessoaFisica;
import Model.Pessoa.TipoCliente;
import Service.Cliente.ClienteService;
import Utils.ScannerUtil;

import java.util.List;
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
        TipoCliente tipo = escolherTipoCliente();
        if (tipo != null) {
            String nome = ScannerUtil.lerString("Digite o nome do cliente: ");
            String telefone = ScannerUtil.lerString("Digite o telefone do cliente: ");
            String email = ScannerUtil.lerString("Digite o email do cliente: ");

            Cliente cliente;
            switch (tipo) {
                case PESSOA_FISICA:
                    String cpf = ScannerUtil.lerString("Digite o CPF do cliente: ");
                    cliente = new PessoaFisica(nome, telefone, email, cpf);
                    break;
                case PESSOA_JURIDICA:
                    String cnpj = ScannerUtil.lerString("Digite o cnpj do cliente: ");
                    cliente = new PessoaFisica(nome, telefone, email, cnpj);
                    break;
                default:
                    System.out.println("Tipo de cliente inválido.");
                    return;
            }

            clienteService.cadastrar(cliente);

            System.out.println("Cliente cadastrado com sucesso: ");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Tipo: " + cliente.getTipo());
        }
    }


    private TipoCliente escolherTipoCliente() {
        System.out.println("Escolha o tipo do cliente:");
        for (TipoCliente tipo : TipoCliente.values()) {
            System.out.println(tipo.ordinal() + 1 + ". " + tipo);
        }

        int n = ScannerUtil.lerInteiro("Digite o número correspondente ao tipo do cliente: ");

        try {
            return TipoCliente.values()[n - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            ScannerUtil.exibirErro(" opção inválida.");
            return null;
        }
    }

    private void editarCliente() {
        String nome = ScannerUtil.lerString("Digite o nome do cliente a ser editado: ");
        List<Cliente> clienteProcurado = clienteService.buscarPorNome(nome);

        if (clienteProcurado.isEmpty()) {
            Cliente cliente = clienteProcurado.get(0);
            String novoNome = ScannerUtil.lerString("Digite o novo nome do cliente: ");
            String novoTelefone = ScannerUtil.lerString("Digite o novo telefone: ");
            String novoEmail = ScannerUtil.lerString("Digite o novo email: ");
            String novoTipoClienteString = String.valueOf(escolherTipoCliente());
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
        List<Cliente> clienteProcurado = clienteService.buscarPorNome(nome);

        if (clienteProcurado.isEmpty()) {
            ScannerUtil.exibirInvalido(" nenhum cliente encontrado com o nome: " + nome);
        } else {
            clienteProcurado.forEach(cliente -> {
                System.out.println("Cliente encontrado: ");
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("Telefone: " + cliente.getTelefone());
                System.out.println("Email: " + cliente.getEmail());
                System.out.println("Tipo: " + cliente.getTipo());
            });
        }
    }

    private void listarClientes() {
        clienteService.listarClientes();
    }
}
