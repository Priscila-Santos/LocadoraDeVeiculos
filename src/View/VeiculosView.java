package View;

import Service.Veiculo.VeiculoService;
import Utils.ScannerUtil;

public class VeiculosView {
    private final VeiculoService veiculoService;

    public VeiculosView(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    public void exibirVeiculosView() {
        while (true) {
            System.out.println("\n===== Menu de Veículos =====");
            System.out.println("1. Cadastrar Veículo");
            System.out.println("2. Editar Veículo");
            System.out.println("3. Buscar Veículo por Placa");
            System.out.println("4. Buscar Veículos por Tipo");
            System.out.println("5. Listar Todos os Veículos");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.println("=============================\n");

            int opcao = ScannerUtil.lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    //cadastrarVeiculo();
                    break;
                case 2:
                    //editarVeiculo();
                    break;
                case 3:
                    //buscarVeiculoPorPlaca();
                    break;
                case 4:
                    //buscarVeiculosPorTipo();
                    break;
                case 5:
                    listarVeiculos();  // Chamando o método para listar todos os veículos
                    break;
                case 6:
                    return; // Voltar ao menu principal
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

//    private void cadastrarVeiculo() {
//        Veiculo.Tipo tipo = escolherTipoVeiculo();  // Usando o enum de tipo de veículo
//
//        if (tipo != null) {
//            String placa = ScannerUtil.lerString("Digite a placa do veículo: ");
//            String modelo = ScannerUtil.lerString("Digite o modelo do veículo: ");
//
//            Veiculo veiculo = new Veiculo(null, tipo, placa);  // Criando o objeto Veiculo com os dados capturados
//            veiculo.setModelo(modelo);
//            veiculoService.cadastrar(veiculo);  // Passando o veículo para o serviço cadastrar
//        }
//    }
//
//    private void editarVeiculo() {
//        String placa = ScannerUtil.lerString("Digite a placa do veículo que deseja editar: ");
//        Veiculo veiculo = veiculoService.buscarPorPlaca(placa).orElse(null);
//
//        if (veiculo == null) {
//            System.out.println("Veículo não encontrado.");
//            return;
//        }
//
//        Veiculo.Tipo novoTipo = escolherTipoVeiculo();  // Selecionando novo tipo
//
//        if (novoTipo != null) {
//            String novoModelo = ScannerUtil.lerString("Digite o novo modelo: ");
//            veiculo.setTipo(novoTipo);
//            veiculo.setModelo(novoModelo);
//            veiculoService.editar(veiculo);  // Passando o veículo editado para o serviço editar
//        }
//    }

//    private void buscarVeiculoPorPlaca() {
//        String placa = ScannerUtil.lerString("Digite a placa do veículo: ");
//        Veiculo veiculo = veiculoService.buscarPorPlaca(placa).orElse(null);
//
//        if (veiculo != null) {
//            System.out.println(veiculo);  // Exibindo o veículo com o novo toString
//        } else {
//            System.out.println("Veículo não encontrado.");
//        }
//    }

//    private void buscarVeiculosPorTipo() {
//        Veiculo.Tipo tipo = escolherTipoVeiculo();  // Selecionando tipo de veículo
//
//        if (tipo != null) {
//            veiculoService.buscarPorTipo(tipo).forEach(System.out::println);  // Listando veículos encontrados por tipo
//        }
//    }

    private void listarVeiculos() {
        System.out.println("/=== Lista de todos os veículos cadastrados ===/");

        veiculoService.listarTodos().forEach(veiculo -> {
            System.out.println(veiculo);
        });
    }

//    private Veiculo.Tipo escolherTipoVeiculo() {
//        System.out.println("Escolha o tipo de veículo:");
//        for (Veiculo.Tipo tipo : Veiculo.Tipo.values()) {
//            System.out.println(tipo.ordinal() + 1 + ". " + tipo);
//        }
//
//        int n = ScannerUtil.lerInteiro("Digite o número correspondente ao tipo de veículo: ");
//
//        try {
//            return Veiculo.Tipo.values()[n - 1];
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Opção inválida.");
//            return null;
//        }
//    }
}
