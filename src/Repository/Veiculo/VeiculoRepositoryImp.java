package Repository.Veiculo;

import Model.Veiculo.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class VeiculoRepositoryImp implements VeiculoRepository {
    private final List<Veiculo> veiculos = new ArrayList<>();

































    @Override
    public void salvar(Veiculo elemento) {
    }

    @Override
    public void remover(String placa) {
        Optional<Veiculo> veiculo = buscarPorPlaca(placa);
        if (veiculo.isEmpty()) {
            System.out.println("Veículo com placa " + placa + " não encontrado.");
            return;
        }

        veiculos.remove(veiculo);
        System.out.println("Veículo com placa " + placa + " removido com sucesso.");
    }








    @Override
    public Optional<Veiculo> buscarPorPlaca(String placa) {
        return veiculos.stream()
                .filter(veiculo -> Objects.equals(veiculo.getPlaca(), placa))
                .findFirst();
    }

    @Override
    public List<Veiculo> listarTodos() {
        return veiculos;
    }






//    }
}