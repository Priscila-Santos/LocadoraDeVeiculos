package Repository.Agencia;

import Model.Agencia.Agencia;

import java.util.ArrayList;
import java.util.List;

public class AgenciaRepositoryImp implements AgenciaRepository {

    private List<Agencia> agencias = new ArrayList<>();

    @Override
    public void salvar(Agencia agencia) {
        agencias.add(agencia);
        System.out.println("Agencia salva com sucesso!");
    }

    @Override
    public void editar(Agencia agencia) {
        for (int i = 0; i < agencias.size(); i++) {
            if (agencias.get(i).getId() == agencia.getId()) {
                agencias.set(i, agencia);
                System.out.println("Agencia " + agencia.getNome() + " editado com sucesso!");
            } else {
                System.out.println("Agencia " + agencia.getNome() + "não encontrada para edição.");
            }
        }
    }

    @Override
    public List<Agencia> procurarPeloNome(String nome) {
        return List.of(); //método ainda não criado
    }

    @Override
    public List<Agencia> procurarPeloEndereco(String endereco) {
        return List.of(); //método ainda não criado
    }

    @Override
    public Agencia getById(int id) {
        return null; //método ainda não criado
    }
}
