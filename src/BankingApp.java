/*This class displays a "Welcome" message and allows the user to choose up to 5 options:
"Check Balance", "Deposit money", "Withdraw money", "View last transaction" or "Exit*/
import java.util.Scanner;
import java.text.DecimalFormat;

public class BankingApp { //declares variable

    double balance, previousTransaction;
    String customerName = "John Doe", customerId = "12057903";

    DecimalFormat df = new DecimalFormat("0.00");

    Scanner sc = new Scanner(System.in);

    public BankingApp(){

    }

    public BankingApp(String cName, String cId){ //initialise variables
        customerName = cName;
        customerId = cId;
    }


    public void deposit(double amount){ //this method checks the amount to deposit on the account before operation
        if(amount != 0){
            balance += amount;
            previousTransaction = amount;
        }
    }

    public void withdraw(double amount){ //this method checks the amount to withdraw from the account before operation
        if (amount <= balance) {
            if (amount != 0) {
                balance -= amount;
                previousTransaction = -amount;
                System.out.println("You withdrawn £" + df.format(amount)+ " from your account.");
            }
        }
        else {
            System.out.println("Sorry. This amount exceed your balance.");
        }

    }

    public void getPreviousTransaction(){ /*this method check if some operation occurred and if it was a deposit or a
                                                                                         withdraw operation*/
        if(previousTransaction > 0 ){
            System.out.println("Deposited £:" + df.format(previousTransaction));
        }
        else if(previousTransaction < 0){
            System.out.println("Withdrawn: £" + df.format(Math.abs(previousTransaction)));
        }
        else{
            System.out.println("No transaction occurred");
        }
    }

}
