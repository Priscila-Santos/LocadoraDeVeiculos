package service;

import Model.Veiculo.Veiculo;

import java.util.List;
import java.util.Optional;

public interface VeiculoService {
    void cadastrar(Veiculo veiculo);
    void editar(Veiculo veiculo);
    Optional<Optional<Veiculo>> buscarPorPlaca(String placa);
    //List<Veiculo> buscarPorTipo(Veiculo.Tipo tipo);    Implementar o tipo de veiculo
    List<Veiculo> listarTodos();
}
