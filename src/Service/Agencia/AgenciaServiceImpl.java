package Service.Agencia;

import Model.Agencia.Agencia;
import Repository.Agencia.AgenciaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class AgenciaServiceImpl implements AgenciaService {
    private final AgenciaRepository agenciaRepository;

    public AgenciaServiceImpl(AgenciaRepository agenciaRepository) {
        this.agenciaRepository = agenciaRepository;
    }

    @Override
    public void cadastrar(Agencia agencia) {
        Optional<Agencia> agenciaExistente = buscarPorNome(agencia.getNome());
        if (!agenciaExistente.isPresent()) {
            agenciaRepository.salvar(agencia);
            System.out.println("Agência cadastrada com sucesso.");
        } else {
            System.out.println("Agência já está cadastrada.");
        }
    }

    @Override
    public Optional<Agencia> buscarPorNome(String nome) {
        return agenciaRepository.listarTodas()
                .stream()
                .filter(agencia -> agencia.getNome().contains(nome))
                .findFirst();
    }

    @Override
    public Optional<Agencia> buscarPorLogradouro(String logradouro) {
        return agenciaRepository.listarTodas()
                .stream()
                .filter(agencia -> agencia.getEndereco().getLogradouro().contains(logradouro))
                .findFirst();
    }

    @Override
    public void listarAgencias() {
        List<Agencia> agencias = agenciaRepository.listarTodas();
        if (agencias.isEmpty()) {
            System.out.println("Nenhuma agência cadastrada.");
        } else {
            for (Agencia agencia : agencias) {
                System.out.println("ID: " + agencia.getId() + ", Nome: " + agencia.getNome() + ", Endereço: " +
                        agencia.getEndereco().getLogradouro() + ", " + agencia.getEndereco().getNumero() + " - " +
                        agencia.getEndereco().getCidade() + "/" + agencia.getEndereco().getUF() + " - " +
                        agencia.getEndereco().getCEP());
            }
        }
    }

    @Override
    public void removerAgencia(Agencia agencia) {
        agenciaRepository.
    }

    @Override
    public void editarAgencia(String nome, Agencia agenciaAtualizada) {
        Optional<Agencia> procurarAgencia = agenciaRepository.listarTodas()
                .stream()
                .filter(agencia -> agencia.getNome().equalsIgnoreCase(nome))
                .findFirst();

        if (procurarAgencia.isPresent()) {
            Agencia agenciaAtual = procurarAgencia.get();
            agenciaAtual.setNome(agenciaAtualizada.getNome());
            agenciaAtual.setEndereco(agenciaAtualizada.getEndereco());
            System.out.println("Agência editada com sucesso.");
        } else {
            System.out.println("Agência não encontrada.");
        }
    }


}

