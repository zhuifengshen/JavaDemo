package mike.exception;

/**
 * Created by Devin on 2016/7/12.
 */
public class Bank {
    public static void main(String[] args){
        CheckingAccount checkingAccount = new CheckingAccount(101);
        System.out.println("Depositing $500...");
        checkingAccount.deposit(500);
        try{
            System.out.println("Withdraw 100...");
            checkingAccount.withdraw(100);
            System.out.println(600);
            checkingAccount.withdraw(600);
        }catch (InsufficientFundsException e){
            System.out.println("Sorry, but you are short ￥" + e.getAmount());
            e.printStackTrace();
        }
    }
}
