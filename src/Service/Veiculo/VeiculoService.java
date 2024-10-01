package Service.Veiculo;

import Model.Veiculo.TipoVeiculo;
import Model.Veiculo.Veiculo;

import java.util.List;
import java.util.Optional;

public interface VeiculoService {
    void cadastrar(Veiculo veiculo);

    void editar(Veiculo veiculo);

    void remover(String placa);

    Optional<Veiculo> buscarPorPlaca(String placa);

    List<Veiculo> listarTodos();

    List<Veiculo> buscarPorTipo(TipoVeiculo tipo);
}
