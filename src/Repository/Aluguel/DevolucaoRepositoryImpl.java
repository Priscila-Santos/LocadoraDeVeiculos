
package Repository.Aluguel;

import Model.Aluguel.Devolucao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DevolucaoRepositoryImpl implements DevolucaoRepository {
    private final List<Devolucao> devolucoes = new ArrayList<>();

    @Override
    public void salvar(Devolucao devolucao) {
        devolucoes.add(devolucao);
    }

    @Override
    public void editar(Devolucao devolucao) {
        remover(devolucao);
        salvar(devolucao);
    }

    @Override
    public void remover(Devolucao devolucao) {
        devolucoes.removeIf(d -> d.getId().equals(devolucao.getId()));
    }

    @Override
    public Devolucao getById(String id) {
        return devolucoes.stream()
                .filter(devolucao -> devolucao.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Devolucao> listarTodos() {
        return new ArrayList<>(devolucoes);
    }

    @Override
    public List<Devolucao> procurarPeloNomeCliente(String nomeCliente) {
        return devolucoes.stream()
                .filter(devolucao -> devolucao.getVeiculoAluguel().getPessoa().getNome().equalsIgnoreCase(nomeCliente))
                .collect(Collectors.toList());
    }
}
