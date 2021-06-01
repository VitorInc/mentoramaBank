package entities;
public class CheckingAccount extends Account{

private double overdraft;

    public CheckingAccount() {
        super();
    }

    public CheckingAccount(double overdraft) {
        this.overdraft = overdraft;
    }

    public CheckingAccount(String banco, Integer agencia, Integer numero, double saldo, double overdraft) {
        super(banco, agencia, numero, saldo);
        this.overdraft = overdraft;
    }

    public double getSaldo() {
        return this.overdraft + this.saldo;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public String toString() {
        return "CheckingAccount: " +
                "overdraft: " + overdraft +
                ", saldo: " + String.format("%.2f", saldo) +
                '.';
    }


    public void withDraw(double amountWithDraw){
        if(verifyamountWithOutOverDraft(amountWithDraw)){
            withOutOverDraft(amountWithDraw);
            System.out.println("Without over draft, R$:" + String.format("%.2f", this.getSaldo()));
        }
        else if (verifyamountWithOverDraft(amountWithDraw)){
            amountWithOverDraft(amountWithDraw);
            System.out.println("With overdraft, R$:" + String.format("%.2f", this.getSaldo()));
        }
    }

    private void zeroBallance(){
        this.saldo = 0;
    }


    private void amountWithOverDraft(double amountWithDraw){
        amountWithDraw -= this.saldo;
        zeroBallance();
        this.setOverdraft(this.overdraft - amountWithDraw);
    }


    private void withOutOverDraft(double amountWithDraw){
        this.saldo -= amountWithDraw;
    }

    private boolean verifyamountWithOverDraft (double verifyValluer){
        return verifyValluer <= this.getSaldo();
    }

    private boolean verifyamountWithOutOverDraft (double verifyValluer){
        return verifyValluer <= this.getSaldo() - this.overdraft;
    }




    }



