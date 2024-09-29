package View;

import Model.Agencia.Agencia;
import Model.Agencia.Endereco;
import Model.Agencia.UF;
import Service.Agencia.AgenciaService;
import Utils.ScannerUtil;

import java.util.Optional;

public class AgenciaView {
    private final AgenciaService agenciaService;

    public AgenciaView(AgenciaService agenciaService) {
        this.agenciaService = agenciaService;
    }

    public void exibirAgenciaView() {
        while (true) {
            System.out.println("\n===== Menu de Agências =====");
            System.out.println("1. Cadastrar Agência");
            System.out.println("2. Editar Agência");
            System.out.println("3. Remover Agência");
            System.out.println("4. Buscar Agência por Nome");
            System.out.println("5. Buscar Agência por Endereço");
            System.out.println("6. Listar Todas as Agências");
            System.out.println("7. Voltar ao Menu Principal");
            System.out.println("=============================\n");

            int opcao = ScannerUtil.lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarAgencia();
                    break;
                case 2:
                    editarAgencia();
                    break;
                case 3:
                    removerAgencia();
                    break;
                case 4:
                    buscarAgenciaPorNome();
                    break;
                case 5:
                    buscarAgenciaPorLogradouro();
                    break;
                case 6:
                    listarAgencias();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void cadastrarAgencia() {
        String nome = ScannerUtil.lerString("Digite o nome da agência: ");
        String logradouro = ScannerUtil.lerString("Digite o logradouro da agência: ");
        int numero = ScannerUtil.lerInteiro("Digite o número: ");
        String cidade = ScannerUtil.lerString("Digite a cidade: ");
        String ufString = ScannerUtil.lerString("Digite o UF (sigla do estado): ");
        String cep = ScannerUtil.lerString("Digite o CEP: ");

        UF uf = UF.valueOf(ufString.toUpperCase());

        Endereco endereco = new Endereco(logradouro, numero, cidade, uf, cep);
        Agencia agencia = new Agencia(null, nome, endereco);

        agenciaService.cadastrar(agencia);

        System.out.println("Agência cadastrada com sucesso:");
        System.out.println("Nome: " + agencia.getNome());
        System.out.println("Endereço: " + agencia.getEndereco().getLogradouro() + ", "
                + agencia.getEndereco().getNumero() + " - "
                + agencia.getEndereco().getCidade() + "/"
                + agencia.getEndereco().getUF() + " - "
                + agencia.getEndereco().getCEP());
    }

    private void editarAgencia() {
        String nome = ScannerUtil.lerString("Digite o nome da agência a ser editada: ");
        Optional<Agencia> agenciaProcurada = agenciaService.buscarPorNome(nome);

        if (agenciaProcurada.isPresent()) {
            Agencia agencia = agenciaProcurada.get();

            String novoNome = ScannerUtil.lerString("Digite o novo nome da agência: ");
            String novoLogradouro = ScannerUtil.lerString("Digite o novo logradouro: ");
            int novoNumero = ScannerUtil.lerInteiro("Digite o novo número: ");
            String novaCidade = ScannerUtil.lerString("Digite a nova cidade: ");
            String novoUf = ScannerUtil.lerString("Digite o novo UF: ");
            String novoCep = ScannerUtil.lerString("Digite o novo CEP: ");

            UF ufAtualizado = UF.valueOf(novoUf.toUpperCase());
            Endereco enderecoAtualizado = new Endereco(novoLogradouro, novoNumero, novaCidade, ufAtualizado, novoCep);

            agencia.setNome(novoNome);
            agencia.setEndereco(enderecoAtualizado);

            agenciaService.editarAgencia(agencia);

        } else {
            System.out.println("Agência não encontrada.");
        }
    }


    private void removerAgencia() {
        String nome = ScannerUtil.lerString("Digite o nome da agência:");
        agenciaService.removerAgencia(nome);
    }

    private void buscarAgenciaPorNome() {
        String nome = ScannerUtil.lerString("Digite o nome da agência: ");
        Optional<Agencia> agenciaProcurada = agenciaService.buscarPorNome(nome);

        if (agenciaProcurada.isPresent()) {
            Agencia agencia = agenciaProcurada.get();
            System.out.println("Agência encontrada: " + agencia.getNome() + ", Endereço: " +
                    agencia.getEndereco().getLogradouro() + ", " + agencia.getEndereco().getNumero() + " - " +
                    agencia.getEndereco().getCidade() + "/" + agencia.getEndereco().getUF() + " - " +
                    agencia.getEndereco().getCEP());
        } else {
            System.out.println("Agência não encontrada.");
        }
    }

    private void buscarAgenciaPorLogradouro() {
        String logradouro = ScannerUtil.lerString("Digite o logradouro da agência: ");
        Optional<Agencia> agenciaProcurada = agenciaService.buscarPorLogradouro(logradouro);

        if (agenciaProcurada.isPresent()) {
            Agencia agencia = agenciaProcurada.get();
            System.out.println("Agência encontrada: " + agencia.getNome() + ", Endereço: " +
                    agencia.getEndereco().getLogradouro() + ", " + agencia.getEndereco().getNumero() + " - " +
                    agencia.getEndereco().getCidade() + "/" + agencia.getEndereco().getUF() + " - " +
                    agencia.getEndereco().getCEP());
        } else {
            System.out.println("Agência não encontrada.");
        }
    }

    private void listarAgencias() {
        agenciaService.listarAgencias();
    }

}
