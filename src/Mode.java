import java.util.Scanner;

public class Mode {

    public Mode(){

    }

    public void chooseMode(){
        System.out.println("Choose how to use this application: ");
        System.out.println("1) Console");
        System.out.println("2) GUI");
        Scanner sc = new Scanner(System.in);
        int input = 0;
        input = sc.nextInt();
        if(input == 1){
            ConsoleBankingApp consolebankingapp = new ConsoleBankingApp();
            consolebankingapp.showMenu();
        }
        else if(input == 2){
            GUIBankingApp guiBankingApp = new GUIBankingApp();
            guiBankingApp.MenuWindows();
        }
    }

}
