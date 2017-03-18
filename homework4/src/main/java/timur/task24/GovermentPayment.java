package timur.task24;

public class GovermentPayment extends Payment {

    private Bank bank;


    public GovermentPayment(Payment payment, Bank bank) {
        super(payment);
        this.bank = bank;
    }


    @Override
    public void makePayment(long from, long to, double amountOfMoney) {

        bank.decreaseAmountOfAccountMoney(from, amountOfMoney * 0.05);
        super.makePayment(from, to, amountOfMoney * 0.05);
    }
}
