
package Repository.Aluguel;

import Model.Aluguel.Aluguel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AluguelRepositoryImpl implements AluguelRepository {
    private final List<Aluguel> alugueis = new ArrayList<>();

    @Override
    public void salvar(Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    @Override
    public void editar(Aluguel aluguel) {
        remover(aluguel);
        salvar(aluguel);
    }

    @Override
    public void remover(Aluguel aluguel) {
        alugueis.removeIf(a -> a.getId().equals(aluguel.getId()));
    }

    @Override
    public Aluguel getById(String id) {
        return alugueis.stream()
                .filter(aluguel -> aluguel.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Aluguel> listarTodos() {
        return new ArrayList<>(alugueis);
    }

    @Override
    public List<Aluguel> procurarPeloNomeCliente(String nomeCliente) {
        return alugueis.stream()
                .filter(aluguel -> aluguel.getPessoa().getNome().equalsIgnoreCase(nomeCliente))
                .collect(Collectors.toList());
    }
}
