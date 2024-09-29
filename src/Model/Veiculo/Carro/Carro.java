package Model.Veiculo.Carro;

import Model.Veiculo.TipoVeiculo;
import Model.Veiculo.Veiculo;

import java.math.BigDecimal;

public class Carro extends Veiculo<GrupoCarro> {

    public Carro(String placa, String modelo, String marca, int anoFabricacao, Boolean disponivel, GrupoCarro grupo) {
        super(placa, modelo, marca, anoFabricacao, disponivel, grupo, grupo.getValor());
    }

    @Override
    public TipoVeiculo getTipoVeiculo() {
        return TipoVeiculo.CARRO;
    }

}