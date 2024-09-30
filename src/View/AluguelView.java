package View;

import Service.Aluguel.DevolucaoServiceImpl;
import Utils.ScannerUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AluguelView {
    // Implementar Um só serviço para aluguel e devolução.
    private final DevolucaoServiceImpl devolucaoService;

    public AluguelView(DevolucaoServiceImpl devolucaoService) {
        this.devolucaoService = devolucaoService;
    }

    public void exibirAluguelView() {
        while (true) {
            System.out.println("\n===== Menu de Devolução de Veículos =====");
            System.out.println("1. Registrar Devolução");
            System.out.println("2. Calcular Taxa de Atraso");
            System.out.println("3. Calcular Valor Total do Aluguel");
            System.out.println("4. Gerar Comprovante de Devolução");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.println("=========================================\n");

            int opcao = ScannerUtil.lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    registrarDevolucao();
                    break;
                case 2:
                    calcularTaxaAtraso();
                    break;
                case 3:
                    calcularValorTotalAluguel();
                    break;
                case 4:
                    gerarComprovanteDevolucao();
                    break;
                case 5:
                    return; // Voltar ao menu principal
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void registrarDevolucao() {
        String placaVeiculo = ScannerUtil.lerString("Digite a placa do veículo: ");
        String nomeCliente = ScannerUtil.lerString("Digite o nome do cliente: ");
        String documentoCliente = ScannerUtil.lerString("Digite o número do documento do cliente: ");
        String nomeAgencia = ScannerUtil.lerString("Digite o nome da agencia: ");
        LocalDateTime dataDevolucaoFinal = LocalDateTime.parse(ScannerUtil.lerString("Digite a data da devolução (yyyy-MM-ddTHH:mm:ss)"));

        devolucaoService.registrarDevolucao(placaVeiculo, nomeCliente, documentoCliente, dataDevolucaoFinal, nomeAgencia);


        ScannerUtil.exibirSucesso("Devolução registrada com sucesso.");
    }

    private void calcularTaxaAtraso() {
        BigDecimal taxaAtraso = devolucaoService.calcularTaxaAtraso();
        System.out.println("Taxa Atraso: " + taxaAtraso);
    }

    private void calcularValorTotalAluguel() {
        BigDecimal valorTotalAluguel = devolucaoService.calcularValorAluguel();
        System.out.println("Valor Total do Aluguel: " + valorTotalAluguel);
    }

    private void gerarComprovanteDevolucao() {
        String comprovanteDevolucao = devolucaoService.gerarComprovante();
        System.out.println(comprovanteDevolucao);
    }

}
