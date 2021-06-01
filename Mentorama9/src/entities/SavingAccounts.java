package entities;

public class SavingAccounts extends Account implements TributeFees{
    private final int anniversary;
    private final double taxFee;

    public SavingAccounts(int anniversay, double taxFee) {
        this.anniversary = anniversay;
        this.taxFee = taxFee;
    }

    public SavingAccounts(int agencyNumber, int accNumber, double balance, String bank, double deposit, double withDraw, int anniversay, double taxFee) {
        super(agencyNumber, accNumber, balance, bank, deposit, withDraw);
        this.anniversary = anniversay;
        this.taxFee = taxFee;
    }
    public boolean itsPossibleTo(double withDrawAmount){
        return withDrawAmount <= this.balance;
    }

    public boolean getTransfer(){
        if(this.withDraw > getBalance()){
            System.out.println("Not enough funds");
        }
        return true;
    }

    @Override
    public boolean toWithDraw(double withDrawAmount) {
        if(itsPossibleTo(withDrawAmount)){
            this.balance -= withDrawAmount;
            return true;
        }
        return false;
    }

    @Override
    public double stealingYourMoney(double amount) {
        return 0.018*amount;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAvailable funds: R$"+String.format("%.5f", this.balance);
    }
}
