package View;

import Model.Agencia.Agencia;
import Model.Aluguel.Aluguel;
import Model.Aluguel.Devolucao;
import Model.Pessoa.Cliente;
import Model.Veiculo.GrupoVeiculo;
import Model.Veiculo.Veiculo;
import Service.Agencia.AgenciaService;
import Service.Aluguel.AluguelService;
import Service.Aluguel.DevolucaoService;
import Service.Cliente.ClienteService;
import Service.Veiculo.VeiculoService;
import Utils.ScannerUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

public class AluguelView {
    private final DevolucaoService devolucaoService;
    private final AluguelService aluguelService;
    private final ClienteService clienteService;
    private final VeiculoService veiculoService;
    private final AgenciaService agenciaService;

    public AluguelView(DevolucaoService devolucaoService, AluguelService aluguelService,
                       ClienteService clienteService, VeiculoService veiculoService,
                       AgenciaService agenciaService) {
        this.devolucaoService = devolucaoService;
        this.aluguelService = aluguelService;
        this.clienteService = clienteService;
        this.veiculoService = veiculoService;
        this.agenciaService = agenciaService;
    }

    public void exibirMenuPrincipal() {
        while (true) {
            System.out.println("\n===== Menu Principal =====");
            System.out.println("1. Alugar Veículo");
            System.out.println("2. Devolver Veículo");
            System.out.println("3. Sair");
            System.out.println("==========================\n");

            int opcao = ScannerUtil.lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    exibirSubmenuAluguel();
                    break;
                case 2:
                    exibirSubmenuDevolucao();
                    break;
                case 3:
                    System.out.println("Saindo da aplicação. Até logo!");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void exibirSubmenuAluguel() {
        while (true) {
            System.out.println("\n===== Submenu de Aluguel =====");
            System.out.println("1. Registrar Aluguel");
            System.out.println("2. Editar Aluguel");
            System.out.println("3. Remover Aluguel");
            System.out.println("4. Listar Alugueis");
            System.out.println("5. Buscar Aluguel por Nome do Cliente");
            System.out.println("6. Gerar Comprovante de Aluguel");
            System.out.println("7. Voltar ao Menu Principal");
            System.out.println("===============================\n");

            int opcao = ScannerUtil.lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    registrarAluguel();
                    break;
                case 2:
                    editarAluguel();
                    break;
                case 3:
                    removerAluguel();
                    break;
                case 4:
                    listarAlugueis();
                    break;
                case 5:
                    buscarAluguelPorNomeCliente();
                    break;
                case 6:
                    gerarComprovanteAluguel();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void exibirSubmenuDevolucao() {
        while (true) {
            System.out.println("\n===== Submenu de Devolução =====");
            System.out.println("1. Registrar Devolução");
            System.out.println("2. Editar Devolução");
            System.out.println("3. Remover Devolução");
            System.out.println("4. Listar Devoluções");
            System.out.println("5. Buscar Devolução por Nome do Cliente");
            System.out.println("6. Calcular Valor Total do Aluguel");
            System.out.println("7. Calcular Taxa de Atraso");
            System.out.println("8. Gerar Comprovante de Devolução");
            System.out.println("9. Voltar ao Menu Principal");
            System.out.println("==================================\n");

            int opcao = ScannerUtil.lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    registrarDevolucao();
                    break;
                case 2:
                    editarDevolucao();
                    break;
                case 3:
                    removerDevolucao();
                    break;
                case 4:
                    listarDevolucoes();
                    break;
                case 5:
                    buscarDevolucaoPorNomeCliente();
                    break;
                case 6:
                    calcularValorTotalAluguel();
                    break;
                case 7:
                    calcularTaxaAtraso();
                    break;
                case 8:
                    gerarComprovanteDevolucao();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }



    private void registrarAluguel() {
        System.out.println("\n--- Registrar Aluguel ---");
        try {

            Cliente cliente = selecionarCliente();
            if (cliente == null) {
                System.out.println("Cliente não encontrado. Operação cancelada.");
                return;
            }


            Optional<Veiculo> veiculoOpt = selecionarVeiculo();
            if (veiculoOpt == null || !veiculoOpt.isPresent()) {
                System.out.println("Veículo não encontrado ou indisponível. Operação cancelada.");
                return;
            }
            Veiculo veiculo = veiculoOpt.get();


            Optional<Agencia> agenciaAluguelOpt = selecionarAgencia("aluguel");
            if (agenciaAluguelOpt == null || !agenciaAluguelOpt.isPresent()) {
                System.out.println("Agência de aluguel não encontrada. Operação cancelada.");
                return;
            }
            Agencia agenciaAluguel = agenciaAluguelOpt.get();


            Optional<Agencia> agenciaDevolucaoOpt = selecionarAgencia("devolução");
            if (agenciaDevolucaoOpt == null || !agenciaDevolucaoOpt.isPresent()) {
                System.out.println("Agência de devolução não encontrada. Operação cancelada.");
                return;
            }
            Agencia agenciaDevolucao = agenciaDevolucaoOpt.get();


            LocalDateTime dataAluguel = LocalDateTime.now();
            LocalDateTime dataDevolucao = ScannerUtil.lerLocalDateTime("Digite a data prevista para devolução (dd/MM/yyyy): ");


            Aluguel aluguel = new Aluguel(
                    veiculo,
                    cliente,
                    agenciaAluguel,
                    agenciaDevolucao,
                    dataAluguel,
                    dataDevolucao
            );


            aluguelService.cadastrarAluguel(aluguel);


            String comprovante = aluguelService.gerarComprovante(aluguel);
            System.out.println(comprovante);

        } catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido. Tente novamente.");
        } catch (Exception e) {
            System.out.println("Erro ao registrar aluguel: " + e.getMessage());
        }
    }

    private Cliente selecionarCliente() {
        System.out.println("\n--- Selecionar Cliente ---");
        listarClientes();
        String nomeCliente = ScannerUtil.lerString("Digite o nome do cliente: ");
        Cliente cliente = (Cliente) clienteService.buscarPorNome(nomeCliente);
        if (cliente == null) {
            ScannerUtil.exibirInvalido("Cliente com ID " + nomeCliente + " não encontrado.");
        }
        return cliente;
    }

    private Optional<Veiculo> selecionarVeiculo() {
        System.out.println("\n--- Selecionar Veículo ---");
        listarVeiculosDisponiveis();
        String placa = ScannerUtil.lerString("Digite a placa do veículo: ");
        Optional<Veiculo> veiculo = veiculoService.buscarPorPlaca(placa);
        if (veiculo == null) {
            ScannerUtil.exibirInvalido("Veículo com placas " + placa + " não encontrado.");
            return null;
        }
        if (!veiculo.get().getDisponivel()) {
            ScannerUtil.exibirInvalido("Veículo com placas " + placa + " está indisponível.");
            return null;
        }
        return veiculo;
    }

    private Optional<Agencia> selecionarAgencia(String tipo) {
        System.out.println("\n--- Selecionar Agência de " + tipo + " ---");
        listarAgencias();
        String nomeAgencia = ScannerUtil.lerString("Digite o nome da agência de " + tipo + ": ");
        Optional<Agencia> agencia = agenciaService.buscarPorNome(nomeAgencia);
        if (agencia == null) {
            ScannerUtil.exibirInvalido("Agência com ID " + nomeAgencia + " não encontrada.");
        }
        return agencia;
    }

    private void editarAluguel() {
        System.out.println("\n--- Editar Aluguel ---");
        try {
            String idAluguel = ScannerUtil.lerString("Digite o ID do aluguel a ser editado: ");
            Aluguel<Veiculo<GrupoVeiculo>, Cliente> aluguel = aluguelService.getAluguelById(idAluguel);
            if (aluguel == null) {
                System.out.println("Aluguel com ID " + idAluguel + " não encontrado.");
                return;
            }


            System.out.println("Dados atuais do aluguel:");
            System.out.println(aluguel);


            LocalDateTime novaDataDevolucao = ScannerUtil.lerLocalDateTime("Digite a nova data prevista para devolução (dd/MM/yyyy): ");
            aluguel.setDataDevolucao(novaDataDevolucao);


            aluguelService.editarAluguel(aluguel);

        } catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido. Tente novamente.");
        } catch (Exception e) {
            System.out.println("Erro ao editar aluguel: " + e.getMessage());
        }
    }

    private void removerAluguel() {
        System.out.println("\n--- Remover Aluguel ---");
        try {
            String idAluguel = ScannerUtil.lerString("Digite o ID do aluguel a ser removido: ");
            aluguelService.removerAluguel(idAluguel);
        } catch (Exception e) {
            System.out.println("Erro ao remover aluguel: " + e.getMessage());
        }
    }

    private void listarAlugueis() {
        System.out.println("\n--- Listar Alugueis ---");
        aluguelService.listarAlugueis();
    }

    private void buscarAluguelPorNomeCliente() {
        System.out.println("\n--- Buscar Aluguel por Nome do Cliente ---");
        String nomeCliente = ScannerUtil.lerString("Digite o nome do cliente: ");
        aluguelService.buscarAluguelPorNomeCliente(nomeCliente);
    }

    private void gerarComprovanteAluguel() {
        System.out.println("\n--- Gerar Comprovante de Aluguel ---");
        String idAluguel = ScannerUtil.lerString("Digite o ID do aluguel: ");
        Aluguel<Veiculo<GrupoVeiculo>, Cliente> aluguel = aluguelService.getAluguelById(idAluguel);
        if (aluguel == null) {
            System.out.println("Aluguel com ID " + idAluguel + " não encontrado.");
            return;
        }

        String comprovante = aluguelService.gerarComprovante(aluguel);
        System.out.println(comprovante);
    }



    private void registrarDevolucao() {
        System.out.println("\n--- Registrar Devolução ---");
        try {

            Aluguel<Veiculo<GrupoVeiculo>, Cliente> aluguel = selecionarAluguel();
            if (aluguel == null) {
                System.out.println("Aluguel não encontrado ou já devolvido. Operação cancelada.");
                return;
            }


            LocalDateTime dataDevolucaoFinal = ScannerUtil.lerLocalDateTime("Digite a data final de devolução (dd/MM/yyyy): ");


            Devolucao devolucao = new Devolucao(
                    dataDevolucaoFinal,
                    aluguel,
                    BigDecimal.ZERO
            );


            devolucaoService.registrarDevolucao(devolucao);


            BigDecimal valorTotal = devolucaoService.calcularValorAluguel(devolucao);


            devolucao.setValorAluguelFinal(valorTotal);
            devolucaoService.editarDevolucao(devolucao);


            String comprovanteDevolucao = devolucaoService.gerarComprovante(devolucao);
            System.out.println(comprovanteDevolucao);

        } catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido. Tente novamente.");
        } catch (Exception e) {
            System.out.println("Erro ao registrar devolução: " + e.getMessage());
        }
    }

    private void editarDevolucao() {
        System.out.println("\n--- Editar Devolução ---");
        try {
            String idDevolucao = ScannerUtil.lerString("Digite o ID da devolução a ser editada: ");
            Devolucao devolucao = devolucaoService.getDevolucaoById(idDevolucao);
            if (devolucao == null) {
                System.out.println("Devolução com ID " + idDevolucao + " não encontrada.");
                return;
            }


            System.out.println("Dados atuais da devolução:");
            System.out.println(devolucao);


            LocalDateTime novaDataDevolucaoFinal = ScannerUtil.lerLocalDateTime("Digite a nova data final de devolução (dd/MM/yyyy): ");
            devolucao.setDataDeDevolucaoFinal(novaDataDevolucaoFinal);


            BigDecimal valorTotal = devolucaoService.calcularValorAluguel(devolucao);
            devolucao.setValorAluguelFinal(valorTotal);


            devolucaoService.editarDevolucao(devolucao);

        } catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido. Tente novamente.");
        } catch (Exception e) {
            System.out.println("Erro ao editar devolução: " + e.getMessage());
        }
    }

    private void removerDevolucao() {
        System.out.println("\n--- Remover Devolução ---");
        try {
            String idDevolucao = ScannerUtil.lerString("Digite o ID da devolução a ser removida: ");
            devolucaoService.removerDevolucao(idDevolucao);
        } catch (Exception e) {
            System.out.println("Erro ao remover devolução: " + e.getMessage());
        }
    }

    private void listarDevolucoes() {
        System.out.println("\n--- Listar Devoluções ---");
        devolucaoService.listarDevolucoes();
    }

    private void buscarDevolucaoPorNomeCliente() {
        System.out.println("\n--- Buscar Devolução por Nome do Cliente ---");
        String nomeCliente = ScannerUtil.lerString("Digite o nome do cliente: ");
        devolucaoService.buscarDevolucaoPorNomeCliente(nomeCliente);
    }

    private void calcularValorTotalAluguel() {
        System.out.println("\n--- Calcular Valor Total do Aluguel ---");
        String idDevolucao = ScannerUtil.lerString("Digite o ID da devolução: ");
        Devolucao devolucao = devolucaoService.getDevolucaoById(idDevolucao);
        if (devolucao == null) {
            System.out.println("Devolução com ID " + idDevolucao + " não encontrada.");
            return;
        }

        BigDecimal valorTotal = devolucaoService.calcularValorAluguel(devolucao);
        System.out.println("Valor Total do Aluguel: R$ " + valorTotal);
    }

    private void calcularTaxaAtraso() {
        System.out.println("\n--- Calcular Taxa de Atraso ---");
        String idDevolucao = ScannerUtil.lerString("Digite o ID da devolução: ");
        Devolucao devolucao = devolucaoService.getDevolucaoById(idDevolucao);
        if (devolucao == null) {
            System.out.println("Devolução com ID " + idDevolucao + " não encontrada.");
            return;
        }


        BigDecimal valorTotal = devolucaoService.calcularValorAluguel(devolucao);


        Aluguel<Veiculo<GrupoVeiculo>, Cliente> aluguel = devolucao.getVeiculoAluguel();
        long diasAtraso = java.time.temporal.ChronoUnit.DAYS.between(aluguel.getDataDevolucao(), devolucao.getDataDeDevolucaoFinal());
        BigDecimal taxaAtraso = diasAtraso > 0 ? BigDecimal.valueOf(0.01).multiply(BigDecimal.valueOf(diasAtraso)) : BigDecimal.ZERO;

        System.out.println("Taxa de Atraso: R$ " + taxaAtraso);
    }

    private void gerarComprovanteDevolucao() {
        System.out.println("\n--- Gerar Comprovante de Devolução ---");
        String idDevolucao = ScannerUtil.lerString("Digite o ID da devolução: ");
        Devolucao devolucao = devolucaoService.getDevolucaoById(idDevolucao);
        if (devolucao == null) {
            System.out.println("Devolução com ID " + idDevolucao + " não encontrada.");
            return;
        }

        String comprovante = devolucaoService.gerarComprovante(devolucao);
        System.out.println(comprovante);
    }

    private Aluguel<Veiculo<GrupoVeiculo>, Cliente> selecionarAluguel() {
        System.out.println("\n--- Selecionar Aluguel ---");
        listarAlugueis();
        String idAluguel = ScannerUtil.lerString("Digite o ID do aluguel: ");
        Aluguel<Veiculo<GrupoVeiculo>, Cliente> aluguel = aluguelService.getAluguelById(idAluguel);
        if (aluguel == null) {
            ScannerUtil.exibirInvalido("Aluguel com ID " + idAluguel + " não encontrado.");
            return null;
        } else {


            if (aluguel.getVeiculo().getDisponivel()) {
                System.out.println("Este aluguel já foi devolvido.");
                return null;
            }
        }
        return aluguel;
    }



    private void listarClientes() {
        System.out.println("\n--- Lista de Clientes ---");
        List<Cliente> clientes = clienteService.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        clientes.forEach(cliente -> System.out.println(cliente));
    }

    private void listarVeiculosDisponiveis() {
        System.out.println("\n--- Lista de Veículos Disponíveis ---");
        List<Veiculo> veiculos = veiculoService.listarTodos();
        boolean encontrou = false;
        for (Veiculo<?> veiculo : veiculos) {
            if (veiculo.getDisponivel()) {
                System.out.println(veiculo);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum veículo disponível no momento.");
        }
    }

    private void listarAgencias() {
        System.out.println("\n--- Lista de Agências ---");
        List<Agencia> agencias = agenciaService.listarAgencias();
        if (agencias.isEmpty()) {
            System.out.println("Nenhuma agência cadastrada.");
            return;
        }
        agencias.forEach(agencia -> System.out.println(agencia));
    }
}
