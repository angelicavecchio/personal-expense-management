import java.time.LocalDate;

public class Expense {

    String description;
    double amount;
    String category;
    LocalDate date;


    public Expense(String description, double amount, String category, LocalDate date){
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }


    public String getDescription(){
        return this.description;
    }

    public double getAmount(){
        return this.amount;
    }
    public String getCategory(){
        return this.category;
    }
    public LocalDate getDate(){
        return this.date;
    }


    public String toString(){
        return "Date: "+ this.getDate() + " "+ "Description "+ this.getDescription()+ " "+ "Category: "+ this.getCategory()+ " "+ "Amount: " + this.getAmount()+ "$";
    }



}
