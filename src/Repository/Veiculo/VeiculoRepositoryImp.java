package Repository.Veiculo;

import Model.Veiculo.Veiculo;

import java.util.*;

public class VeiculoRepositoryImp implements VeiculoRepository {
    private List<Veiculo> veiculos = new ArrayList<>();

//    protected void atualizar(Veiculo veiculoParaEditar) throws VeiculoNaoEncontradoException {
//        if (veiculoParaEditar.getId() == null) {
//            throw new VeiculoNaoEncontradoException();
//        }
//
//        Optional<Veiculo> veiculoOpcional = this.buscarPorId(veiculoParaEditar.getId());
//        if (veiculoOpcional.isEmpty()) {
//            throw new VeiculoNaoEncontradoException();
//        }
//
//        Veiculo veiculo = veiculoOpcional.get();
//        veiculo.setPlaca(veiculoParaEditar.getPlaca());
//        veiculo.setTipo(veiculoParaEditar.getTipo());
//    }

//    protected void inserir(Veiculo veiculo) {
//        if (veiculo.getId() == null) {
//            veiculo.setId(UUID.randomUUID().toString());
//        }
//
//        veiculos.add(veiculo);
//    }

//    @Override
//    public void salvar(Veiculo veiculo) {
//        try {
//            atualizar(veiculo);
//        } catch (VeiculoNaoEncontradoException e) {
//            inserir(veiculo);
//        }
//    }

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

//    @Override
//    public Optional<Veiculo> buscarPorId(String id) {
//        return veiculos.stream()
//                .filter(veiculo -> Objects.equals(veiculo.getId(), id))
//                .findFirst();
//    }

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

//    @Override
//    public List<Veiculo> buscarPorTipo(Veiculo.Tipo tipo) {
//        return veiculos.stream()
//                .filter(veiculo -> veiculo.getTipo().equals(tipo))
//                .toList();
//    }
}