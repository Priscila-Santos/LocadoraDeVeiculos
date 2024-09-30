import Repository.Agencia.AgenciaRepository;
import Repository.Agencia.AgenciaRepositoryImpl;
import Repository.Aluguel.AluguelRepository;
import Repository.Aluguel.AluguelRepositoryImpl;
import Repository.Aluguel.DevolucaoRepository;
import Repository.Aluguel.DevolucaoRepositoryImpl;
import Repository.Cliente.ClienteRepository;
import Repository.Cliente.ClienteRepositoryImpl;
import Repository.Veiculo.VeiculoRepository;
import Repository.Veiculo.VeiculoRepositoryImp;
import Service.Agencia.AgenciaServiceImpl;
import Service.Aluguel.AluguelServiceImpl;
import Service.Aluguel.DevolucaoServiceImpl;
import Service.Cliente.ClienteServiceImpl;
import Service.Veiculo.VeiculoServiceImpl;
import View.ViewPrincipal;

public class Main {
    public static void main(String[] args) {

        VeiculoRepository veiculoRepository = new VeiculoRepositoryImp();
        ClienteRepository clienteRepository = new ClienteRepositoryImpl();
        AgenciaRepository agenciaRepository = new AgenciaRepositoryImpl();
        AluguelRepository aluguelRepository = new AluguelRepositoryImpl();
        DevolucaoRepository devolucaoRepository = new DevolucaoRepositoryImpl();


        VeiculoServiceImpl veiculoService = new VeiculoServiceImpl(veiculoRepository);
        AgenciaServiceImpl agenciaService = new AgenciaServiceImpl(agenciaRepository);
        ClienteServiceImpl clienteService = new ClienteServiceImpl(clienteRepository);
        AluguelServiceImpl aluguelService = new AluguelServiceImpl(aluguelRepository);
        DevolucaoServiceImpl devolucaoService = new DevolucaoServiceImpl(devolucaoRepository, aluguelRepository);


        ViewPrincipal viewPrincipal = new ViewPrincipal(
                veiculoService,
                agenciaService,
                clienteService,
                aluguelService,
                devolucaoService
        );


        viewPrincipal.exibirViewPrincipal();
    }
}
