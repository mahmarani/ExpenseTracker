import java.util.*;
public class Expense {
private int id;
private String category;
private double amount;
private String description;
private Date date;

    public Expense(String category, double amount, String description, Date date) {

        this.category = category;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
