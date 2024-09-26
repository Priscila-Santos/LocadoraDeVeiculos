package service;

import Model.Agencia.Agencia;
import Model.Veiculo.GrupoVeiculo;
import Model.Veiculo.Veiculo;
import Model.Pessoa.*;
import Model.aluguel.Aluguel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AluguelSevice <T extends Veiculo<? extends GrupoVeiculo>, P extends Cliente>{
    private Aluguel<T, P> aluguel;

    public AluguelSevice(Aluguel<T, P> aluguel) {
        this.aluguel = aluguel;
    }

    public BigDecimal calcularValorTotalAluguel() {
        long diasAlugados = ChronoUnit.DAYS.between(aluguel.getDataAluguel(), aluguel.getDataDevolucao());
        BigDecimal valorTotal = aluguel.getVeiculo().getValorGrupo().multiply(new BigDecimal(diasAlugados));

        if(aluguel.getPessoa().getTipo() == TipoCliente.PESSOA_FISICA && diasAlugados > 5){
            valorTotal = valorTotal.multiply(BigDecimal.valueOf(0.95));
        } else if (aluguel.getPessoa().getTipo() == TipoCliente.PESSOA_JURIDICA && diasAlugados > 3) {
            valorTotal = valorTotal.multiply(BigDecimal.valueOf(0.90));

        }
        return valorTotal;
    }

    public String gerarComprovanteAluguel() {
        return String.format("""
                ========== Comprovante Aluguel ==========
                Veiculo: %s
                Cliente: %s
                Agencia: %s
                Data de Aluguel: %s
                Data de Devolucao: %s
                Valor Total do Aluguel: %s
                """,aluguel.getVeiculo().getGrupoVeiculo(),
                    aluguel.getPessoa().getNome(),
                    aluguel.getAgencia().getNome(),
                    aluguel.getDataAluguel().toString(),
                    aluguel.getDataDevolucao().toString(),
                    calcularValorTotalAluguel().toString());

    }

}
