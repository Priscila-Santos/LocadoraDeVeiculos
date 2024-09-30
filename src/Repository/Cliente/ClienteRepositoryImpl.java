package Repository.Cliente;

import Model.Pessoa.Cliente;
import Utils.ScannerUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClienteRepositoryImpl implements ClienteRepository {
    private final Map<String, Cliente> clientes = new HashMap<>();

    @Override
    public void salvar(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        if (clientes.containsKey(cliente.getId())) {
            clientes.put(cliente.getId(), cliente);
        } else {
            ScannerUtil.exibirInvalido("Cliente não encontrado para edição.");
        }
    }

    @Override
    public void remover(Cliente cliente) {
        clientes.remove(cliente.getId());
    }

    @Override
    public List<Cliente> procurarPeloNome(String nome) {
        return clientes.values().stream()
                .filter(cliente -> cliente.getNome().equalsIgnoreCase(nome))
                .collect(Collectors.toList());
    }

    @Override
    public List<Cliente> listarTodas() {
        return new ArrayList<>(clientes.values());
    }

    @Override
    public Cliente getById(String id) {
        return clientes.get(id);
    }
}
