package entities;

public class CheckingAccount extends Account implements TributeFees,Transfer{

    public double overdraft;

    public CheckingAccount(double overdraft) {
        this.overdraft = overdraft;
    }

    public CheckingAccount(int agencyNumber, int accNumber, double balance, String bank, double deposit, double withDraw, double overdraft) {
        super(agencyNumber, accNumber, balance, bank, deposit, withDraw);
        this.overdraft = overdraft;
    }

    public boolean getTransfer(){
        if(this.withDraw > getBalance()){
            System.out.println("Not enough funds");
        }
        return true;
    }

    @Override
    public double stealingYourMoney(double amount) {
        return 0.010*amount;
    }

    public int itsPossibleTo(double withDrawAmount){
        if(withDrawAmount <= this.balance)
            return 1;
        else if (withDrawAmount <= getBalance())
            return 2;
        else return 3;
    }


    @Override
    public boolean toWithDraw(double withDrawAmount) {
        switch (itsPossibleTo(withDrawAmount)){
            case 1:
                this.balance -= withDrawAmount;
                this.balance -= stealingYourMoney(withDrawAmount);
                return true;

            case 2:
                withDrawAmount -= this.balance;
                this.balance = 0;
                overdraft -= withDrawAmount;
                this.balance -= stealingYourMoney(withDrawAmount);

            default:
                System.out.println("Not enought founds");
                return false;
        }
    }

    @Override
    public String toString() {
        return super.toString()
                +
                "\nAccount total founds: R$"
                +
                String.format("%.5f",this.balance)
                +
                "\nAccount total overdraft: R$"
                +
                String.format("%.5f",this.overdraft);
    }
}