package Model.Pessoa;

import java.util.UUID;

public abstract class Cliente {
    protected String id;
    protected String nome;
    protected String telefone;
    protected String email;
    protected TipoCliente tipo;

    public Cliente(String nome, String telefone, String email, TipoCliente tipo) {
        this.id = gerarId();
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.tipo = tipo;
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

    public TipoCliente getTipo() {
        return tipo;
    }

}
