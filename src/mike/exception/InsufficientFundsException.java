package mike.exception;

/**
 * Created by Devin on 2016/7/12.
 */
public class InsufficientFundsException extends Exception {
    private double amount;
    public InsufficientFundsException(double amount){
        this.amount = amount;
    }
    public double getAmount(){
        return amount;
    }
}
