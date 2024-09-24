package Model.Veiculo.Caminhao;

import Model.Veiculo.GrupoVeiculo;
import java.math.BigDecimal;

public enum GrupoCaminhao implements GrupoVeiculo {
    LEVE(BigDecimal.valueOf(300)),
    MEDIO(BigDecimal.valueOf(500)),
    PESADO(BigDecimal.valueOf(800));


    private final BigDecimal preco;

    GrupoCaminhao(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public BigDecimal getValor() {
        return preco;
    }
}