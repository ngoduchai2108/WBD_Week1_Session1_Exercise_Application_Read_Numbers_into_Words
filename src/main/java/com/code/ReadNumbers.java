package com.code;

import java.util.Scanner;

public class ReadNumbers {
    //How many digits are there?
    public static int countDigits(int n){
        int digits = 1;
        while (n > 10){
            n = n/10;
            digits++;
        }
        return digits;
    }
    public static void main(String[] args) {
        //read numbers from 0 to 20
        String [] arr1 = {"","one","two","three","four","five","six","seven","eight","nine","ten",
        "eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty"};
        //read numbers %10=0
        String [] arr2 = {" "," ","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
        //read numbers
        String [] arr3 = {" "," "," ","hundred","thousand"," ","hundred thousand","million"};
        //start
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int numb = scanner.nextInt();
        int numb0 = numb;
        String readNumbers = "";
        while (numb > 0){
            if (countDigits(numb) < 3 ){
                if (numb != numb0){
                    readNumbers += " and ";
                }
                if (numb <=20){
                    readNumbers += arr1[numb];
                }else {
                    readNumbers += arr2[numb/10]+" "+arr1[numb%10];
                }
                break;
            }else {
                if (countDigits(numb) == 5){
                    int numb2 = numb /1000;
                    numb = numb %1000;
                    if (numb2 <=20){
                        readNumbers += " "+arr1[numb2]+" "+arr3[4];
                    }else {
                        readNumbers += " "+arr2[numb2/10]+" "+arr1[numb2%10]+" "+arr3[4];
                    }
                }else {
                    int numb4 = (int) Math.pow(10,(countDigits(numb)-1));
                    int numb3 = numb /numb4;
                    readNumbers += " "+arr1[numb3] + " "+arr3[countDigits(numb)];
                    numb = numb %numb4;
                }
            }
        }
        System.out.println("Number "+numb0+" is read: "+readNumbers);
    }
}
