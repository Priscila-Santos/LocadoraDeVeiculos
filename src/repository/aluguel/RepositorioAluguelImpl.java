package repository.aluguel;

import Model.aluguel.Aluguel;

import java.util.*;

public class RepositorioAluguelImpl implements RepositorioAluguel {
    private Map<String, Aluguel> aluguel = new HashMap<>();

    @Override
    public void salvar(Aluguel aluguel) {
        this.aluguel.put(aluguel.getId(), aluguel);
    }

    @Override
    public Optional<Aluguel> buscarPorId(String id) {
        return Optional.ofNullable(aluguel.get(id));
    }

    @Override
    public void remover(String id) {
        aluguel.remove(id);
    }

    @Override
    public Optional<Aluguel> buscarPorPlaca(String placa) {
        return aluguel.values().stream()
                .filter(aluguel -> aluguel.getVeiculos().stream()
                        .anyMatch(veiculo -> veiculo.getPlaca().equals(placa)))
                .findFirst();
    }

    @Override
    public List<Aluguel> listarTodos() {
        return new ArrayList<>(aluguel.values());
    }
}
