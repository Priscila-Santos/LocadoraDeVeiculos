package Repository.Agencia;

import Model.Agencia.Agencia;

import java.util.*;

public class AgenciaRepositoryImpl implements AgenciaRepository {
    private final List<Agencia> agencias = new ArrayList<>();

    @Override
    public void salvar(Agencia agencia) {
        agencias.add(agencia);
    }

    @Override
    public void editar(Agencia agenciaAtualizada) {
        for (int i = 0; i < agencias.size(); i++) {
            Agencia agencia = agencias.get(i);

            if (agencia.getId().equals(agenciaAtualizada.getId())) {
                agencias.set(i, agenciaAtualizada);
                System.out.println("Agência editada com sucesso.");
                return;
            }
        }
        System.out.println("Agência não encontrada para edição.");
    }


    @Override
    public void remover(Agencia agencia) {
        agencias.remove(agencia);
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