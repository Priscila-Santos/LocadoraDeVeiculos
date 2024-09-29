import Repository.Agencia.AgenciaRepository;
import Repository.Agencia.AgenciaRepositoryImpl;
import Repository.Veiculo.VeiculoRepository;
import Repository.Veiculo.VeiculoRepositoryImp;
import Service.Agencia.AgenciaServiceImpl;
import View.ViewPrincipal;
import Service.Cliente.ClienteServiceImpl;
import Service.Veiculo.VeiculoServiceImpl;

public class Main {
    public static void main(String[] args) {
        VeiculoRepository veiculoRepository = new VeiculoRepositoryImp();
        AgenciaRepository agenciaRepository = new AgenciaRepositoryImpl();

        // Instanciando os serviços necessários
        VeiculoServiceImpl veiculoService = new VeiculoServiceImpl(veiculoRepository);
        ClienteServiceImpl clienteService = new ClienteServiceImpl();
        AgenciaServiceImpl agenciaService = new AgenciaServiceImpl(agenciaRepository);

        // Iniciando o Menu Principal com os serviços
        ViewPrincipal viewPrincipal = new ViewPrincipal(veiculoService, clienteService, agenciaService);

        viewPrincipal.exibirViewPrincipal();
    }
}
