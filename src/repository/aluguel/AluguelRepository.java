package Repository.Aluguel;

import Model.Aluguel.Aluguel;
import repository.Repositorio;

import java.util.Optional;

public interface AluguelRepository extends Repositorio<Aluguel, String> {
    Optional<Aluguel> buscarPorId(String id);
}
