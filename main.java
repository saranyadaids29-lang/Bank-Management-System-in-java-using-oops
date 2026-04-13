import java.util.Scanner;
interface BankServices {
    void showBalance(Customer c);
    void applyLoan(Customer c, double amount);
}
class Customer {
    public int customerId;
    public String customerName;
    public double balance;
    public double loanAmount;

    public Customer(int customerId, String customerName, double balance) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.balance = balance;
        this.loanAmount = 0;
    }
}
class BankServiceImpl implements BankServices {

    public void showBalance(Customer c) {
        System.out.println("Balance: " + c.balance);
        System.out.println("Loan Amount: " + c.loanAmount);
    }

    public void applyLoan(Customer c, double amount) {
        if (amount > 0) {
            c.loanAmount += amount;
            c.balance += amount;
            System.out.println("Loan Approved Successfully");
        } else {
            System.out.println("Invalid Loan Amount");
        }
    }
}
class Bank {
    BankServices bankServices;

    public Bank(BankServices bankServices) {
        this.bankServices = bankServices;
    }

    public void checkDetails(Customer c) {
        bankServices.showBalance(c);
    }

    public void takeLoan(Customer c, double amount) {
        bankServices.applyLoan(c, amount);
    }
}
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Customer c1 = new Customer(201, "Ankit", 8000);
        BankServices service = new BankServiceImpl();
        Bank b1 = new Bank(service);

        int choice;

        do {
            System.out.println("\n--- BANK MANAGEMENT MENU ---");
            System.out.println("1. View Account Details");
            System.out.println("2. Apply for Loan");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            if (choice == 1) {
                b1.checkDetails(c1);

            } else if (choice == 2) {
                System.out.print("Enter loan amount: ");
                double loan = sc.nextDouble();
                b1.takeLoan(c1, loan);

            } else if (choice == 3) {
                System.out.println("Thank you for using Bank Services");

            } else {
                System.out.println("Invalid Choice");
            }

        } while (choice != 3);

        sc.close();
    }
}
