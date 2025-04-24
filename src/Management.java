import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Management {


    ArrayList<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense expense){
        expenses.add(expense);
    }

    public void printExpences(){
        int i = 0;
        if(expenses.isEmpty()){
            System.out.println("There are no expences yet!");
        }
        for(Expense expence : expenses){ 
            System.out.print((i+1) + "." + " ");
            System.out.print(expence.toString());
            System.out.println();
            i++;
           
        }
        System.out.println("------------------------");
        System.out.printf("Total expenses: %d", i);
        System.out.println();
        System.out.println();
    }


    public double totalAmount(){
        double total = 0;
        for(Expense expence : expenses){
            total = total + expence.getAmount();
        }

        return total;
    }


   
    public void exportFileExpence(File file){

        try(FileWriter fileWriter = new FileWriter(file,true)){
            fileWriter.write("Date  Category - Description : Amount\n");
            for (Expense expense : expenses) {
                fileWriter.write(String.format("[%s] %s - %s : %.2f$\n",
                    expense.getDate(),
                    expense.getCategory(),
                    expense.getDescription(),
                    expense.getAmount()));
            }
            

        }catch(IOException e){
            System.out.println("Could not write this file");
        }



        
    }


    public void updateFile(File file){
        try(FileWriter fileWriter = new FileWriter(file,true)){
            for (Expense expense : expenses) {
                fileWriter.write(String.format("[%s] %s - %s : %.2f$\n",
                    expense.getDate(),
                    expense.getCategory(),
                    expense.getDescription(),
                    expense.getAmount()));
            }
            

        }catch(IOException e){
            System.out.println("Could not update this file");
        }



    }



    public void filterByCategory(String category){
        double total = 0;
        for(Expense expence : expenses){
            if(expence.getCategory().equals(category)){
                System.out.println(expence.toString());
                total = total + expence.getAmount();
            }



        }
        System.out.println("------------------------");
        System.out.printf("Total in %s category: %.2f$\n\n", category, total);

        

    }













}
