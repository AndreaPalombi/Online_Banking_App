/*This application represents a small ATM simulator. User can choose to use it on console or GUI*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Mode mode = new Mode();
        mode.chooseMode();

        //ConsoleBankingApp consolebankingApp = new ConsoleBankingApp();
        //GUIBankingApp guibankingApp = new GUIBankingApp();

        //consolebankingApp.showMenu(); /*to start console application*/

        //guibankingApp.MenuWindows(); /*to start GUI application*/


    }


}
