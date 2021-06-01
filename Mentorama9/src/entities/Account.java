package entities;
public abstract class Account implements Transfer {

    private int agencyNumber;
    private int accNumber;
    protected double balance;
    private String bank;
    private double deposit;
    protected double withDraw;

    public Account() {}

    public Account(int agencyNumber, int accNumber, double balance, String bank, double deposit, double withDraw) {
        this.agencyNumber = agencyNumber;
        this.accNumber = accNumber;
        this.balance = balance;
        this.bank = bank;
        this.deposit = deposit;
        this.withDraw = withDraw;
    }

    public int getAgencyNumber() {
        return agencyNumber;
    }

    public void setAgencyNumber(int agencyNumber) {
        this.agencyNumber = agencyNumber;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBank() {
        return bank;
    }
    public boolean getTransfer(){
        if(this.withDraw > getBalance()){
            System.out.println("Not enough funds");
        }
        return true;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getWithDraw() {
        return withDraw;
    }

    public void setWithDraw(double withDraw) {
        this.withDraw = withDraw;
    }

    @Override
    public String toString() {
        return "Account{" +
                "agencyNumber=" + agencyNumber +
                ", accNumber=" + accNumber +
                ", balance=" + balance +
                ", bank='" + bank + '\'' +
                ", deposit=" + deposit +
                ", withDraw=" + withDraw +
                '}';
    }

    public abstract boolean toWithDraw(double withDrawAmount) ;

    public boolean toDeposit(double depositAmount) {
        try{
            this.balance =+ depositAmount;
            return true;
        } catch (NullPointerException e){
            System.out.println("Erro: "+e);
            return false;
        }
    }
}