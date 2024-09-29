package Model.Veiculo.Moto;

import Model.Veiculo.TipoVeiculo;
import Model.Veiculo.Veiculo;

public class Moto extends Veiculo<GrupoMoto> {

    public Moto(String placa, String modelo, String marca, int anoFabricacao, Boolean disponivel, GrupoMoto grupo) {
        super(placa, modelo, marca, anoFabricacao, disponivel, grupo, grupo.getValor());
    }

    @Override
    public TipoVeiculo getTipoVeiculo() {
        return TipoVeiculo.MOTO;
    }
}