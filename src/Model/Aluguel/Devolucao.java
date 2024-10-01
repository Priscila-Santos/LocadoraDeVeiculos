package Model.Aluguel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Devolucao {
    private final String id;
    private Aluguel veiculoAluguel;
    private LocalDateTime dataDeDevolucaoFinal;
    private BigDecimal valorAluguelFinal;

    public Devolucao(LocalDateTime dataDeDevolucaoFinal, Aluguel veiculoAluguel, BigDecimal zero) {
        this.id = gerarId();
        this.dataDeDevolucaoFinal = dataDeDevolucaoFinal;
        this.veiculoAluguel = veiculoAluguel;
        this.valorAluguelFinal = BigDecimal.ZERO;
    }

    private String gerarId() {
        return UUID.randomUUID().toString().substring(0, 6);
    }



    public String getId() {
        return id;
    }

    public Aluguel getVeiculoAluguel() {
        return veiculoAluguel;
    }

    public void setVeiculoAluguel(Aluguel veiculoAluguel) {
        this.veiculoAluguel = veiculoAluguel;
    }

    public LocalDateTime getDataDeDevolucaoFinal() {
        return dataDeDevolucaoFinal;
    }

    public void setDataDeDevolucaoFinal(LocalDateTime dataDeDevolucaoFinal) {
        this.dataDeDevolucaoFinal = dataDeDevolucaoFinal;
    }

    public BigDecimal getValorAluguelFinal() {
        return valorAluguelFinal;
    }

    public void setValorAluguelFinal(BigDecimal valorAluguelFinal) {
        this.valorAluguelFinal = valorAluguelFinal;
    }

    @Override
    public String toString() {
        return "Devolucao{id='" + id + "', veiculoAluguel=" + veiculoAluguel +
                ", dataDeDevolucaoFinal=" + dataDeDevolucaoFinal +
                ", valorAluguelFinal=" + valorAluguelFinal + '}';
    }
}
