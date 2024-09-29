package Model.Veiculo.Caminhao;

import Model.Veiculo.TipoVeiculo;
import Model.Veiculo.Veiculo;

public class Caminhao extends Veiculo<GrupoCaminhao> {

    public Caminhao(String placa, String modelo, String marca, int anoFabricacao, Boolean disponivel, GrupoCaminhao grupo) {
        super(placa, modelo, marca, anoFabricacao, disponivel, grupo, grupo.getValor());
    }

    @Override
    public TipoVeiculo getTipoVeiculo() {
        return TipoVeiculo.CAMINHAO;
    }
}