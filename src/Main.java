import Repository.Veiculo.VeiculoRepository;
import Repository.Veiculo.VeiculoRepositoryImp;
import View.ViewPrincipal;
import Service.Cliente.ClienteServiceImpl;
import Service.Veiculo.VeiculoServiceImpl;

public class Main {
    public static void main(String[] args) {
        VeiculoRepository veiculoRepository = new VeiculoRepositoryImp();

        // Instanciando os serviços necessários
        VeiculoServiceImpl veiculoService = new VeiculoServiceImpl(veiculoRepository);
        ClienteServiceImpl clienteService = new ClienteServiceImpl();

        // Iniciando o Menu Principal com os serviços
        ViewPrincipal viewPrincipal = new ViewPrincipal(veiculoService, clienteService);

        viewPrincipal.exibirViewPrincipal();
    }
}
