package repository.Agencia;

import Model.Agencia.Agencia;

import java.util.ArrayList;
import java.util.List;

public class AgenciaRepositoryImp implements repository.Agencia.AgenciaRepository {

    private List<Agencia> agencias = new ArrayList<>();

    @Override
    public void salvar(Agencia agencia) {
        agencias.add(agencia);
        System.out.println("Agencia salva com sucesso!");
    }

    @Override
    public void editar(Agencia agencia) {
        boolean existe = false;
        for (int i = 0; i < agencias.size(); i++) {
            if (agencias.get(i).getId() == agencia.getId()) {
                agencias.set(i, agencia);
                System.out.println("Agencia " + agencia.getNome() + " editado com sucesso!");
                existe = true;
                break;
            }
        }
        if (!existe) {
            System.out.println("Agencia " + agencia.getNome() + "não encontrada.");
        }
    }

    @Override
    public List<Agencia> procurarPeloNome(String nome) {
        List<Agencia> agenciasResultado = new ArrayList<>();
        for (Agencia agencia : agencias) {
            if (agencia.getNome().equals(nome)) {
                agenciasResultado.add(agencia);
            }
        }
        return agenciasResultado;
    }

    @Override
    public List<Agencia> procurarPeloEndereco(String endereco) {
        List<Agencia> agenciasResultado = new ArrayList<>();
        for (Agencia agencia : agencias) {
            if (agencia.getEndereco().equals(endereco)) {
                agenciasResultado.add(agencia);
            }
        }
        return agenciasResultado;
    }

    @Override
    public Agencia getById(String id) {
        for (Agencia agencia : agencias) {
            if (agencia.getId().equals(id)) {
                return agencia;
            }
        }
        return null;
    }
}
