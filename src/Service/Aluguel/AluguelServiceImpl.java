
package Service.Aluguel;

import Model.Aluguel.Aluguel;
import Model.Pessoa.TipoCliente;
import Repository.Aluguel.AluguelRepository;
import Utils.ScannerUtil;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class AluguelServiceImpl implements AluguelService {
    private final AluguelRepository aluguelRepository;

    public AluguelServiceImpl(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    @Override
    public void cadastrarAluguel(Aluguel aluguel) {
        Aluguel aluguelExistente = aluguelRepository.getById(aluguel.getId());
        if (aluguelExistente == null) {
            aluguel.getVeiculo().setDisponivel(false);
            aluguelRepository.salvar(aluguel);
            ScannerUtil.exibirSucesso("Aluguel cadastrado com sucesso.");
        } else {
            ScannerUtil.exibirInvalido("Aluguel com ID " + aluguel.getId() + " já existe.");
        }
    }

    @Override
    public void editarAluguel(Aluguel aluguel) {
        Aluguel aluguelExistente = aluguelRepository.getById(aluguel.getId());
        if (aluguelExistente != null) {
            aluguelRepository.editar(aluguel);
            ScannerUtil.exibirSucesso("Aluguel editado com sucesso.");
        } else {
            ScannerUtil.exibirInvalido("Aluguel com ID " + aluguel.getId() + " não encontrado.");
        }
    }

    @Override
    public void removerAluguel(String idAluguel) {
        Aluguel aluguel = aluguelRepository.getById(idAluguel);
        if (aluguel != null) {
            aluguel.getVeiculo().setDisponivel(true);
            aluguelRepository.remover(aluguel);
            ScannerUtil.exibirSucesso("Aluguel removido com sucesso.");
        } else {
            ScannerUtil.exibirInvalido("Aluguel com ID " + idAluguel + " não encontrado.");
        }
    }

    @Override
    public Aluguel getAluguelById(String idAluguel) {
        return aluguelRepository.getById(idAluguel);
    }

    @Override
    public List<Aluguel> buscarAluguelPorNomeCliente(String nomeCliente) {
        List<Aluguel> alugueis = aluguelRepository.procurarPeloNomeCliente(nomeCliente);

        if (alugueis.isEmpty()) {
            ScannerUtil.exibirInvalido("Nenhum aluguel encontrado para o cliente: " + nomeCliente);
        } else {
            ScannerUtil.exibirSucesso(alugueis.size() + " aluguel(is) encontrado(s) para o cliente: " + nomeCliente);
            alugueis.forEach(aluguel -> System.out.println(aluguel));
        }
        return alugueis;
    }

    @Override
    public void listarAlugueis() {
        List<Aluguel> alugueis = aluguelRepository.listarTodos();
        if (alugueis.isEmpty()) {
            ScannerUtil.exibirInvalido("Nenhum aluguel cadastrado.");
        } else {
            alugueis.forEach(aluguel -> System.out.println(aluguel));
        }
    }

    @Override
    public BigDecimal calcularValorAluguel(Aluguel aluguel) {
        long diasAlugados = ChronoUnit.DAYS.between(aluguel.getDataAluguel(), aluguel.getDataDevolucao());
        BigDecimal valorTotal = aluguel.getVeiculo().getValorGrupo().multiply(BigDecimal.valueOf(diasAlugados));

        if (aluguel.getPessoa().getTipo() == TipoCliente.PESSOA_FISICA && diasAlugados > 5) {
            valorTotal = valorTotal.multiply(BigDecimal.valueOf(0.95));
        } else if (aluguel.getPessoa().getTipo() == TipoCliente.PESSOA_JURIDICA && diasAlugados > 3) {
            valorTotal = valorTotal.multiply(BigDecimal.valueOf(0.90));
        }
        return valorTotal;
    }

    @Override
    public String gerarComprovante(Aluguel aluguel) {
        BigDecimal valorAluguel = calcularValorAluguel(aluguel);
        return String.format("""
                        ========== Comprovante Aluguel ==========
                        Veículo: %s
                        Cliente: %s
                        Agência de Aluguel: %s
                        Agência de Devolução Prevista: %s
                        Data de Aluguel: %s
                        Data de Devolução Prevista: %s
                        Valor Previsto do Aluguel: R$ %.2f
                        """,
                aluguel.getVeiculo().getModelo(),
                aluguel.getPessoa().getNome(),
                aluguel.getAgencia().getNome(),
                aluguel.getAgenciaDevolucao().getNome(),
                aluguel.getDataAluguel(),
                aluguel.getDataDevolucao(),
                valorAluguel);
    }
}
