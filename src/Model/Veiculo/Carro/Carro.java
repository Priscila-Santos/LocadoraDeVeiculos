package Model.Veiculo.Carro;

import Model.Veiculo.Veiculo;

import java.math.BigDecimal;

public class Carro extends Veiculo<GrupoCarro> {

    public Carro(String placa, String modelo, String marca, int anoFabricacao, Boolean disponivel, GrupoCarro grupo, BigDecimal valor) {
        super(placa, modelo, marca, anoFabricacao, disponivel, grupo, valor);
    }

}