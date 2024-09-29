package Repository.Agencia;

import Model.Agencia.Agencia;

import java.util.List;

public interface AgenciaRepository {

    void salvar(Agencia agencia);
    void editar(Agencia agencia);
    void remover(Agencia agencia);
    List<Agencia> procurarPeloNome(String nome);
    List<Agencia> procurarPeloEndereco(String endereco);
    List<Agencia> listarTodas();
    Agencia getById(String id);
}
