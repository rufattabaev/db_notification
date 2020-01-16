package repository;

import model.User;

import java.sql.*;

public class UserRepository {
    private String username = "postgres";
    private String password = "postgres";
    private String url = "jdbc:postgresql://localhost:5432/postgres";

    public UserRepository(String username, String password, String url) throws ClassNotFoundException, SQLException {
        this.username = username;
        this.password = password;
        this.url = url;
        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE user_table(id INTEGER PRIMARY KEY, login VARCHAR (50) NOT NULL, password VARCHAR (50) NOT NULL)");
            statement.execute("CREATE TABLE profile_table(id INTEGER PRIMARY KEY, firstname VARCHAR (50) NOT NULL, lastname VARCHAR (50) NOT NULL, status VARCHAR (10) NOT NULL)");
            statement.execute("CREATE OR REPLACE FUNCTION");

        }
    }


    public void doRegistration(User user) {
        try(Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user_table(login, password) VALUES(?,?)")) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
