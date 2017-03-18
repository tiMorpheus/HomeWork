package timur.task24;

public class InnerBankPayment extends Payment {

    private Bank bank;
    private Double tax;

    public InnerBankPayment(Payment payment, Bank bank) {
        super(payment);
        this.bank = bank;
        this.tax = bank.getBankTax();
    }

    @Override
    public void makePayment(long from, long to, double amountOfMoney) {

        bank.decreaseAmountOfAccountMoney(from, amountOfMoney * (1+tax));

        super.makePayment(from, to, amountOfMoney * (1+tax));
    }
}
