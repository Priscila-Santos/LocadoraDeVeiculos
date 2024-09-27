package repository.aluguel;

import Model.aluguel.Aluguel;

import java.util.*;

public class RepositorioAluguelImpl implements RepositorioAluguel {
    private Map<String, Aluguel> alugueis = new HashMap<>();

    @Override
    public void salvar(Aluguel aluguel) {
        alugueis.put(aluguel.getId(), aluguel);
    }

    @Override
    public Optional<Aluguel> buscarPorId(String id) {
        return Optional.ofNullable(alugueis.get(id));
    }

    @Override
    public void remover(String id) {
        alugueis.remove(id);
    }

    @Override
    public Optional<Aluguel> buscarPorPlaca(String placa) {
        return alugueis.values().stream()
                .filter(aluguel -> aluguel.getVeiculo().equals(placa))
                .findFirst();
    }

    @Override
    public List<Aluguel> listarTodos() {
        return new ArrayList<>(alugueis.values());
    }
}
