package Service.Aluguel;

import Model.Aluguel.Devolucao;
import Model.Pessoa.Cliente;
import Model.Veiculo.GrupoVeiculo;
import Model.Veiculo.Veiculo;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

public class DevolucaoServiceImpl<T extends Veiculo<? extends GrupoVeiculo>, P extends Cliente> implements AluguelService {
    private Devolucao<T, P> devolucao;

    public DevolucaoServiceImpl(Devolucao<T, P> devolucao) {
        this.devolucao = devolucao;
        this.devolucao.getAluguel().getVeiculo().setDisponivel(true);
    }

    public BigDecimal calcularTaxaAtraso() {
        long diasAtraso = ChronoUnit.DAYS.between(devolucao.getAluguel().getDataDevolucao(), devolucao.getDataDeDevolucaoFinal());
        if (diasAtraso > 0) {
            return BigDecimal.valueOf(0.01).multiply(new BigDecimal(diasAtraso));
        }
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal calcularValorAluguel() {
        AluguelSeviceImpl<?, ?> aluguelSevice = new AluguelSeviceImpl<>(devolucao.getAluguel());
        BigDecimal valorTotalAluguel = aluguelSevice.calcularValorAluguel();
        BigDecimal taxaAtraso = calcularTaxaAtraso();

        return valorTotalAluguel.add(taxaAtraso);
    }

    @Override
    public String gerarComprovante() {
        return String.format("""
                        ========== Comprovante de Devolução ==========
                        Veiculo: %s
                        Cliente: %s
                        Agencia de Devolução: %s
                        Data de Aluguel: %s
                        Data de Devolucao Prevista: %s
                        Data de Devolucao Final: %s
                        Valor da Taxa de Atraso: %s
                        Valor Total do Aluguel: %s
                        """,
                devolucao.getAluguel().getVeiculo().getGrupoVeiculo(),
                devolucao.getAluguel().getPessoa().getNome(),
                devolucao.getAluguel().getAgencia().getNome(),
                devolucao.getAluguel().getDataAluguel().toString(),
                devolucao.getAluguel().getDataDevolucao().toString(),
                devolucao.getDataDeDevolucaoFinal().toString(),
                calcularTaxaAtraso().toString(),
                calcularValorAluguel().toString());

    }
}
