package Model.Pessoa;

public class PessoaJuridica extends Cliente {

    private String cnpj;

    public PessoaJuridica(String nome, String telefone, String email, String cnpj) {
        super(nome, telefone, email, TipoCliente.PESSOA_JURIDICA);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "nome='" + getNome() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}
