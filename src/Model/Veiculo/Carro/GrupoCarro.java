package Model.Veiculo.Carro;

import Model.Veiculo.GrupoVeiculo;

import java.math.BigDecimal;

public enum GrupoCarro implements GrupoVeiculo {
    SEDAN(BigDecimal.valueOf(300)),
    COMPACTO(BigDecimal.valueOf(150)),
    EXECUTIVO(BigDecimal.valueOf(500)),
    INTERMEDIARIO(BigDecimal.valueOf(400));

    private final BigDecimal preco;

    GrupoCarro(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public BigDecimal getValor() {
        return preco;
    }
}