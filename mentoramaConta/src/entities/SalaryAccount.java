package entities;

public class SalaryAccount extends Account{
    private final int withDrawLimit;
    private int withDraw;



    public SalaryAccount(int withDrawLimit, int withDraw) {
        this.withDrawLimit = withDrawLimit;
        this.withDraw = withDraw;
    }

    public SalaryAccount(String banco, Integer agencia, Integer numero, double saldo, int withDrawLimit, int withDraw) {
        super(banco, agencia, numero, saldo);
        this.withDrawLimit = withDrawLimit;
        this.withDraw = withDraw;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    public void withdrawDone(double amount){
        if(withDrawLimit < withDraw){
            if(amount <= this.getSaldo()){
                this.setSaldo(this.getSaldo() - amount);
                this.withDraw++;
                System.out.println("Amount R$" + String.format("%.2f", this.getSaldo()));
            }else System.out.println("Not enought funds to withdraw");
        }else System.out.println("The amount of withdraw is over");
    }

    public String balanceAvailable(){
        return "\n Available: R$"+this.saldo;
    }

    @Override
    public String toString() {
        return "salaryAccount{" +
                "WithDrawLimit=" + withDrawLimit +
                ", WithDraw=" + withDraw +
                ", saldo=" + String.format("%.2f", this.getSaldo()) +
                '}';
    }

    public String amountOfWithdrawAvailable(){
        return "\nQuantidade de saques" + String.valueOf(this.withDraw - this.withDrawLimit);

    }
}
