package Model.Agencia;

import java.util.UUID;

public class Agencia {
    private final String id;
    private String nome;
    private Endereco endereco;

    public Agencia(String id, String nome, Endereco endereco) {
        this.id = gerarId();
        this.nome = nome;
        this.endereco = endereco;
    }

    private String gerarId() {
        return UUID.randomUUID().toString().substring(0, 6);
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Agência [ID: " + id + ", Nome: " + nome + ", Endereço: " + endereco.getLogradouro() +
                ", " + endereco.getNumero() + " - " + endereco.getCidade() + "/" + endereco.getUF() +
                " - " + endereco.getCEP() + "]";
    }
}
