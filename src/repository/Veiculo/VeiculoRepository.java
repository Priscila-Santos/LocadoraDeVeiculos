package Repository.Veiculo;

import Model.Veiculo.Veiculo;
import Repository.Repositorio;

import java.util.ArrayList;
import java.util.List;

public class VeiculoRepository implements Repositorio<Veiculo> {
    private List<Veiculo> veiculos = new ArrayList<>();

    @Override
    public void salvar(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    @Override
    public void remover(String placa) {
        Veiculo veiculo = buscarPorPlaca(placa);
        if (veiculo != null) {
            veiculos.remove(veiculo);
            System.out.println("Veículo com placa " + placa + " removido com sucesso.");
        } else {
            System.out.println("Veículo com placa " + placa + " não encontrado.");
        }
    }

    @Override
    public Veiculo buscarPorPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    @Override
    public List<Veiculo> listarTodos() {
        return veiculos;
    }
}
