package Model.Agencia;

public class Endereco {
    private String logradouro;
    private int numero;
    private String cidade;
    private UF UF;
    private String CEP;

    public Endereco(String logradouro, int numero, String cidade, UF uf, String CEP) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.UF = uf;
        this.CEP = CEP;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public UF getUF() {
        return UF;
    }

    public void setUF(UF UF) {
        this.UF = UF;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
}
