import java.math.RoundingMode;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleBankingApp {

    BankingApp ba = new BankingApp();

    Scanner sc = new Scanner(System.in);

    public ConsoleBankingApp(){

    }

    public void showMenu(){ //this method shows the console user driven menu to navigate using the application

        int option = 99;
        do {
            System.out.println("***Welcome on the Online Banking ".toUpperCase() + ba.customerName.toUpperCase() + "!***".toUpperCase() + "\n\nACCOUNT N.: " + ba.customerId + "\n");

            System.out.println("=====================================================================================");
            System.out.println("1) Check Balance");
            System.out.println("2) Deposit");
            System.out.println("3) Withdraw");
            System.out.println("4) Check last transaction");
            System.out.println("5) Exit");
            System.out.println("=====================================================================================");
            System.out.print("Choose an option: ");
            try {
                option = sc.nextInt();
            }catch(InputMismatchException e){
                sc.next();
            }
            //inputErrorHandling(option);


            switch(option){ //Check balance
                case 1:
                    System.out.println("----------------------------");
                    System.out.println("BANK ACCOUNT N. " + ba.customerId);
                    System.out.println("NAME: " + ba.customerName.toUpperCase());
                    ba.df.setRoundingMode(RoundingMode.UNNECESSARY);
                    System.out.println("Balance: £" + ba.df.format(ba.balance) + "\n");
                    Calendar today = Calendar.getInstance();
                    today.set(Calendar.HOUR_OF_DAY, 0);
                    System.out.println(today.getTime());
                    System.out.println("----------------------------\n");
                    returnToMenu();
                    break;

                case 2: //deposit
                    System.out.println("----------------------------");
                    System.out.print("Enter an amount to deposit: £");
                    double amount = sc.nextDouble();
                    confirmationWindowDeposit(amount, ba.customerId);
                    System.out.println("\n");
                    break;

                case 3: //withdraw
                    System.out.println("----------------------------");
                    System.out.print("Enter an amount to withdraw: £");
                    double amount2 = sc.nextDouble();
                    confirmationWindowWithdrawal(amount2, ba.customerId);
                    System.out.println("\n");
                    break;

                case 4: //check last transaction
                    System.out.println("----------------------------");
                    ba.getPreviousTransaction();
                    System.out.println("----------------------------\n");
                    returnToMenu();
                    break;

                case 5: //exit
                    System.out.println("**************************************");
                    System.out.println("Thank you for using our Online Banking");
                    break;

                default:
                    System.out.println("Invalid input.\n");
                    returnToMenu();
                    break;



            }
        }while (option != 5);
        sc.close();
    }


    //the method below displays a message to confirm the deposit operation. The user can complete it or cancel it.
    public void confirmationWindowDeposit(double amount, String userID){
        System.out.println("£"+ amount + " will be deposited on the account N. "+userID);
        System.out.println("Do you want to confirm? Type 'Y' or 'N' ");
        char choice = sc.next().charAt(0);
        if(choice == 'Y' || choice == 'y'){
            ba.deposit(amount);
            ba.df.setRoundingMode(RoundingMode.UNNECESSARY);
            System.out.println("£"+ ba.df.format(amount) +" has been added to your account.");
            System.out.println("Your balance now is: £" + ba.df.format(ba.balance) + "\n");
            returnToMenu();
        }
        else if(choice == 'N' || choice == 'n'){
            amount = 0;
            ba.deposit(amount);
            showMenu();
        }
        else{
            amount = 0;
            ba.deposit(amount);
            System.out.println("Invalid Choice");
            showMenu();
        }
    }

    //the method below displays a message to confirm the withdrawal operation. The user can complete it or cancel it.
    public void confirmationWindowWithdrawal(double amount, String userID){
        System.out.println("£"+ amount + " will be withdrawn from the account N. "+userID);
        System.out.println("Do you want to confirm? Type 'Y' or 'N'");
        char choice = sc.next().charAt(0);
        if(choice == 'Y' || choice == 'y'){
            ba.withdraw(amount);
            ba.df.setRoundingMode(RoundingMode.UNNECESSARY);
            System.out.println("Your balance now is: £" + ba.df.format(ba.balance) + "\n");
            returnToMenu();
        }
        else if(choice == 'N' || choice == 'n'){
            amount = 0;
            ba.withdraw(amount);
            showMenu();
        }
        else{
            amount = 0;
            ba.withdraw(amount);
            System.out.println("Invalid choice.");
            showMenu();
        }
    }

    public void returnToMenu(){
        System.out.print("Press 'Enter' to return to the Menu.\n");
        sc.nextLine();
        sc.nextLine();
    }

}
