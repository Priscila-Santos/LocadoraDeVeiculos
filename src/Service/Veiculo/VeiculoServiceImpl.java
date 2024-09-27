package Service.Veiculo;

import Model.Veiculo.Veiculo;

import java.util.List;
import java.util.Optional;

public class VeiculoServiceImpl implements VeiculoService {
    private final repository.Veiculo.VeiculoRepository veiculoRepository;

    // Construtor que recebe o repositório como parâmetro
    public VeiculoServiceImpl(repository.Veiculo.VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }


    @Override
    public void cadastrar(Veiculo veiculo) {

    }

    @Override
    public void editar(Veiculo veiculo) {

    }

    @Override
    public Optional<Optional<Veiculo>> buscarPorPlaca(String placa) {
        return Optional.empty();
    }

    @Override
    public List<Veiculo> listarTodos() {
        return List.of();
    }
}
