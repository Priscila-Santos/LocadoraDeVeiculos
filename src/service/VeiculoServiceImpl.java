package service;

import Model.Veiculo.TipoVeiculo;
import Model.Veiculo.Veiculo;
import repository.Veiculo.RepositorioVeiculo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VeiculoServiceImpl implements VeiculoService {
    private final RepositorioVeiculo repositorioVeiculo;

    //Construtor
    public VeiculoServiceImpl(RepositorioVeiculo repositorioVeiculo) {
        this.repositorioVeiculo = repositorioVeiculo;
    }


    @Override
    public void cadastrar(Veiculo veiculo) {
        repositorioVeiculo.salvar(veiculo);
    }

    @Override
    public void editar(Veiculo veiculo) {
        repositorioVeiculo.salvar(veiculo);
    }

    @Override
    public void remover(String placa) {
        repositorioVeiculo.remover(placa);
    }

    @Override
    public Optional<Veiculo> buscarPorPlaca(String placa) {
        return repositorioVeiculo.buscarPorPlaca(placa);
    }

    @Override
    public List<Veiculo> buscarPorTipo(TipoVeiculo tipo) {
        return repositorioVeiculo.listarTodos().stream()
                .filter(veiculo -> veiculo.getTipoVeiculo().equals(tipo))  // Filtra os veículos pelo tipo
                .collect(Collectors.toList());
    }

    @Override
    public List<Veiculo> listarTodos() {
        return repositorioVeiculo.listarTodos();
    }
}
