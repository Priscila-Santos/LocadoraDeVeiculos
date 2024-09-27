package Repository.Aluguel;

import Model.Veiculo.Veiculo;
import Model.Aluguel.Aluguel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AluguelRepositoryImp implements AluguelRepository {
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
    public Optional<Veiculo> buscarPorPlaca(String placa) {
        return null;
    }

    @Override
    public List<Aluguel> listarTodos() {
        return (List<Aluguel>) aluguel.values();
    }
}
