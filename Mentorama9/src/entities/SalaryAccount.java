package entities;

public class SalaryAccount extends Account implements TributeFees {

    private final int withdrawAllowed;
    private int amountOfWithdraw;

    public SalaryAccount(int withdrawAllowed, int amountOfWithdraw) {
        this.withdrawAllowed = withdrawAllowed;
        this.amountOfWithdraw = 0;
    }

    public SalaryAccount(int agencyNumber, int accNumber, double balance, String bank, double deposit, double withDraw, int withdrawAllowed, int amountOfWithdraw) {
        super(agencyNumber, accNumber, balance, bank, deposit, withDraw);
        this.withdrawAllowed = withdrawAllowed;
        this.amountOfWithdraw = 0;
    }

    private boolean ToVerifyAmountOfWithdraw() {
        return this.amountOfWithdraw < this.withdrawAllowed;
    }


    public boolean itsPossibleTo(double withDrawAmount){
        if(ToVerifyAmountOfWithdraw()){
            if
            (withDrawAmount <= this.balance)
                return true;
            else {
                System.out.println("Not enough funds");
                return false;
            }
        }
        else {
            System.out.println("No withdraw available");
            return false;
        }


    }
    public boolean toWithDraw(double withDrawAmount) {
        if(itsPossibleTo(withDrawAmount)){
            this.balance -= withDrawAmount;
            this.balance -= stealingYourMoney(withDrawAmount);
            return true;
        }
        else return false;
    }
    @Override
    public double stealingYourMoney(double amount) {
        return 0.010*amount;
    }

    public boolean getTransfer(){
        if(this.withDraw > getBalance()){
            System.out.println("Not enough funds");
        }
        return true;
    }


    @Override
    public String toString() {
        return super.toString()+ "\nAccount total founds: R$"
                +
                String.format("%.5f",this.getBalance())
                +
                "\nRest of allowed withdraw: R$"
                +
                (this.withdrawAllowed - this.amountOfWithdraw);
    }
}
