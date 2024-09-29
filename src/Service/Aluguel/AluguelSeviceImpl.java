package Service.Aluguel;

import Model.Veiculo.GrupoVeiculo;
import Model.Veiculo.Veiculo;
import Model.Pessoa.*;
import Model.Aluguel.Aluguel;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

public class AluguelSeviceImpl<T extends Veiculo<? extends GrupoVeiculo>, P extends Cliente> implements AluguelService {
    private Aluguel<T, P> aluguel;

    public AluguelSeviceImpl(Aluguel<T, P> aluguel) {
        this.aluguel = aluguel;
        this.aluguel.getVeiculo().setDisponivel(false);
    }

    @Override
    public BigDecimal calcularValorAluguel() {
        long diasAlugados = ChronoUnit.DAYS.between(aluguel.getDataAluguel(), aluguel.getDataDevolucao());
        BigDecimal valorTotal = aluguel.getVeiculo().getValorGrupo().multiply(new BigDecimal(diasAlugados));

        if(aluguel.getPessoa().getTipo() == TipoCliente.PESSOA_FISICA && diasAlugados > 5){
            valorTotal = valorTotal.multiply(BigDecimal.valueOf(0.95));
        } else if (aluguel.getPessoa().getTipo() == TipoCliente.PESSOA_JURIDICA && diasAlugados > 3) {
            valorTotal = valorTotal.multiply(BigDecimal.valueOf(0.90));

        }
        return valorTotal;
    }


    @Override
    public String gerarComprovante() {
        return String.format("""
                ========== Comprovante Aluguel ==========
                Veiculo: %s
                Cliente: %s
                Agencia: %s
                Agencia de Devolução Prevista: %s
                Data de Aluguel: %s
                Data de Devolucao Prevista: %s
                Valor Previsto do Aluguel: %s
                """,aluguel.getVeiculo().getGrupoVeiculo(),
                    aluguel.getPessoa().getNome(),
                    aluguel.getAgencia().getNome(),
                    aluguel.getAgenciaDevolucao().getNome(),
                    aluguel.getDataAluguel().toString(),
                    aluguel.getDataDevolucao().toString(),
                    calcularValorAluguel().toString());

    }
}
