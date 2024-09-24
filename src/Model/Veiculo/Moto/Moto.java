package Model.Veiculo.Moto;

import Model.Veiculo.Veiculo;

import java.math.BigDecimal;

public class Moto extends Veiculo<GrupoMoto> {

    public Moto(String placa, String modelo, String marca, int anoFabricacao, Boolean disponivel, GrupoMoto grupo, BigDecimal valor) {
        super(placa, modelo, marca, anoFabricacao, disponivel, grupo, valor);
    }

}