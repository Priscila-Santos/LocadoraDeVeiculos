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
            System.out.println("3. Buscar Agência por Nome");
            System.out.println("4. Buscar Agência por Endereço");
            System.out.println("5. Listar Todas as Agências");
            System.out.println("6. Voltar ao Menu Principal");
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
                    buscarAgenciaPorNome();
                    break;
                case 4:
                    buscarAgenciaPorLogradouro();
                    break;
                case 5:
                    listarAgencias();
                    break;
                case 6:
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

    private void editarAgencia(){
        String nome = ScannerUtil.lerString("Digite o nome da agência que deseja editar: ");

        Optional<Agencia> procurarAgencia = agenciaService.buscarPorNome(nome);

        if (procurarAgencia.isPresent()) {
            Agencia agenciaExistente = procurarAgencia.get();

            String novoNome = ScannerUtil.lerString("Digite o novo nome da agência (ou pressione Enter para manter " + agenciaExistente.getNome() + "): ");
            String logradouro = ScannerUtil.lerString("Digite o novo logradouro da agência (ou pressione Enter para manter " + agenciaExistente.getEndereco().getLogradouro() + "): ");
            int numero = ScannerUtil.lerInteiro("Digite o novo número (ou pressione Enter para manter " + agenciaExistente.getEndereco().getNumero() + "): ");
            String cidade = ScannerUtil.lerString("Digite a nova cidade (ou pressione Enter para manter " + agenciaExistente.getEndereco().getCidade() + "): ");
            String ufString = ScannerUtil.lerString("Digite o novo UF (sigla do estado) (ou pressione Enter para manter " + agenciaExistente.getEndereco().getUF() + "): ");
            String cep = ScannerUtil.lerString("Digite o novo CEP (ou pressione Enter para manter " + agenciaExistente.getEndereco().getCEP() + "): ");

            Endereco novoEndereco = new Endereco(
                    logradouro.isEmpty() ? agenciaExistente.getEndereco().getLogradouro() : logradouro,
                    numero == 0 ? agenciaExistente.getEndereco().getNumero() : numero,
                    cidade.isEmpty() ? agenciaExistente.getEndereco().getCidade() : cidade,
                    ufString.isEmpty() ? agenciaExistente.getEndereco().getUF() : UF.valueOf(ufString.toUpperCase()),
                    cep.isEmpty() ? agenciaExistente.getEndereco().getCEP() : cep
            );

            Agencia agenciaAtualizada = new Agencia(agenciaExistente.getId(),
                    novoNome.isEmpty() ? agenciaExistente.getNome() : novoNome,
                    novoEndereco);

            agenciaService.editarAgencia(agenciaExistente.getNome(), agenciaAtualizada);
        } else {
            System.out.println("Agência não encontrada.");
        }
    }
    private void buscarAgenciaPorNome() {
        String nome = ScannerUtil.lerString("Digite o nome da agência: ");
        Optional<Agencia> agenciaOpt = agenciaService.buscarPorNome(nome);

        if (agenciaOpt.isPresent()) {
            Agencia agencia = agenciaOpt.get();
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
        Optional<Agencia> agenciaOpt = agenciaService.buscarPorLogradouro(logradouro);

        if (agenciaOpt.isPresent()) {
            Agencia agencia = agenciaOpt.get();
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
