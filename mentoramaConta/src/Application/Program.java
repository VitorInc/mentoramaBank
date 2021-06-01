package Application;

import entities.Account;
import entities.CheckingAccount;
import entities.SalaryAccount;
import entities.SavingAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        List<Account> contas = new ArrayList<Account>();


        System.out.println("How many clients do we need? ");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            //C is for checking
            //S is for salary
            //A i for Saving
            System.out.println("Which type of account ?(C/S/A)");
            char type = sc.next().charAt(0);
            if(type == 'C')
            {
                System.out.println("Digit the name of the bank");
                String bank = sc.next();
                System.out.println("Please provide the agency:");
                Integer agencyNmbr = sc.nextInt();
                System.out.println("Please provide the account number:");
                Integer accNmbr = sc.nextInt();
                System.out.println("Inform the ballance:");
                Double accBalance = sc.nextDouble();
                System.out.println("Please informe the overdraft");
                Double accOverDraft = sc.nextDouble();
                CheckingAccount contaCorrente = new CheckingAccount(bank,agencyNmbr,accNmbr,accBalance,accOverDraft);
                contas.add(contaCorrente);
                System.out.println(contaCorrente);

            }
            else if(type == 'S')
            {
                System.out.println("Digit the name of the bank");
                String bank = sc.next();
                System.out.println("Please provide the agency:");
                Integer agencyNmbr = sc.nextInt();
                System.out.println("Please provide the account number:");
                Integer accNmbr = sc.nextInt();
                System.out.println("Inform the ballance:");
                Double accBalance = sc.nextDouble();
                System.out.println("Please digit the account fee:");
                Double accFee = sc.nextDouble();
                System.out.println("Digit the owner BirthDate");
                Integer ownerBirth = sc.nextInt();
                SavingAccount contaPopuanca = new SavingAccount(bank,agencyNmbr,accNmbr,accBalance,accFee,ownerBirth);
                contas.add(contaPopuanca);
                System.out.println(contaPopuanca);
            }

            else if(type == 'A')
            {
                System.out.println("Digit the name of the bank");
                String bank = sc.next();
                System.out.println("Please provide the agency:");
                Integer agencyNmbr = sc.nextInt();
                System.out.println("Please provide the account number:");
                Integer accNmbr = sc.nextInt();
                System.out.println("Inform the ballance:");
                Double accBalance = sc.nextDouble();
                System.out.println("How many withDraw's");
                Integer accWithDraw = sc.nextInt();
                System.out.println("The amount of your withDraw");
                Integer amountWithDraw = sc.nextInt();
                SalaryAccount contaSalario = new SalaryAccount(bank,agencyNmbr,accNmbr,accBalance,accWithDraw,amountWithDraw);
                contas.add(contaSalario);
                System.out.println(contaSalario);

            }

        }

        sc.close();
    }
}
