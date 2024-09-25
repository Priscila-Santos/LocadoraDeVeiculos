package repository.Veiculo;

import Model.Veiculo.Veiculo;
import repository.Repositorio;
import java.util.Optional;

public interface RepositorioVeiculo extends Repositorio<Veiculo, String> {
    Optional<Veiculo> buscarPorPlaca(String placa);
    // Buscar por tipo
}
