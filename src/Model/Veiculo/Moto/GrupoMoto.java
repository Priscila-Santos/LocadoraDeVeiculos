package Model.Veiculo.Moto;

import Model.Veiculo.GrupoVeiculo;

import java.math.BigDecimal;

public enum GrupoMoto implements GrupoVeiculo {
    CRUISER(BigDecimal.valueOf(300)),
    SPORT(BigDecimal.valueOf(500)),
    TOURING(BigDecimal.valueOf(400)),
    STANDARD(BigDecimal.valueOf(150));

    private final BigDecimal preco;

    GrupoMoto(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public BigDecimal getValor() {
        return preco;
    }
}