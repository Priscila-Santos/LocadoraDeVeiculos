package Agencia;

public class Endereco {
    private String logradura;
    private int numero;
    private String cidade;
    UF UF;
    private String CEP;

    public String getLogradura() {
        return logradura;
    }

    public void setLogradura(String logradura) {
        this.logradura = logradura;
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
