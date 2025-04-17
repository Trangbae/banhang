package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBContext {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banhang", "root", "");
        return con;
    }

    public void fetchDataFromDatabase() {
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM `product`";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Process each row of the result set
                    // Example: Retrieve values by column name
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String image = resultSet.getString("image");
                    double price = resultSet.getDouble("price");
                    String title = resultSet.getString("title");
                    String description = resultSet.getString("description");

                    System.out.println("id: " + id);
                    System.out.println("name: " + name);
                    System.out.println("image: " + image);
                    System.out.println("price: " + price);
                    System.out.println("title: " + title);
                    System.out.println("description: " + description);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProduct() {
        // TODO: Implement this method to retrieve a list of products
        return null;
    }

    public static void main(String[] args) {
        DBContext dbContext = new DBContext();
        dbContext.fetchDataFromDatabase();
    }
}
