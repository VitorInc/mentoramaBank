package entities;

public class SavingAccount extends Account {
    private double taxsFee;
    private int birth;

    public SavingAccount(){
        super();
    }

    public SavingAccount(double taxsFee, int nascimento) {
        this.taxsFee = taxsFee;
        birth = nascimento;
    }

    public SavingAccount(String banco, Integer agencia, Integer numero, double saldo, double taxsFee, int nascimento) {
        super(banco,agencia, numero, saldo);
        this.taxsFee = taxsFee;
        birth = nascimento;
    }

    public double getTaxsFee() {
        return taxsFee;
    }

    public void setTaxsFee(double taxsFee) {
        this.taxsFee = taxsFee;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int nascimento) {
        birth = nascimento;
    }

    @Override
    public double getSaldo() {
        return this.saldo + this.taxsFee * saldo;
    }


    public void saque(double saqueValor){
        if(saqueValor <= this.saldo){
            this.saldo -= saqueValor;
            System.out.println("The balance is R$:" + String.format("%.2f", this.getSaldo()));
        }
    }
    public String ballanceAcc() {
        return "\n Ballance in yout acc is: R$" + this.getSaldo();
    }

    @Override
    public String toString() {
        return "savingsAccount:"     +
                "taxsFee=" + taxsFee +
                ", Birth=" + birth   +
                ", saldo=" + String.format("%.2f", saldo) +
                '.';
    }
}
