import java.util.*;
class BankAccount
{
    String name;
    String userName;
    String ps;
    String accountNo;
    float balance=0f;
    int transactions=0;
    String transactionHistory="";

    public void register()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your name: ");
        this.name=sc.nextLine();
        System.out.println("enter your userName: ");
        this.userName=sc.nextLine();
        System.out.println("enter your ps: ");
        this.ps=sc.nextLine();
        System.out.println("enter your AccountNUmber: ");
        this.accountNo=sc.nextLine();
        System.out.println("\nRegistration Successful.Please Login to your bank account");

    }
    public boolean Login()
    {
       boolean isLogin=false;
       Scanner sc=new Scanner(System.in);
       while(!isLogin)
       {
        System.out.println("\n Enter UserName: ");
        String Username=sc.nextLine();
        if(userName.equals(Username))
        {
           while(!isLogin)
           {
              System.out.println("\nEnter your password: ");
              String passWord=sc.nextLine();
              if(ps.equals(passWord))
              {
                System.out.println("\nLogin Successful ");
                isLogin=true;
              }
              else
              {
                System.out.println("\nIncorrect password");
              }
           }
           
        }
        else
        {
            System.out.println("\nUserName not found ");
        }

       }
       return isLogin;
    }
    public void withDraw()
    {
        System.out.println("\n Enterer Amount to WithDraw: ");
        Scanner sc=new Scanner(System.in);
        float amount=sc.nextFloat();
        try{
            if(balance>=amount)
            {
                transactions++;
                balance=balance-amount;
                System.out.println("withdrawl Successful.");
                String str=amount+" RS WithDrawn";
                transactionHistory=transactionHistory.concat(str);

            }
            else{
                System.out.println("Insufficient Balance");
            }
        }
        catch(Exception e){}
    }
    public void deposit()
    {
        System.out.println("\n Enter Amount to Deposit: ");
        Scanner sc=new Scanner(System.in);
        float amount=sc.nextFloat();
        try{
            if(amount<=10000f)
            {
                transactions++;
                balance=balance+amount;
                System.out.println("Deposit Successful.");
                String str=amount+"RS deposited";
                System.out.println();
                transactionHistory=transactionHistory.concat(str);

            }
            else{
                System.out.println("Sorry.The limit is 10000.");
            }
        }
        catch(Exception e){}
    }
    public void transfer()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("\n Enter Receipents name: ");
        String receipent=sc.nextLine();
         System.out.println("amount to transfer");
        float amount=sc.nextFloat();
        try{
            if(balance>amount)
            {
               if(amount<=5000f)//limit of transfer
               {
                  transactions++;
                  balance=balance-amount;
                  System.out.println("\nSuccessfully transferred to "+receipent);
                  String str=amount+"RS transferredto "+receipent+"\n";
                  System.out.println();
                  transactionHistory=transactionHistory.concat(str);
               }
               else{
                 System.out.println("Sorry.The limit is 5000.");
               }
            }
            else{
                System.out.println("Insufficient Balance.");
            }
        }
        catch(Exception e){}
    }

    public void checkBalance()
    {
        System.out.println(balance+"Rs");
    }
    public void transHistory()
    {
       if(transactions==0)
       {
        System.out.println("NO transactions happend");
       }
       else
       {
        System.out.println("\n"+transactionHistory);
       }
    }
}

public class ATM_pro {
    public static int takenIntegerInput(int limit)
    {
        int input=0;
        boolean flag=false;
        while(!flag)
        {
            try{
                Scanner sc=new Scanner(System.in);
                input=sc.nextInt();
                flag=true;
                if(flag && input>limit || input<1)
                {
                System.out.println("choose the number between 1 to "+limit);
                flag=false;
                }
            }
            catch(Exception e)
            {
                System.out.println("enter only interegr value");
                flag=false;
            }
        }
        return input;
    }
    public static void main(String args[])
    {
        System.out.println("****************WELCOME TO SBI ATM INTERFACE************");
        System.out.println("choose");
        System.out.println(" 1.Register\n 2.exit");
        System.out.println("choose one option");
        int choose=takenIntegerInput(2);
        if(choose==1)
        {
            BankAccount b=new BankAccount();
            b.register();
            while(true)
            {
                System.out.println("choose");
                System.out.println(" 1.Login\n 2.exit");
                System.out.println("Enter Your Choice");
                int ch=takenIntegerInput(2);
                if(ch==1)
                {
                  if(b.Login()){
                    System.out.println("****************WELCOME BACK"+b.name+"************");
                    boolean isFinished=false;
                    while(!isFinished)
                    {
                        System.out.print(" 1.WithDraw \n 2.Deposit \n 3.Transfer \n 4.CheckBalance\n");
                         System.out.println(" 5.Transaction History \n 6.exit");
                        System.out.println("enter your choice");
                        int c=takenIntegerInput(6);
                        switch(c)
                        {
                            case 1:
                               b.withDraw();
                               break;
                            case 2:
                               b.deposit();
                               break;
                            case 3:
                               b.transfer();
                               break;
                            case 4:
                               b.checkBalance();
                               break;
                            case 5:
                               b.transHistory();
                               break;
                            case 6:
                               isFinished=true;
                               break;
                        }
                    }
                }
              }
              else{
                System.exit(0);
              }
            }
        }
        else{
            System.exit(0);
        }

            
    
    }   
    
}
