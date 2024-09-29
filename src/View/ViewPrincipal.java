package View;

import Service.Agencia.AgenciaService;
import Service.Cliente.ClienteService;
import Service.Veiculo.VeiculoService;
import Utils.ScannerUtil;

public class ViewPrincipal{
    private final VeiculoService veiculoService;
    private final VeiculosView veiculosView;
    private final AgenciaService agenciaService;
    private final AgenciaView agenciaView;
    //private final ClienteService clienteService;
    //private final MenuClientes menuClientes;
    ///private final MenuAluguel menuAluguel;

    public ViewPrincipal(VeiculoService veiculoService, ClienteService clienteService, AgenciaService agenciaService) {
        this.veiculoService = veiculoService;
        this.veiculosView = new VeiculosView(veiculoService);
        this.agenciaService = agenciaService;
        this.agenciaView = new AgenciaView(agenciaService);
        //this.clienteService = clienteService;
        //this.menuClientes = new MenuClientes(clienteService);
        //this.menuAluguel = new MenuAluguel(aluguelService, veiculoService);
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
                    //menuClientes.exibirMenuClientes();
                    break;
                case 4:
                    //menuAluguel.exibirMenuAluguel();
                    break;
                case 5:
                    System.out.println("Encerrando...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
