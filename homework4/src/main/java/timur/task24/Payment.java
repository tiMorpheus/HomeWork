package timur.task24;

public abstract class Payment {

    private Payment payment;

    public Payment(Payment payment) {
        this.payment = payment;
    }

    public void makePayment(long from, long to, double amountOfMoney){

        if (payment != null){
            payment.makePayment(from, to, amountOfMoney);
        }
    }
}
