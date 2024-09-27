package Model.aluguel;

import Model.Agencia.Agencia;
import Model.Pessoa.Cliente;
import Model.Veiculo.GrupoVeiculo;
import Model.Veiculo.Veiculo;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Aluguel <T extends Veiculo<? extends GrupoVeiculo>, P extends Cliente> {
    private T veiculo;
    private P pessoa;
    private Agencia agencia;
    private Agencia agenciaDevolucao;
    private LocalDateTime dataAluguel;
    private LocalDateTime dataDevolucao;

    public Aluguel(T veiculo, P pessoa, Agencia agencia, Agencia agenciaDevolucao, LocalDateTime dataAluguel, LocalDateTime dataDevolucao) {
        this.veiculo = veiculo;
        this.pessoa = pessoa;
        this.agencia = agencia;
        this.agenciaDevolucao = agenciaDevolucao;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
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
