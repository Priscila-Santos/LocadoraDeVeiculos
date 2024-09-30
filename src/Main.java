import Repository.Agencia.AgenciaRepository;
import Repository.Agencia.AgenciaRepositoryImpl;
import Repository.Aluguel.AluguelRepository;
import Repository.Aluguel.AluguelRepositoryImpl;
import Repository.Cliente.ClienteRepository;
import Repository.Cliente.ClienteRepositoryImpl;
import Repository.Veiculo.VeiculoRepository;
import Repository.Veiculo.VeiculoRepositoryImp;
import Service.Agencia.AgenciaServiceImpl;
import Service.Aluguel.AluguelSeviceImpl;
import Service.Cliente.ClienteServiceImpl;
import Service.Veiculo.VeiculoServiceImpl;
import View.ViewPrincipal;

public class Main {
    public static void main(String[] args) {
        VeiculoRepository veiculoRepository = new VeiculoRepositoryImp();
        ClienteRepository clienteRepository = new ClienteRepositoryImpl();
        AgenciaRepository agenciaRepository = new AgenciaRepositoryImpl();


        // Instanciando os serviços necessários
        VeiculoServiceImpl veiculoService = new VeiculoServiceImpl(veiculoRepository);
        AgenciaServiceImpl agenciaService = new AgenciaServiceImpl(agenciaRepository);
        ClienteServiceImpl clienteService = new ClienteServiceImpl(clienteRepository);

        // Iniciando o Menu Principal com os serviços
        ViewPrincipal viewPrincipal = new ViewPrincipal(veiculoService, agenciaService, clienteService);

        viewPrincipal.exibirViewPrincipal();
    }
}
