package Repository.Agencia;

import Model.Agencia.Agencia;

import java.util.*;

public class AgenciaRepositoryImpl implements AgenciaRepository {
    private List<Agencia> agencias = new ArrayList<>();


    public void salvar(Agencia agencia) {
        agencias.add(agencia);
    }

    @Override
    public void editar(Agencia agencia) {

    }

    @Override
    public List<Agencia> procurarPeloNome(String nome) {
        return List.of();
    }

    @Override
    public List<Agencia> procurarPeloEndereco(String endereco) {
        return List.of();
    }

    @Override
    public List<Agencia> listarTodas() {
        return agencias;
    }

    @Override
    public Agencia getById(String id) {
        return null;
    }


}