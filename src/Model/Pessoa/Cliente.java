package Model.Pessoa;

import java.util.UUID;

public abstract class Cliente {
    String id;
    String nome;
    String telefone;
    String email;

    public Cliente(String nome, String telefone, String email) {
        this.id = gerarId();
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    private String gerarId() {
        return UUID.randomUUID().toString().substring(0, 6);
    }

    public String getId() {
        return id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
