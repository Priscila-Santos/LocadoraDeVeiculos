package Model.aluguel;

import Model.Agencia.Agencia;
import Model.Pessoa.Cliente;
import Model.Veiculo.GrupoVeiculo;
import Model.Veiculo.Veiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Devolucao <T extends Veiculo<? extends GrupoVeiculo>, P extends Cliente>{
    private Aluguel<T, P> aluguel;
    private LocalDateTime dataDeDevolucaoFinal;

    public Devolucao(LocalDateTime dataDeDevolucaoFinal, Aluguel<T, P> aluguel, BigDecimal valorAluguelFinal) {
        this.dataDeDevolucaoFinal = dataDeDevolucaoFinal;
        this.aluguel = aluguel;
    }

    public Aluguel<T, P> getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel<T, P> aluguel) {
        this.aluguel = aluguel;
    }

    public LocalDateTime getDataDeDevolucaoFinal() {
        return dataDeDevolucaoFinal;
    }

    public void setDataDeDevolucaoFinal(LocalDateTime dataDeDevolucaoFinal) {
        this.dataDeDevolucaoFinal = dataDeDevolucaoFinal;
    }

}
