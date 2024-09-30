package Service.Veiculo;

import Model.Veiculo.TipoVeiculo;
import Model.Veiculo.Veiculo;
import Repository.Veiculo.VeiculoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VeiculoServiceImpl implements VeiculoService {
    private final VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }


    @Override
    public void cadastrar(Veiculo veiculo) {
        veiculoRepository.salvar(veiculo);
    }

    @Override
    public void editar(Veiculo veiculo) {
        veiculoRepository.salvar(veiculo); // Atualiza o veículo existente
    }

    @Override
    public void remover(String placa) {
        veiculoRepository.remover(placa); // Remove veículo pela placa
    }

    @Override
    public Optional<Veiculo> buscarPorPlaca(String placa) {
        return veiculoRepository.buscarPorPlaca(placa);
    }

    @Override
    public List<Veiculo> listarTodos() {
        return veiculoRepository.listarTodos();
    }

    @Override
    public List<Veiculo> buscarPorTipo(TipoVeiculo tipo) {
        return veiculoRepository.listarTodos().stream()
                .filter(veiculo -> veiculo.getTipoVeiculo().equals(tipo)) // Filtra pelo tipo de veículo
                .collect(Collectors.toList());
    }
}
