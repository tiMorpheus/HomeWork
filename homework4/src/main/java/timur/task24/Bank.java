package timur.task24;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<Long, Double> accounts;
    private Double bankTax = 0.01;

    private Payment normalPayment;
    private Payment innerBankPayment;
    private Payment govermentPayment;
    private Payment specialPayment;

    public Bank() {
        normalPayment = new FixedPayment(null, this);
        normalPayment = new GovermentPayment(normalPayment, this);
        normalPayment = new InnerBankPayment(normalPayment, this);
        normalPayment = new GeneralPayment(normalPayment, this);

        innerBankPayment = new FixedPayment(null,this);
        innerBankPayment = new InnerBankPayment(innerBankPayment, this);
        innerBankPayment = new GeneralPayment(innerBankPayment, this);

        govermentPayment = new FixedPayment(null, this);
        govermentPayment = new GovermentPayment(govermentPayment, this);
        govermentPayment = new GeneralPayment(govermentPayment, this);

        accounts = new HashMap<>();
    }

    public boolean isAccountExist(long id){
        return accounts.containsKey(id);
    }

    public Double getBankTax() {
        return bankTax;
    }

    public void setBankTax(Double bankTax) {
        this.bankTax = bankTax;
    }

    public void createAccount(long accountId, double amountOfMoney) {
        accounts.put(accountId, amountOfMoney);
    }

    public Double getMoneyAmount(long accountId) {
        return accounts.get(accountId);
    }

    public void decreaseAmountOfAccountMoney(long accountId, double amountOfMoney) {

        if (accounts.get(accountId) == null){
            throw new IllegalArgumentException();
        }

        double money = accounts.get(accountId) - amountOfMoney;

        if (money < 0){
            throw new IllegalArgumentException("Warning!! negative amountOfMoney");
        }

        accounts.put(accountId, money);
    }

    public void increaseAmountOfAccountMoney(long accountId, double amountOfMoney) {
        if (accounts.get(accountId) == null){
            throw new IllegalArgumentException();
        }

        double money = accounts.get(accountId) + amountOfMoney;

        accounts.put(accountId, money);
    }



}
