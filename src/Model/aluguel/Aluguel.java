package Model.aluguel;

import Model.Pessoa.Cliente;
import Model.Veiculo.Veiculo;

import java.time.Instant;
import java.util.List;

public class Aluguel {
    private String id;
    private Cliente cliente;
    private List<Veiculo> veiculo;
    private Integer valor;
    private String local;
    private Instant dataHora;

    public Aluguel(String id, Cliente cliente, List<Veiculo> veiculo, Integer valor, String local, Instant dataHora) {
        this.id = id;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.valor = valor;
        this.local = local;
        this.dataHora = dataHora;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setPessoa(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Veiculo> getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(List<Veiculo> veiculo) {
        this.veiculo = veiculo;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Instant getDataHora() {
        return dataHora;
    }

    public void setDataHora(Instant dataHora) {
        this.dataHora = dataHora;
    }
}
