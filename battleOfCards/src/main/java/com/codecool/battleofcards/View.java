package com.codecool.battleofcards;

import java.util.Scanner;


public class View{
    public static String chooseValueToCompare(){
        System.out.println("which value you want to compare? Bribes, Money or Support");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        if (answer.equalsIgnoreCase("bribes") || answer.equalsIgnoreCase("money")
        || answer.equalsIgnoreCase("support")){
            return answer;
        }
        else {
            System.out.println("Choose one of the options");
        }
        return "";

    }
}