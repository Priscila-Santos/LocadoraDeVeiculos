package Model.Aluguel;

import Model.Agencia.Agencia;
import Model.Pessoa.Cliente;
import Model.Veiculo.GrupoVeiculo;
import Model.Veiculo.Veiculo;

import java.time.LocalDateTime;
import java.util.UUID;

public class Aluguel <T extends Veiculo<? extends GrupoVeiculo>, P extends Cliente> {
    private T veiculo;
    private P pessoa;
    private Agencia agencia;
    private Agencia agenciaDevolucao;
    private LocalDateTime dataAluguel;
    private LocalDateTime dataDevolucao;
    private String id;

    public Aluguel(T veiculo, P pessoa, Agencia agencia, Agencia agenciaDevolucao, LocalDateTime dataAluguel, LocalDateTime dataDevolucao) {
        this.id = gerarId();
        this.veiculo = veiculo;
        this.pessoa = pessoa;
        this.agencia = agencia;
        this.agenciaDevolucao = agenciaDevolucao;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
    }

    private String gerarId() {
        return UUID.randomUUID().toString().substring(0, 6);
    }

    public String getId() {
        return id;
    }

    public T getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(T veiculo) {
        this.veiculo = veiculo;
    }

    public P getPessoa() {
        return pessoa;
    }

    public void setPessoa(P pessoa) {
        this.pessoa = pessoa;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Agencia getAgenciaDevolucao() {
        return agenciaDevolucao;
    }

    public void setAgenciaDevolucao(Agencia agenciaDevolucao) {
        this.agenciaDevolucao = agenciaDevolucao;
    }

    public LocalDateTime getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(LocalDateTime dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
