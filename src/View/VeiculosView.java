package View;

import Model.Veiculo.Caminhao.Caminhao;
import Model.Veiculo.Caminhao.GrupoCaminhao;
import Model.Veiculo.Carro.Carro;
import Model.Veiculo.Carro.GrupoCarro;
import Model.Veiculo.GrupoVeiculo;
import Model.Veiculo.Moto.GrupoMoto;
import Model.Veiculo.Moto.Moto;
import Model.Veiculo.TipoVeiculo;
import Model.Veiculo.Veiculo;
import Service.Veiculo.VeiculoService;
import Utils.ScannerUtil;

import java.util.Optional;

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
            System.out.println("6. Remover Veículo");
            System.out.println("7. Voltar ao Menu Principal");
            System.out.println("=============================\n");

            int opcao = ScannerUtil.lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarVeiculo();
                    break;
                case 2:
                    editarVeiculo();
                    break;
                case 3:
                    buscarVeiculoPorPlaca();
                    break;
                case 4:
                    buscarVeiculosPorTipo();
                    break;
                case 5:
                    listarVeiculos();
                    break;
                case 6:
                    removerVeiculo();
                    break;
                case 7:
                    return; // Voltar ao menu principal
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void cadastrarVeiculo() {
        TipoVeiculo tipo = escolherTipoVeiculo();

        if (tipo != null) {
            GrupoVeiculo grupo = escolherGrupoPorTipo(tipo);


            if (tipo != null) {
                String placa = ScannerUtil.lerString("Digite a placa do veículo: ");
                String modelo = ScannerUtil.lerString("Digite o modelo do veículo: ");
                String marca = ScannerUtil.lerString("Digite a marca do veículo: ");
                int anoFabricacao = ScannerUtil.lerInteiro("Digite o ano de fabricação: ");

                Veiculo veiculo;

                switch (tipo) {
                    case CARRO:
                        veiculo = new Carro(placa, modelo, marca, anoFabricacao, true, (GrupoCarro) grupo);
                        break;
                    case MOTO:
                        veiculo = new Moto(placa, modelo, marca, anoFabricacao, true, (GrupoMoto) grupo);
                        break;
                    case CAMINHAO:
                        veiculo = new Caminhao(placa, modelo, marca, anoFabricacao, true, (GrupoCaminhao) grupo);
                        break;
                    default:
                        System.out.println("Tipo de veículo inválido");
                        return;
                }

                veiculoService.cadastrar(veiculo);
            }
        }
    }

    private TipoVeiculo escolherTipoVeiculo() {
        System.out.println("Escolha o tipo de veículo:");
        for (TipoVeiculo tipo : TipoVeiculo.values()) {
            System.out.println(tipo.ordinal() + 1 + ". " + tipo);
        }

        int n = ScannerUtil.lerInteiro("Digite o número correspondente ao tipo de veículo: ");

        try {
            return TipoVeiculo.values()[n - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Opção inválida.");
            return null;
        }
    }

    private GrupoVeiculo escolherGrupoPorTipo(TipoVeiculo tipo) {
        GrupoVeiculo[] grupos;

        switch (tipo) {
            case CARRO:
                grupos = GrupoCarro.values();
                break;
            case MOTO:
                grupos = GrupoMoto.values();
                break;
            case CAMINHAO:
                grupos = GrupoCaminhao.values();
                break;
            default:
                return null;
        }

        System.out.println("Escolha o grupo de " + tipo + ":");
        for (int i = 0; i < grupos.length; i++) {
            System.out.println((i + 1) + ". " + grupos[i]);
        }

        int opcao = ScannerUtil.lerInteiro("Digite o número correspondente ao grupo de veículo: ");

        try {
            return grupos[opcao - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Opção inválida.");
            return null;
        }
    }

    private void editarVeiculo() {
        String placa = ScannerUtil.lerString("Digite a placa do veículo que deseja editar: ");
        Optional<Veiculo> veiculoOptional = veiculoService.buscarPorPlaca(placa);

        if (veiculoOptional.isPresent()) {
            Veiculo veiculo = veiculoOptional.get();
            String novoModelo = ScannerUtil.lerString("Digite o novo modelo do veículo: ");
            String novaMarca = ScannerUtil.lerString("Digite a nova marca do veículo: ");
            int novoAnoFabricacao = ScannerUtil.lerInteiro("Digite o novo ano de fabricação: ");

            // Atualizando dados
            veiculo.setModelo(novoModelo);
            veiculo.setMarca(novaMarca);
            veiculo.setAnoFabricacao(novoAnoFabricacao);

            veiculoService.editar(veiculo);
            System.out.println("Veículo atualizado com sucesso.");
        } else {
            System.out.println("Veículo com a placa " + placa + " não encontrado.");
        }
    }

    private void buscarVeiculoPorPlaca() {
        String placa = ScannerUtil.lerString("Digite a placa do veículo: ");
        Optional<Veiculo> veiculoOptional = veiculoService.buscarPorPlaca(placa);

        if (veiculoOptional.isPresent()) {
            Veiculo veiculo = veiculoOptional.get();
            System.out.println("Veículo encontrado:");
            exibirDetalhesVeiculo(veiculo);
        } else {
            System.out.println("Veículo com a placa " + placa + " não encontrado.");
        }
    }

    private void buscarVeiculosPorTipo() {
        TipoVeiculo tipo = escolherTipoVeiculo();

        if (tipo != null) {
            veiculoService.buscarPorTipo(tipo).forEach(this::exibirDetalhesVeiculo);
        }
    }

    private void listarVeiculos() {
        System.out.println("\n/=== Lista de todos os veículos cadastrados ===/");

        veiculoService.listarTodos().forEach(this::exibirDetalhesVeiculo);
        System.out.println("/=== Fim da lista de veículos ===/");
    }

    private void removerVeiculo() {
        String placa = ScannerUtil.lerString("digite a placa do veículo que deseja remover: ");

        Optional<Veiculo> veiculoOptional = veiculoService.buscarPorPlaca(placa);

        if (veiculoOptional.isPresent()) {
            veiculoService.remover(placa);
            //Utils exibir sucesso
            System.out.println("Veículo de placa " + placa + " foi removido com sucesso");
        } else {
            System.out.println("Veículo com a placa " + placa + " não encontrado.");
        }
    }

    private void exibirDetalhesVeiculo(Veiculo veiculo) {
        System.out.println("ID: " + veiculo.getId());
        System.out.println("Placa: " + veiculo.getPlaca());
        System.out.println("Modelo: " + veiculo.getModelo());
        System.out.println("Marca: " + veiculo.getMarca());
        System.out.println("Ano de Fabricação: " + veiculo.getAnoFabricacao());
        System.out.println("Disponível: " + (veiculo.getDisponivel() ? "Sim" : "Não"));
        System.out.println("Grupo: " + veiculo.getGrupoVeiculo());
        System.out.println("Valor: R$ " + veiculo.getValorGrupo());
        System.out.println("------------------------------------------");
    }
}

