package Repository.Veiculo;

import Model.Veiculo.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


public class VeiculoRepositoryImpl implements VeiculoRepository {
    private final List<Veiculo> listaDeVeiculos = new ArrayList<>();


    @Override
    public void salvar(Veiculo veiculo) {
        Optional<Veiculo> veiculoExistente = buscarPorPlaca(veiculo.getPlaca());
        if (veiculoExistente.isPresent()) {
            int index = listaDeVeiculos.indexOf(veiculoExistente.get());
        } else {
            listaDeVeiculos.add(veiculo);
        }
    }

    @Override
    public void remover(String placa) {
        Optional<Veiculo> veiculo = buscarPorPlaca(placa);
        if (veiculo.isPresent()) {
            listaDeVeiculos.remove(veiculo.get());
            System.out.println("Veículo com placa " + placa + " removido com sucesso.");
        } else {
            System.out.println("Veículo com placa " + placa + " não encontrado.");
        }
    }

    @Override
    public Optional<Veiculo> buscarPorPlaca(String placa) {
        return listaDeVeiculos.stream()
                .filter(veiculo -> Objects.equals(veiculo.getPlaca(), placa))
                .findFirst();
    }

    @Override
    public List<Veiculo> listarTodos() {
        return new ArrayList<>(listaDeVeiculos);
    }
}