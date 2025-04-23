import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("------------------------------------");
        System.err.println("Personal Expences Management");
        System.out.println("------------------------------------");


         Scanner scanner = new Scanner(System.in);
         int choice;
        Management management = new Management();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do{

            printMenu();
           
            System.out.printf("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                System.out.print("Enter description: ");
                String description = scanner.nextLine();
                System.out.print("Enter amount ($): ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Enter Category (Food, Transport, Entertainment): ");
                String category = scanner.nextLine();
                System.out.print("Enter date (dd-MM-yyyy): ");
                String input = scanner.nextLine();
                LocalDate date = LocalDate.parse(input, formatter);
                Expense expense = new Expense(description, amount, category, date);
                management.addExpense(expense);
                System.out.println("Expense added successfully!");
                System.out.println();

                    break;

                    case 2:
                    
                    break;

                    case 3:
                    
                    break;

                    case 4:
                    
                    break;

                    case 5:
                    
                    break;

                    case 6:
                    
                    break;
                    
            
                default:
                    break;
            }












        }while(choice<6);

        


        


        scanner.close();


    }


    public static void printMenu(){

        System.out.println("1. Add expense");
        System.out.println("2. View all expenses");
        System.out.println("3. Total spent");
        System.out.println("4. Filter by category");
        System.out.println("5. Export expenses to file");
        System.out.println("6. Exit");
        System.out.println();
    }
}
