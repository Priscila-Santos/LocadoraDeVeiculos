package Model.Veiculo.Caminhao;

import Model.Veiculo.Veiculo;

import java.math.BigDecimal;

public class Caminhao extends Veiculo<GrupoCaminhao> {

    public Caminhao(String placa, String modelo, String marca, int anoFabricacao, Boolean disponivel, GrupoCaminhao grupo, BigDecimal valor) {
        super(placa, modelo, marca, anoFabricacao, disponivel, grupo, valor);
    }

}