import java.util.Scanner;

public class ATMinterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Simulated user data (for demonstration purposes)
        String userId = "12345";
        String userPin = "1234";
        double accountBalance = 1000.0;
        
        boolean isAuthenticated = false;
        
        System.out.println("Welcome to the ATM System");
        
        // Authenticate the user
        System.out.print("Enter User ID: ");
        String inputUserId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String inputPin = scanner.nextLine();
        
        if (inputUserId.equals(userId) && inputPin.equals(userPin)) {
            isAuthenticated = true;
        } else {
            System.out.println("Authentication failed. Exiting...");
            scanner.close();
            return;
        }
        
        System.out.println("Authentication successful. Welcome!");
        
        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. View Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    viewTransactionsHistory();
                    break;
                case 2:
                    accountBalance = withdraw(accountBalance);
                    break;
                case 3:
                    accountBalance = deposit(accountBalance);
                    break;
                case 4:
                    accountBalance = transfer(accountBalance);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void viewTransactionsHistory() {
        // Implement transactions history functionality here
        System.out.println("Transaction history not implemented yet.");
    }
    
    private static double withdraw(double balance) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
        
        return balance;
    }
    
    private static double deposit(double balance) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Current balance: " + balance);
        } else {
            System.out.println("Invalid amount.");
        }
        
        return balance;
    }
    
    private static double transfer(double balance) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();
        
        if (amount > 0 && amount <= balance) {
            System.out.print("Enter the recipient's account number: ");
            String recipientAccount = scanner.next();
            // Implement transfer logic here (e.g., updating recipient's balance)
            System.out.println("Transfer successful. Current balance: " + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
        
        return balance;
    }
}
