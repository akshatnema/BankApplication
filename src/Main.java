// Noob Project created by Akshat Nema

import java.util.Scanner;
import java.util.ArrayList;
import  java.lang.Double;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your 'Name' and 'CustomerId' to access your Bank account:");
        String name=sc.nextLine();
        String customerId=sc.nextLine();
        BankApplication obj1=new BankApplication(name,customerId);
        obj1.menu();
    }
}

class BankApplication {
    private double balance;
    ArrayList<Double> prevTran;
    String customerName;
    String customerID;

    BankApplication(String name, String id){
        this.customerName = name;
        this.customerID = id;
        this.balance = 0.0f;
        this.prevTran = new ArrayList<Double>();
    }

    void deposit(double amount){
        this.balance = this.balance + amount;
        Double temp = new Double(amount);
        prevTran.add(temp);
    }

    void withdraw(double amount){
        if(amount>balance){
            System.out.println("Not sufficient Balance");
        }else{
            balance-=amount;
            Double temp = new Double(amount);
            prevTran.add(-temp);
        }
    }

    void getPreviousTrans(){
        if(prevTran.size()>0){
            for(int i=0;i<prevTran.size();i++){
                if(prevTran.get(i)>0){
                    System.out.format("%d. %f Amount Credited\n", i+1, prevTran.get(i));
                }
                else{
                    System.out.format("%d. %f Amount Debited\n", i+1, -prevTran.get(i));
                }
            }
        }else{
            System.out.println("No Transaction History");
        }
    }
    void menu(){
        char option;
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome "+customerName);
        System.out.println("Your ID:"+ customerID);
        System.out.println("\n");

        do{
            System.out.println("********************************************");
            System.out.println("Choose an option");
            System.out.println("a) Check Balance");
            System.out.println("b) Deposit Amount");
            System.out.println("c) Withdraw Amount");
            System.out.println("d) Previous Transaction");
            System.out.println("e) Exit");
            option=sc.next().charAt(0);
            System.out.println("\n");

            switch (option){
                case 'a':
                    System.out.println("......................");
                    System.out.println("Balance ="+ balance);
                    System.out.println("......................");
                    System.out.println("\n");
                    break;
                case 'b':
                    System.out.println("......................");
                    System.out.println("Enter a amount to deposit :");
                    System.out.println("......................");
                    double amt=sc.nextDouble();
                    deposit(amt);
                    System.out.println("\n");
                    break;
                case 'c':
                    System.out.println("......................");
                    System.out.println("Enter a amount to Withdraw :");
                    System.out.println("......................");
                    double amtW=sc.nextDouble();
                    withdraw(amtW);
                    System.out.println("\n");
                    break;
                case 'd':
                    System.out.println("......................");
                    System.out.println("Previous Transaction:");
                    getPreviousTrans();
                    System.out.println("......................");
                    System.out.println("\n");
                    break;

                case 'e':
                    System.out.println("......................");
                    break;
                default:
                    System.out.println("Choose a correct option to proceed");
                    break;
            }

        }while(option!='e');

        System.out.println("Thank you for using our banking services");
    }
}