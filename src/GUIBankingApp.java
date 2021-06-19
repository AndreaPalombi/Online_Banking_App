import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.RoundingMode;

public class GUIBankingApp {

    BankingApp ba = new BankingApp();

    public GUIBankingApp(){

    }

    public GUIBankingApp(String cName, String cID){

    }

    public void confirmationDepositMessageBox(double amount){ //display a message dialog to confirm deposit operation
        JDialog d;
        JFrame f= new JFrame();
        d = new JDialog(f , "Confirmation Message".toUpperCase(), true);
        d.setLayout( new FlowLayout(FlowLayout.CENTER,100,12) );
        JButton b = new JButton ("OK");
        b.addActionListener ( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                d.setVisible(false);
            }
        });
        d.add( new JLabel ("£"+ ba.df.format(amount)));
        ba.df.setRoundingMode(RoundingMode.UNNECESSARY);
        d.add( new JLabel(" successfully added on account N. " + ba.customerId));
        d.add(b);
        d.setSize(350,150);
        d.setLocationRelativeTo(null);
        d.setVisible(true);
        d.toFront();
    }

    public void confirmationWithdrawMessageBox(double amount){ //display a message dialog to confirm withdrawal operation
        JDialog d;
        JFrame f= new JFrame();
        d = new JDialog(f , "Confirmation Message".toUpperCase(), true);
        d.setLayout( new FlowLayout(FlowLayout.CENTER,100,12) );
        JButton b = new JButton ("OK");
        b.addActionListener ( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                d.setVisible(false);
            }
        });
        d.add( new JLabel ("£"+ ba.df.format(amount)));
        ba.df.setRoundingMode(RoundingMode.UNNECESSARY);
        d.add( new JLabel(" successfully withdrawn from account N. " + ba.customerId));
        d.add(b);
        d.setSize(350,150);
        d.setLocationRelativeTo(null);
        d.setVisible(true);
        d.toFront();
    }

    public void numberFormatMessageBox(){ //error handling checking an invalid input
        JDialog d;
        JFrame f= new JFrame();
        d = new JDialog(f , "Error Message".toUpperCase(), true);
        d.setLayout( new FlowLayout(FlowLayout.CENTER,100,20) );
        JButton b = new JButton ("OK");
        b.addActionListener ( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                d.setVisible(false);
            }
        });
        d.add( new JLabel("Invalid amount".toUpperCase()));
        d.add(b);
        d.setSize(200,150);
        d.setLocationRelativeTo(null);
        d.setVisible(true);
        d.toFront();
    }


    public void emptyMessageBox(){ //dialog box if input is null
        JDialog d;
        JFrame f= new JFrame();
        d = new JDialog(f , "Error Message".toUpperCase(), true);
        d.setLayout( new FlowLayout(FlowLayout.CENTER,0,20));
        JButton b = new JButton ("OK");

        b.addActionListener ( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                d.setVisible(false);
            }
        });

        d.add( new JLabel ("Empty field".toUpperCase()));
        d.add(new JLabel ("Please, insert an amount."));
        d.add(b);
        d.setSize(200,200);
        d.setLocationRelativeTo(null);
        d.setVisible(true);
        d.toFront();
    }

    public void exceedAmountMessageBox(){ //dialog box if the amount deposited exceeds the balance
        JDialog d;
        JFrame f= new JFrame();
        d = new JDialog(f , "Error Message".toUpperCase(), true);
        d.setLayout( new FlowLayout(FlowLayout.CENTER,20,20));
        JButton b = new JButton ("OK");

        b.addActionListener ( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                d.setVisible(false);
            }
        });

        d.add( new JLabel ("Sorry, we are unable to complete this transaction"));
        ba.df.setRoundingMode(RoundingMode.UNNECESSARY);
        d.add(new JLabel ("This amount exceed your balance (£: " + ba.df.format(ba.balance)+ ")"));
        d.add(b);
        d.setSize(320,200);
        d.setLocationRelativeTo(null);
        d.setVisible(true);
        d.toFront();
    }

    public void MenuWindows() { //Window displaying the driven menu
        JDialog d;
        JFrame f = new JFrame();

        d = new JDialog(f, "Online Banking Home", true);
        d.setLayout(new FlowLayout(FlowLayout.CENTER,50,12));
        JButton b1 = new JButton("BALANCE");
        JButton b2 = new JButton("DEPOSIT");
        JButton b3 = new JButton("WITHDRAW");
        JButton b4 = new JButton("LAST RECORD");
        JButton b5 = new JButton("EXIT");

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
                balanceWindow();
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
                depositWindow();
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
                withdrawalWindow();
            }
        });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
                latestRecordWindow();
            }
        });

        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
                System.exit(0);
            }
        });

        d.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }

        });

        d.add(new JLabel("*** WELCOME TO THE ONLINE BANKING ***"), SwingConstants.CENTER);
        d.add(new JLabel("Account Holder: ".toUpperCase() + ba.customerName.toUpperCase(),SwingConstants.CENTER));
        d.add(new JLabel("Bank Account N. ".toUpperCase() + ba.customerId.toUpperCase(), SwingConstants.CENTER));


        d.add(b1);
        b1.setPreferredSize(new Dimension(120,30));
        d.add(b2);
        b2.setPreferredSize(new Dimension(120,30));

        d.add(b3);
        b3.setPreferredSize(new Dimension(120,30));

        d.add(b4);
        b4.setPreferredSize(new Dimension(120,30));

        d.add(b5);
        b5.setPreferredSize(new Dimension(120,30));

        d.setSize(300, 350);
        d.setResizable(false);
        d.setLocationRelativeTo(null);
        d.setVisible(true);
        d.toFront();

    }

    public void balanceWindow(){ //Open a new window when "Balance" button is clicked on the menu
        JDialog d;
        JFrame f = new JFrame();
        d = new JDialog(f, "Online Banking - Balance".toUpperCase(), true);
        d.setLayout(new FlowLayout(FlowLayout.CENTER,100,40));

        d.add(new JLabel(("ACCOUNT HOLDER: " + ba.customerName)));
        d.add(new JLabel(("ACCOUNT N. " + ba.customerId)));
        d.add(new JLabel("Current Balance : £" + ba.df.format(ba.balance)));
        ba.df.setRoundingMode(RoundingMode.UNNECESSARY);
        JButton b1 = new JButton("OK");

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
                MenuWindows();
            }
        });

        d.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent evt) {
                d.setVisible(false);
                MenuWindows();
            }

        });

        d.add(b1);
        b1.setPreferredSize(new Dimension(120,30));


        d.setSize(300, 350);
        d.setResizable(false);
        d.setLocationRelativeTo(null);
        d.setVisible(true);
    }

    public void depositWindow(){ //Open a new window when Deposit button is clicked on the menu
        JDialog d;
        JFrame f = new JFrame();
        d = new JDialog(f, "Online Banking - Deposit".toUpperCase(), true);
        d.setLayout(new FlowLayout(FlowLayout.CENTER,35,30));

        d.add(new JLabel(("ACCOUNT HOLDER: " + ba.customerName)));
        d.add(new JLabel(("ACCOUNT N." + ba.customerId)));
        d.add(new JLabel("Deposit amount: £"), BorderLayout.WEST);
        JTextField deposit = new JTextField(5);
        d.add(deposit);
        JButton b1 = new JButton("SUBMIT");
        JButton b2 = new JButton("MENU");

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (deposit.getText().isEmpty()) {
                        emptyMessageBox();
                    } else if (deposit.getText().length() > 10) {
                        deposit.getText().trim();
                    } else {
                        d.setVisible(false);
                        double amount = Double.parseDouble(deposit.getText());
                        depositWindowConfirmation(amount);
                    }
                }catch(NumberFormatException exception){
                    numberFormatMessageBox();
                    depositWindow();
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuWindows();
            }
        });

        d.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent evt) {
                d.setVisible(false);
                MenuWindows();
            }
        });

        d.add(b1);
        d.add(b2);
        b1.setPreferredSize(new Dimension(120,30));
        b2.setPreferredSize(new Dimension(120,30));


        d.setSize(300, 350);
        d.setResizable(false);
        d.setLocationRelativeTo(null);
        d.setVisible(true);
    }

    public void depositWindowConfirmation(double amount){ //Open a dialog box before complete a Deposit operation
        JDialog d;
        JFrame f = new JFrame();
        d = new JDialog(f, "Online Banking - Deposit Confirmation".toUpperCase(), true);
        d.setLayout(new FlowLayout(FlowLayout.CENTER,110,30));

        d.add(new JLabel(("£"+ba.df.format(amount)+ " will be deposit on Account N."+ ba.customerId)));
        ba.df.setRoundingMode(RoundingMode.UNNECESSARY);
        d.add(new JLabel("CONFIRM?"));
        JButton b1 = new JButton("YES");
        JButton b2 = new JButton("NO");

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ba.deposit(amount);
                d.setVisible(false);
                confirmationDepositMessageBox(amount);
                MenuWindows();

            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
                depositWindow();
            }
        });

        d.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent evt) {
                d.setVisible(false);
                MenuWindows();
            }
        });

        d.add(b1);
        d.add(b2);

        d.setSize(350, 250);
        d.setResizable(false);
        d.setLocationRelativeTo(null);
        d.setVisible(true);
    }

    public void withdrawalWindow(){ //Open a new window when "Withdraw" button is clicked on the menu
        JDialog d;
        JFrame f = new JFrame();
        d = new JDialog(f, "Online Banking - Withdraw".toUpperCase(), true);
        d.setLayout(new FlowLayout(FlowLayout.CENTER,35,30));

        d.add(new JLabel(("ACCOUNT HOLDER: " + ba.customerName)));
        d.add(new JLabel(("ACCOUNT N." + ba.customerId)));
        d.add(new JLabel("Withdraw amount: £"), BorderLayout.WEST);
        JTextField withdraw = new JTextField(5);
        d.add(withdraw);
        JButton b1 = new JButton("SUBMIT");
        JButton b2 = new JButton("MENU");

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (withdraw.getText().isEmpty()) {
                        emptyMessageBox();
                    } else if (withdraw.getText().length() > 10) {
                        withdraw.getText().trim();
                    } else {
                        d.setVisible(false);
                        double amount = Double.parseDouble(withdraw.getText());
                        withdrawWindowConfirmation(amount);
                    }
                }catch(NumberFormatException exception){
                    numberFormatMessageBox();
                    withdrawalWindow();
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuWindows();
            }
        });


        d.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent evt) {
                d.setVisible(false);
                MenuWindows();
            }
        });

        d.add(b1);
        d.add(b2);
        b1.setPreferredSize(new Dimension(120,30));
        b2.setPreferredSize(new Dimension(120,30));


        d.setSize(300, 350);
        d.setResizable(false);
        d.setLocationRelativeTo(null);
        d.setVisible(true);
    }

    public void withdrawWindowConfirmation(double amount){ //Open a dialog box before complete a Withdrawal operation
        JDialog d;
        JFrame f = new JFrame();
        d = new JDialog(f, "Online Banking - Withdraw Confirmation".toUpperCase(), true);
        d.setLayout(new FlowLayout(FlowLayout.CENTER,110,30));

        d.add(new JLabel(("£"+ ba.df.format(amount)+" will be withdrawn from Account N."+ ba.customerId)));
        ba.df.setRoundingMode(RoundingMode.UNNECESSARY);
        d.add(new JLabel("CONFIRM?"));
        JButton b1 = new JButton("YES");
        JButton b2 = new JButton("NO");

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(amount > ba.balance){
                    exceedAmountMessageBox();
                    d.setVisible(false);
                    MenuWindows();

                }
                else {
                    ba.withdraw(amount);
                    d.setVisible(false);
                    confirmationWithdrawMessageBox(amount);
                    MenuWindows();
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
                withdrawalWindow();
            }
        });

        d.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent evt) {
                d.setVisible(false);
                MenuWindows();
            }
        });

        d.add(b1);
        d.add(b2);

        d.setSize(350, 250);
        d.setResizable(false);
        d.setLocationRelativeTo(null);
        d.setVisible(true);
    }

    public void latestRecordWindow(){ //Open a window when "Last Record" button is clicked on the menu
        JDialog d;
        JFrame f = new JFrame();
        d = new JDialog(f, "Online Banking - Previous transaction".toUpperCase(), true);
        d.setLayout(new FlowLayout(FlowLayout.CENTER,100,30));

        d.add(new JLabel(("TRANSACTIONS RECORD: ")));
        if(ba.previousTransaction > 0 ) {
            d.add(new JLabel("+£" + ba.df.format(ba.previousTransaction)));
            ba.df.setRoundingMode(RoundingMode.UNNECESSARY);
        }
        else if(ba.previousTransaction < 0){
            d.add(new JLabel("-£"+ ba.df.format(Math.abs(ba.previousTransaction))));
            ba.df.setRoundingMode(RoundingMode.UNNECESSARY);
        }
        else{
            d.add(new JLabel("No transaction occurred"));
        }

        JButton b1 = new JButton("CONFIRM");

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuWindows();
            }
        });

        d.add(b1);

        d.setSize(300, 250);
        d.setResizable(false);
        d.setLocationRelativeTo(null);
        d.setVisible(true);
    }

}
