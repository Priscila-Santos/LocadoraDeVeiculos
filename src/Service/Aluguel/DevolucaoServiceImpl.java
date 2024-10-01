
package Service.Aluguel;

import Model.Aluguel.Aluguel;
import Model.Aluguel.Devolucao;
import Model.Pessoa.TipoCliente;
import Repository.Aluguel.AluguelRepository;
import Repository.Aluguel.DevolucaoRepository;
import Utils.ScannerUtil;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class DevolucaoServiceImpl implements DevolucaoService {
    private final DevolucaoRepository devolucaoRepository;
    private final AluguelRepository aluguelRepository;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public DevolucaoServiceImpl(DevolucaoRepository devolucaoRepository, AluguelRepository aluguelRepository) {
        this.devolucaoRepository = devolucaoRepository;
        this.aluguelRepository = aluguelRepository;
    }

    @Override
    public void registrarDevolucao(Devolucao devolucao) {
        Devolucao devolucaoExistente = devolucaoRepository.getById(devolucao.getId());
        if (devolucaoExistente == null) {
            Aluguel aluguel = devolucao.getVeiculoAluguel();
            if (aluguel != null && !aluguel.getVeiculo().getDisponivel()) {
                aluguel.getVeiculo().setDisponivel(true);
                devolucaoRepository.salvar(devolucao);
                ScannerUtil.exibirSucesso("Devolução registrada com sucesso.");
            } else {
                ScannerUtil.exibirInvalido("Aluguel associado não encontrado ou já devolvido.");
            }
        } else {
            ScannerUtil.exibirInvalido("Devolução com ID " + devolucao.getId() + " já existe.");
        }
    }

    @Override
    public void editarDevolucao(Devolucao devolucao) {
        Devolucao devolucaoExistente = devolucaoRepository.getById(devolucao.getId());
        if (devolucaoExistente != null) {
            devolucaoRepository.editar(devolucao);
            ScannerUtil.exibirSucesso("Devolução editada com sucesso.");
        } else {
            ScannerUtil.exibirInvalido("Devolução com ID " + devolucao.getId() + " não encontrada.");
        }
    }

    @Override
    public void removerDevolucao(String idDevolucao) {
        Devolucao devolucao = devolucaoRepository.getById(idDevolucao);
        if (devolucao != null) {
            devolucaoRepository.remover(devolucao);
            ScannerUtil.exibirSucesso("Devolução removida com sucesso.");
        } else {
            ScannerUtil.exibirInvalido("Devolução com ID " + idDevolucao + " não encontrada.");
        }
    }

    @Override
    public Devolucao getDevolucaoById(String idDevolucao) {
        return devolucaoRepository.getById(idDevolucao);
    }

    @Override
    public List<Devolucao> buscarDevolucaoPorNomeCliente(String nomeCliente) {
        List<Devolucao> devolucoes = devolucaoRepository.procurarPeloNomeCliente(nomeCliente);

        if (devolucoes.isEmpty()) {
            ScannerUtil.exibirInvalido("Nenhuma devolução encontrada para o cliente: " + nomeCliente);
        } else {
            ScannerUtil.exibirSucesso(devolucoes.size() + " devolução(ões) encontrada(s) para o cliente: " + nomeCliente);
            devolucoes.forEach(devolucao -> System.out.println(devolucao));
        }
        return devolucoes;
    }

    @Override
    public void listarDevolucoes() {
        List<Devolucao> devolucoes = devolucaoRepository.listarTodos();
        if (devolucoes.isEmpty()) {
            ScannerUtil.exibirInvalido("Nenhuma devolução cadastrada.");
        } else {
            devolucoes.forEach(devolucao -> System.out.println(devolucao));
        }
    }

    @Override
    public BigDecimal calcularValorAluguel(Devolucao devolucao) {
        Aluguel aluguel = devolucao.getVeiculoAluguel();
        if (aluguel == null) {
            throw new IllegalArgumentException("Aluguel associado à devolução não pode ser nulo.");
        }

        long diasAlugados = ChronoUnit.DAYS.between(aluguel.getDataAluguel(), devolucao.getDataDeDevolucaoFinal());
        BigDecimal valorTotal = aluguel.getVeiculo().getValorGrupo().multiply(BigDecimal.valueOf(diasAlugados));

        if (aluguel.getPessoa().getTipo() == TipoCliente.PESSOA_FISICA && diasAlugados > 5) {
            valorTotal = valorTotal.multiply(BigDecimal.valueOf(0.95));
        } else if (aluguel.getPessoa().getTipo() == TipoCliente.PESSOA_JURIDICA && diasAlugados > 3) {
            valorTotal = valorTotal.multiply(BigDecimal.valueOf(0.90));
        }


        long diasAtraso = ChronoUnit.DAYS.between(aluguel.getDataDevolucao(), devolucao.getDataDeDevolucaoFinal());
        BigDecimal taxaAtraso = BigDecimal.ZERO;
        if (diasAtraso > 0) {
            taxaAtraso = BigDecimal.valueOf(0.01).multiply(BigDecimal.valueOf(diasAtraso));
        }

        BigDecimal valorAluguelFinal = valorTotal.add(taxaAtraso);
        devolucao.setValorAluguelFinal(valorAluguelFinal);
        return valorAluguelFinal;
    }

    @Override
    public String gerarComprovante(Devolucao devolucao) {
        BigDecimal valorTotalAluguel = calcularValorAluguel(devolucao);
        long diasAtraso = ChronoUnit.DAYS.between(devolucao.getVeiculoAluguel().getDataDevolucao(), devolucao.getDataDeDevolucaoFinal());
        BigDecimal taxaAtraso = diasAtraso > 0 ? BigDecimal.valueOf(0.01).multiply(BigDecimal.valueOf(diasAtraso)) : BigDecimal.ZERO;

        return String.format("""
                        ========== Comprovante de Devolução ==========
                        Veículo: %s
                        Cliente: %s
                        Agência de Devolução: %s
                        Data de Aluguel: %s
                        Data de Devolução Prevista: %s
                        Data de Devolução Final: %s
                        Valor da Taxa de Atraso: R$ %.2f
                        Valor Total do Aluguel: R$ %.2f
                        """,
                devolucao.getVeiculoAluguel().getVeiculo().getModelo(),
                devolucao.getVeiculoAluguel().getPessoa().getNome(),
                devolucao.getVeiculoAluguel().getAgenciaDevolucao().getNome(),
                devolucao.getVeiculoAluguel().getDataAluguel().format(formatter),
                devolucao.getVeiculoAluguel().getDataDevolucao().format(formatter),
                devolucao.getDataDeDevolucaoFinal().format(formatter),
                taxaAtraso,
                valorTotalAluguel);
    }
}
