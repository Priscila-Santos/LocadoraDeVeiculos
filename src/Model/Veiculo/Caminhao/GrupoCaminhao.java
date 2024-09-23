package Model.Veiculo.Caminhao;

import java.math.BigDecimal;

public enum GrupoCaminhao {
    LEVE(new BigDecimal("200.00")),
    MEDIO(new BigDecimal("300.00")),
    PESADO(new BigDecimal("400.00"));

    private final BigDecimal valor;

    GrupoCaminhao(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
