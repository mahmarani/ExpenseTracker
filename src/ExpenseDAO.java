import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ExpenseDAO {
    //Add new expense
    public boolean addExpense(Expense e) {
        String sql = "Insert into  expenses (category, amount, description, date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getCategory());
            stmt.setDouble(2, e.getAmount());
            stmt.setString(3, e.getDescription());
            stmt.setDate(4, new Date(e.getDate().getTime()));

            int rows = stmt.executeUpdate();
            return (rows > 0);
        } catch (SQLException s) {
            s.printStackTrace();
            return false;
        }
    }


    //Fetching

    public List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        String sql = "select * from expenses";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Expense exp = new Expense(
                        rs.getString("category"),
                rs.getDouble("amount"),
                rs.getString("description"),
                rs.getDate("date") );
                expenses.add(exp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;


    }

    //Calculating the total

    public double getTotalSpent(){
        String sql = "Select SUM(amount) from expenses";
        double total = 0.0;

        try(Connection conn = DBConnection.getConnection();
        Statement stmt= conn.createStatement();
        ResultSet rs= stmt.executeQuery(sql)){

            if(rs.next()){
                total = rs.getDouble(1);
            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return total;
    }
    public List<Expense> getExpensesByCategory(String category) {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses WHERE category = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, category);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Expense exp = new Expense(
                        rs.getString("category"),
                        rs.getDouble("amount"),
                        rs.getString("description"),
                        rs.getDate("date")
                );
                expenses.add(exp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return expenses;
    }

}