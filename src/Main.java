import View.VeiculosView;
import View.ViewPrincipal;
import repository.Veiculo.RepositorioVeiculo;
import repository.Veiculo.RepositorioVeiculoImpl;
import service.AluguelService;
import service.ClienteServiceImpl;
import service.VeiculoServiceImpl;

public class Main {
    public static void main(String[] args) {
        RepositorioVeiculo repositorioVeiculo = new RepositorioVeiculoImpl();

        // Instanciando os serviços necessários
        VeiculoServiceImpl veiculoService = new VeiculoServiceImpl(repositorioVeiculo);
        ClienteServiceImpl clienteService = new ClienteServiceImpl();

        // Iniciando o Menu Principal com os serviços
        ViewPrincipal viewPrincipal = new ViewPrincipal(veiculoService, clienteService);

        viewPrincipal.exibirViewPrincipal();
    }
}
