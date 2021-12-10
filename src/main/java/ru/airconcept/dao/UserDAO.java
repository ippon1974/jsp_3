package ru.airconcept.dao;

import ru.airconcept.model.User;
import java.sql.*;

public class UserDAO {

    public User checkLogin(String email, String password) throws SQLException,
            ClassNotFoundException {
        String jdbcURL = "jdbc:mysql://localhost/test_airconcept?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String dbUser = "airconcept";
        String dbPassword = "k@4b8C321974";

        Class.forName ("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection (jdbcURL, dbUser, dbPassword);
        String sql = "SELECT * FROM users WHERE email = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement (sql);
        statement.setString (1, email);
        statement.setString (2, password);

        ResultSet result = statement.executeQuery( );

        User user = null;

        if (result.next()) {
            user = new User ( );
            user.setFullname (result.getString ("fullname"));
            user.setEmail (email);
        }

        connection.close ( );

        return user;
    }
}
