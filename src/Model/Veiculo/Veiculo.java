package Model.Veiculo;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

public abstract class Veiculo<T extends GrupoVeiculo> {

    protected String id;
    protected String placa;
    protected String modelo;
    protected String marca;
    protected int anoFabricacao;
    protected Boolean disponivel;
    protected T grupo;
    protected BigDecimal valor;

    public Veiculo(String placa, String modelo, String marca, int anoFabricacao, Boolean disponivel, T grupo, BigDecimal valor) {
        this.id = gerarId();
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.disponivel = disponivel;
        this.grupo = grupo;
        this.valor = grupo.getValor();
    }

    public BigDecimal getValorGrupo() {
        return grupo.getValor();
    }

    private String gerarId() {
        return UUID.randomUUID().toString().substring(0, 6);
    }


    public String getId() { return id; }

    public String getPlaca() { return placa; }

    public void setPlaca(String placa) { this.placa = placa; }

    public String getModelo() { return modelo; }

    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getMarca() { return marca; }

    public void setMarca(String marca) { this.marca = marca; }

    public int getAnoFabricacao() { return anoFabricacao; }

    public void setAnoFabricacao(int anoFabricacao) { this.anoFabricacao = anoFabricacao; }

    public Boolean getDisponivel() { return disponivel; }

    public void setDisponivel(Boolean disponivel) { this.disponivel = disponivel; }

    public T getGrupoVeiculo() { return grupo; }

    public void setGrupoVeiculo(T grupo) { this.grupo = grupo; }
}