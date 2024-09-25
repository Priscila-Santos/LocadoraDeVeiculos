package service;

import Model.Veiculo.Veiculo;
import repository.Veiculo.RepositorioVeiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeiculoServiceImpl implements VeiculoService {
    private final RepositorioVeiculo repositorioVeiculo;

    // Construtor que recebe o repositório como parâmetro
    public VeiculoServiceImpl(RepositorioVeiculo repositorioVeiculo) {
        this.repositorioVeiculo = repositorioVeiculo;
    }


    @Override
    public void cadastrar(Veiculo veiculo) {

    }

    @Override
    public void editar(Veiculo veiculo) {

    }

    @Override
    public Optional<Optional<Veiculo>> buscarPorPlaca(String placa) {
        return Optional.empty();
    }

    @Override
    public List<Veiculo> listarTodos() {
        return List.of();
    }
}
