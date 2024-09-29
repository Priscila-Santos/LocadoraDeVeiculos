package Model.Pessoa;

public class PessoaFisica extends Cliente {

    private String cpf;

    public PessoaFisica(String nome, String telefone, String email, String cpf) {
        super(nome, telefone, email, TipoCliente.PESSOA_FISICA);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
