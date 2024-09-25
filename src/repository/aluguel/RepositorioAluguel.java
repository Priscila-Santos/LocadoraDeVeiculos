package repository.aluguel;

import Model.aluguel.Aluguel;
import repository.Repositorio;

import java.util.Optional;

public interface RepositorioAluguel extends Repositorio<Aluguel, String> {
    Optional<Aluguel> buscarPorId(String id);
}
