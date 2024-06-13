import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
class Account{
    private int AccNum;
    private String name;
    private double balence=0.0;
    private int userPin;
    public Account(String name, int AccNum, int userPin){
        this.name=name;
        this.AccNum=AccNum;
        this.userPin=userPin;   
        this.balence=0.0;
    }
    public String name(){
        return name;
    }
    public int AccNum(){
        return AccNum;
    }
    public double balence(){
        return balence;
    }
    public int userPin(){
        return userPin;
    }
    public void deposit(double amount){
        if(amount>0){
            balence=balence+amount;
            System.out.println("Successfully diposite amount of :"+amount);
        }
        else{
            System.out.println("Amount less than zero...Sorry");
        }
    }
    public void withdraw(double amount){
        if(balence>amount){
            balence=balence-amount;
            System.out.println("Withdraw successfully of amount "+amount);
            System.out.println("Current balence is : "+balence);
        }
        else{
            System.out.println("Please enter valid amount grater than Zero");
        }
    }
    public void changePin(int newPin){
        userPin=newPin;
        System.out.println("Pin changed Successfully...!");
    }
}

public class Bank {
    static Map<Integer,Account> m= new HashMap<>();
    private static void createAccount(Scanner sc){
        System.out.println("Enter the name ");
        String name = sc.next();
        System.out.println("Enter the account number");
        int AccNum = sc.nextInt();
        System.out.println("Enter the pin");
        int userPin = sc.nextInt();
        if(m.containsKey(AccNum)){
            System.out.println("Account already exists");
        }
        else{
            Account acc = new Account(name,AccNum,userPin);
            m.put(AccNum, acc);
            System.out.println("Successfully Created......!");
        }
    }
    private static void deposit(Scanner sc) {
        System.out.print("Enter account number: ");
        int AccNum = sc.nextInt();
        Account acc = m.get(AccNum);
        
        if (acc != null) {
            System.out.print("Enter deposit amount: ");
            double amount = sc.nextDouble();
            acc.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }
    private static void withdraw(Scanner sc){
        System.out.println("Enter the account number");
        int AccNum = sc.nextInt();
        Account acc = m.get(AccNum); 
        if(acc!=null){
            System.out.println("Enter the amount to be withdraw");
            double amount = sc.nextDouble();
            acc.withdraw(amount);
        }
        else{
            System.out.println("Don't have an account");
        }
    }
    private static void changePin(Scanner sc){
        System.out.println("Enter the account number");
        int AccNum = sc.nextInt();
        Account acc = m.get(AccNum);
        if(acc!=null){
            System.out.println("Enter new pin");
            int newPin=sc.nextInt();
            acc.changePin(newPin);
        }
    }
    private static void viweDetails(Scanner sc){
        System.out.println("Enter the account number");
        int AccNum = sc.nextInt();
        Account acc = m.get(AccNum);
        if(acc!=null){
            System.out.println("Account Holder Name : "+acc.name());
            System.out.println("Account Number : "+acc.AccNum());
            System.out.println("Balence of Holder : "+acc.balence());
            System.out.println("Account Holder Pin :"+acc.userPin());
        }
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        while(true){
            
        System.out.println("\n******Welcome To The Bank******");
        System.out.println();
        System.out.println("<--Choose any one option to perform an operation-->\n");
        System.out.println("1:- Create An Account");
        System.out.println("2:- Deposit Amount");
        System.out.println("3:- Withdraw Amount");
        System.out.println("4:- Change Pin");
        System.out.println("5:- Viwe Account details");
        System.out.println("6:- Exit");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                createAccount(sc);
                break;
            case 2:
                deposit(sc);
                break;
            case 3:
                withdraw(sc);
                break;
            case 4:
                changePin(sc);
                break;
            case 5:
                viweDetails(sc);
                break;
            case 6:
                sc.close();
                return;
            default:
                break;
        }
        }

    }
}
