package View;

import Model.Pessoa.Cliente;
import Service.Agencia.AgenciaService;
import Service.Aluguel.AluguelService;
import Service.Cliente.ClienteService;
import Service.Veiculo.VeiculoService;
import Utils.ScannerUtil;

public class ViewPrincipal {
    private final VeiculosView veiculosView;
    private final AgenciaView agenciaView;
    private final ClienteView clienteView;
    //private final AluguelView aluguelView;

    public ViewPrincipal(VeiculoService veiculoService, AgenciaService agenciaService, ClienteService clienteService) {
        this.veiculosView = new VeiculosView(veiculoService);
        this.agenciaView = new AgenciaView(agenciaService);
        this.clienteView = new ClienteView(clienteService);
        //this.aluguelView = new AluguelView(aluguelService);
    }

    public void exibirViewPrincipal() {
        while (true) {
            System.out.println("\n===== Menu Principal =====");
            System.out.println("1. Gerenciar Veículos");
            System.out.println("2. Gerenciar Agências");
            System.out.println("3. Gerenciar Clientes");
            System.out.println("4. Aluguel & Devolução");
            System.out.println("5. Sair");
            System.out.println("==========================\n");

            int opcao = ScannerUtil.lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    veiculosView.exibirVeiculosView();
                    break;
                case 2:
                    agenciaView.exibirAgenciaView();
                    break;
                case 3:
                    clienteView.exibirClienteView();
                    break;
                case 4:
                    //aluguelView.exibirAluguelView();
                    break;
                case 5:
                    System.out.println("Encerrando...");
                    return;
                default:
                    ScannerUtil.exibirErro(" opção inválida.");
            }
        }
    }
}