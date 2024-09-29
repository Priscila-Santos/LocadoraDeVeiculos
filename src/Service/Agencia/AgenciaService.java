package Service.Agencia;

import Model.Agencia.Agencia;

import java.util.Optional;

public interface AgenciaService {
    void cadastrar(Agencia agencia);

    Optional<Agencia> buscarPorNome(String nome);

    Optional<Agencia> buscarPorLogradouro(String logradouro);

    void listarAgencias();

    void removerAgencia(String agencia);

    void editarAgencia(Agencia agenciaAtualizada);
}