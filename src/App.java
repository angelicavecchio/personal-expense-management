import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("------------------------------------");
        System.err.println("Personal Expences Management");
        System.out.println("------------------------------------");


         Scanner scanner = new Scanner(System.in);
         int choice = 0;
        Management management = new Management();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do{

            printMenu();
           
            try{
            System.out.printf("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            }catch(InputMismatchException ex){
                System.out.println("Enter a valid input");
            }

            switch (choice) {
                case 1:

                System.out.print("Enter description: ");
                String description = scanner.nextLine();
                System.out.print("Enter amount ($): ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Enter Category (e.g. Food, Transportation, Entertainment, Other): ");
                String category = scanner.nextLine();
                System.out.print("Enter date (dd/MM/yyyy): ");
                String input = scanner.nextLine();
                LocalDate date = LocalDate.parse(input, formatter);
                Expense expense = new Expense(description, amount, category, date);
                management.addExpense(expense);
                System.out.println("Expense added successfully!");
                System.out.println();

                    break;

                    case 2:
                    System.out.println("----- EXPENSE REGISTER -----");
                    management.printExpences();
                    
                    break;

                    case 3:
                    System.out.println();
                    System.out.printf("Total spent so far: %.2f$\n",management.totalAmount());
                    System.out.println();
                    break;

                    case 4:
                    System.out.println();
                    System.out.print("Enter the category to filter: ");
                    String filterCategory = scanner.nextLine();
                    System.out.printf("\n----- EXPENSES: %s -----\n",filterCategory);
                    management.filterByCategory(filterCategory);
                    

                    break;

                    case 5:
                    System.out.print("Enter file name:  ");
                    String nameFile = scanner.nextLine();
                    File file = new File(nameFile + ".txt");
                    management.exportFileExpence(file);
                    System.out.println("Export completed!");
                   
                   

                    break;

                    case 6:
                    System.out.println();
                    System.out.println("------------------------------------------------");
                    System.out.println("Thank you for using my personal expense manager! \n Bye!");
                    System.out.println("------------------------------------------------");
                    System.exit(0);

                    break;
                    
            
                default:
                System.out.println("Cannot choose this number");
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
