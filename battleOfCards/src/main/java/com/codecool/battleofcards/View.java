package com.codecool.battleofcards;

import java.util.Scanner;




public class View{
    public static String chooseValueToCompare(){
        System.out.println("which value you want to compare? Bribes, Money or Support");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine().trim();
        if (answer.equals("bribe") || answer.equals("money")
        || answer.equals("support")){

            return answer;
        }
        else {
            System.out.println("Choose one of the options");
        }

        return "";

    }

    public static String getAnswer(){
        System.out.println("do you want play again?");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        return answer;
    }

    public static void makeAPause(Integer miliseconds){
        try{
            Thread.sleep(miliseconds);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}