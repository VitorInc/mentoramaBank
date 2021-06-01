package Application;

import entities.*;

import java.util.*;

public class Program {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);

        Client first = new Client("Joanelina",7,true,"789");
        Client second = new Client("Ribonoscleiton",5,true,"456");
        Client third = new Client("Ramirinaldo",9,true,"741");
        Client fourth = new Client("Branisleison",12,true,"298");
        Client fifth = new Client("Cleivimanso",1,true,"583");
        Client sixth = new Client("Amirivaldo",1,true,"465");
        Client seventh = new Client("Candimilso",3,true,"826");
        Client eighth = new Client("Vladisnanis",4,true,"135");
        Client nineth = new Client("Vascalino",8,true,"798");
        Client tenth = new Client("Fermisney",2,true,"137");

        List<Client> clients = Arrays.asList(first,second,third,fourth,fifth,sixth,seventh,eighth,nineth,tenth);

        Client maxShops = clients.stream().max(Comparator.comparing(Client::getShoppings)).orElseThrow(NoSuchElementException::new);
        System.out.println(maxShops);

        Client minShops = clients.stream().min(Comparator.comparing(Client::getShoppings)).orElseThrow(NoSuchElementException::new);
        System.out.println(minShops);

        OptionalDouble avgShops = clients.stream().mapToInt(Client::getShoppings).average();
        System.out.println(avgShops);


        /**


        int i = 1;
        boolean bankAppilcation = true;
        Account acc[] = new Account[3];
        HashMap<Integer, Account> accHS = new HashMap<>();
        accHS.put(1, new CheckingAccount(1, 1, 1000.0, "WhatEverBank", 0, 0, 100.00));
        accHS.put(2, new SalaryAccount(2, 2, 3000.0, "WhatEverBank", 0, 0, 5, 0));
        accHS.put(3, new SavingAccounts(3, 3, 1000.0, "WhatEverBank", 1.000, 0.0, 25, 0.08));

        acc[0] = accHS.get(1);
        acc[1] = accHS.get(2);
        acc[2] = accHS.get(3);

        Double bankAmount = acc[0].getBalance() + acc[1].getBalance() + acc[2].getBalance();



        while (bankAppilcation) {
            Scanner in = new Scanner(System.in);
            System.out.println("""
                     Welcome to WhatEver Bank ♔\s
                    Please, input the number equivalenty to the desire option :\s
                    0 - New account\s
                    1 - Withdraw\s
                    2 - Deposit\s
                    3 - Transfer\s
                    4 - Consult balance\s 
                    5 - Consult institutional funds\s
                    6 - Leave 
                    """
            );
            int menu = in.nextInt();



            switch (menu) {
                case 0:
                    newAccount();
                    break;
                case 1:
                    System.out.println("Input the number of the account\n");
                    Account account = acc[in.nextInt()];
                    System.out.println("Please, input the withdraw amount\n");
                    account.setWithDraw(in.nextDouble());
                    System.out.println("The current balance of the account is:\n" + account.getBalance());
                    break;
                case 2:
                    System.out.println("Input the number of the account\n");
                    account = acc[in.nextInt()];
                    System.out.println("Please, input the deposit amount\n");
                    account.setDeposit(in.nextDouble());
                    System.out.println("The current balance of the account is:\n" + account.getBalance());
                    break;
                case 3:
                    System.out.println("Introduza o numero da conta A: ");
                    Account accountA = acc[in.nextInt()];
                    System.out.println("Introduza o numero da conta B: ");
                    Account accountB = acc[in.nextInt()];
                    accountA.getTransfer();
                    accountB.getTransfer();
                    System.out.println(accountB.getBalance() );
                    break;
                case 4:
                    System.out.println("Input the number of the account\n");
                    account = acc[in.nextInt()];
                    System.out.println("The balance of this account is: " + account.getBalance());
                    break;
                case 5:
                    System.out.println("Currently the bank has: " + bankAmount);
                    break;
                case 6:

                    System.out.println("Please press f5 in case of return,Thank you !");
                    bankAppilcation = false;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + menu);


            }
            in.close();
        }

    }
    public static void newAccount () {
        ArrayList<Account> accs = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("""
                    Choose the type of the new Account:\s
                    1 - Checking account\s
                    2 - Salary account \s
                    3 - Saving account 
                    """);
        int register = input.nextInt();
        switch (register) {
            case 1:
                System.out.println("1 - Account number\n");
                int id = input.nextInt();
                System.out.println("2 - Agency number");
                int ag = input.nextInt();
                System.out.println("3 - Initial balance");
                double blnc = input.nextDouble();
                System.out.println("4- There will be an initial deposit ?");
                double initdpst = input.nextDouble();
                System.out.println("5 - Overdraft\n");
                double ovrdft = input.nextDouble();
                accs.add(new CheckingAccount(id, ag, blnc, "WhatEverBank", initdpst, 0, ovrdft));
                System.out.println(accs);
                break;
            case 2:
                System.out.println("1 - Account number\n");
                id = input.nextInt();
                System.out.println("2 - Agency number");
                ag = input.nextInt();
                System.out.println("3 - Initial balance");
                blnc = input.nextDouble();
                System.out.println("4- There will be an initial deposit ?");
                initdpst = input.nextDouble();
                accs.add(new SalaryAccount(id, ag, blnc, "WhatEverBank", initdpst, 0, 5, 0));
                System.out.println(accs);
                break;
            case 3:
                System.out.println("1 - Account number\n");
                id = input.nextInt();
                System.out.println("2 - Agency number");
                ag = input.nextInt();
                System.out.println("3 - Initial balance");
                blnc = input.nextDouble();
                System.out.println("4- There will be an initial deposit ?");
                initdpst = input.nextDouble();
                System.out.println("5- Birthdate ?");
                int birth = input.nextInt();
                System.out.println("6- Fee tax apply ?");
                double txf = input.nextDouble();
                accs.add(new SavingAccounts(id, ag, blnc, "WhatEverBank", initdpst, 0.0, birth, txf));
                System.out.println(accs);


        }
        input.close();

*/
      }
    }
