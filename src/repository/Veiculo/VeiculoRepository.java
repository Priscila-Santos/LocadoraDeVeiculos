package Repository.Veiculo;

import Model.Veiculo.Veiculo;
import repository.Repositorio;
import java.util.Optional;

public interface VeiculoRepository extends Repositorio<Veiculo, String> {
    Optional<Veiculo> buscarPorPlaca(String placa);
    // Buscar por tipo
}
