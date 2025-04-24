import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
           
            while (true) {
                try {
                    System.out.print("Enter your choice (1-7): ");
                    String input = scanner.nextLine();
                    choice = Integer.parseInt(input);
            
                    if (choice < 1 || choice > 7) {
                        System.out.println("Choice must be between 1 and 6.");
                        continue;
                    }
            
                    break; // input valido → esco dal ciclo
            
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid input. Please enter a number from 1 to 7.");
                }
            }
            
            switch (choice) {
                case 1:

                System.out.print("Enter description: ");
                String description = scanner.nextLine();
                double amount = 0;
                while(true){
                    try{
                 System.out.print("Enter amount ($): ");
                amount = scanner.nextDouble();
                 scanner.nextLine();
                 if(amount<=0){
                    System.out.println("The amount must be a positive number.");
                    continue;
                 }
                 break;
                    }catch(NumberFormatException  e){
                        System.out.println("Invalid amount. Please enter a number.");
                    }
                }
               
                System.out.print("Enter Category (e.g. Food, Transportation, Entertainment, Other): ");
                String category = scanner.nextLine();

                LocalDate date = null;
                while(true){
                    try{
                System.out.print("Enter date (dd/MM/yyyy): ");
                String input = scanner.nextLine();
                date = LocalDate.parse(input, formatter);
                break;
                    }catch(Exception ex){
                        System.out.println("Invalid date format. Please use dd/MM/yyyy.");

                    }
                }
                
                Expense expense = new Expense(description, amount, category, date);
                management.addExpense(expense);
                System.out.println("Expense added successfully!");
                System.out.println();

                    break;

                    case 2:
                    System.out.println();
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
                    File file = null;
                    while(true){
                        try{
                    System.out.print("Enter file name:  ");
                    String nameFile = scanner.nextLine();
                    file = new File(nameFile + ".csv");
                    break;
                        }catch(Exception e){
                            System.out.println("Could not create this file");
                        }
                    }
                   
                    management.exportFileExpence(file);
                    System.out.println("Export completed!");
                   
                   

                    break;



                    case 6:

                    File fileUpdate;

                    System.out.print("Enter the file name you want to update: ");
                    String nameFileToUpdate = scanner.nextLine();
                    fileUpdate = new File(nameFileToUpdate + ".csv");
                    if (!fileUpdate.exists()) {
                        System.out.println("File not found. It will be created.");
                        fileUpdate = new File(nameFileToUpdate+ ".csv");
                    }
                
                    management.updateFile(fileUpdate);
                    System.out.println(" File updated successfully!");
                    break;
                    

                    case 7:
                    System.out.println();
                    System.out.println("------------------------------------------------");
                    System.out.println("Thank you for using my personal expense manager! \n Bye!");
                    System.out.println("------------------------------------------------");
                    System.exit(0);

                    break;
                    
            
                default:
            break;
                    
            }












        }while(choice<=7);

        


        


        scanner.close();


    }


    public static void printMenu(){

        System.out.println("1. Add expense");
        System.out.println("2. View all expenses");
        System.out.println("3. Total spent");
        System.out.println("4. Filter by category");
        System.out.println("5. Export expenses to file");
        System.out.println("6. Update file");
        System.out.println("7. Exit");
        System.out.println();
    }
}
