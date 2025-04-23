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
        for(Expense expence : expenses){
            System.out.println(expence.toString());
        }
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

            for(Expense expence : expenses){
                fileWriter.write(expence.toString());
                fileWriter.write("\n");

            }
            

        }catch(IOException e){
            System.out.println("Could not write this file");
        }
        
    }













}
