package timur.task24;

public class FixedPayment extends Payment {
    private Bank bank;

    public FixedPayment(Payment payment,Bank bank) {

        super(payment);
        this.bank = bank;
    }

    @Override
    public void makePayment(long from, long to, double amountOfMoney) {

        bank.decreaseAmountOfAccountMoney(from,amountOfMoney);
        bank.increaseAmountOfAccountMoney(to,amountOfMoney);
        super.makePayment(from, to, amountOfMoney);
    }
}
