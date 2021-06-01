package entities;
public abstract class Account {
    private String banco;
    private Integer agencia;
    private Integer numero;
    protected double saldo;

    public Account() {}

    public Account(String banco, Integer agencia, Integer numero, double saldo) {
        this.banco = banco;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public abstract double getSaldo();

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Account:"    +
                "banco:'"    + banco     + '\'' +
                ", agencia:" + agencia   +
                ", numero:"  + numero    +
                ", saldo:"   + String.format("%.2f", saldo)
                             +'.';
    }
}
