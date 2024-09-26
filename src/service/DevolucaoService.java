package service;

import Model.Pessoa.Cliente;
import Model.Veiculo.GrupoVeiculo;
import Model.Veiculo.Veiculo;
import Model.aluguel.Devolucao;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

public class DevolucaoService <T extends Veiculo<? extends GrupoVeiculo>, P extends Cliente> {
    private Devolucao<T, P> devolucao;

    public DevolucaoService(Devolucao<T, P> devolucao) {
        this.devolucao = devolucao;
    }

    public BigDecimal calcularValorFinalAluguel(){
        long diasAtraso = ChronoUnit.DAYS.between(devolucao.getAluguel().getDataDevolucao(), devolucao.getDataDeDevolucaoFinal());
        BigDecimal valorTotal = new AluguelSevice<>(devolucao.getAluguel()).calcularValorTotalAluguel();

        if (diasAtraso > 0){
            BigDecimal taxaAtraso = BigDecimal.valueOf(0.005).multiply(new BigDecimal(diasAtraso));
            valorTotal = valorTotal.add(valorTotal.multiply(taxaAtraso));
        }

        return valorTotal;
    }

    public String gerarComprovanteDevolucao() {
        return String.format("""
                ========== Comprovante de Devolução ==========
                Veiculo: %s
                Cliente: %s
                Agencia: %s
                Data de Aluguel: %s
                Data de Devolucao Prevista: %s
                Data de Devolucao Final: %s
                Valor Total do Aluguel: %s
                """,
                devolucao.getAluguel().getVeiculo().getGrupoVeiculo(),
                devolucao.getAluguel().getPessoa().getNome(),
                devolucao.getAluguel().getAgencia().getNome(),
                devolucao.getAluguel().getDataAluguel().toString(),
                devolucao.getAluguel().getDataDevolucao().toString(),
                devolucao.getDataDeDevolucaoFinal().toString(),
                calcularValorFinalAluguel().toString());

    }
}
