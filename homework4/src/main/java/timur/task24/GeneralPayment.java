package timur.task24;

public class GeneralPayment  extends Payment{

    private Bank bank;

    public GeneralPayment(Payment payment, Bank bank) {
        super(payment);
        this.bank = bank;
    }

    @Override
    public void makePayment(long from, long to, double amountOfMoney) {

        if (!bank.isAccountExist(from) || !bank.isAccountExist(to)){
            throw new IllegalArgumentException("cannot find these accounts");
        }

        if (bank.getMoneyAmount(from) < amountOfMoney || amountOfMoney <= 0){
            throw new IllegalArgumentException("Amount of money Problem");
        }

        super.makePayment(from, to, amountOfMoney);
    }
}
