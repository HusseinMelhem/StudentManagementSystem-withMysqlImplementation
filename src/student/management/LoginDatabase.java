package student.management;

import java.sql.*;

public class LoginDatabase {
    private static final String URL = "jdbc:mysql://gamingpc:3306/student_db";
    private static final String USER = "root";
    private static final String PASSWORD = "has1212san";

    // 📌 Validate Login Credentials
    public static boolean validateLogin(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Returns true if user exists
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
