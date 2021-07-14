package by.voluevich.transportation_corp.dao;

import by.voluevich.transportation_corp.entity.User;
import by.voluevich.transportation_corp.entity.types.TypeUser;
import by.voluevich.transportation_corp.service.exception.LogInException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private List<User> getUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            String query = "SELECT users.name_user, users.password, users.type_id, type_users.name " +
                    "FROM transportation_corp.users LEFT JOIN type_users ON type_users.type_user_id = users.type_id";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                userList.add(new User(
                        resultSet.getString("name_user"),
                        resultSet.getString("password"),
                        new TypeUser(
                                resultSet.getInt("type_id"),
                                resultSet.getString("name"))));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return userList;
    }

    @Override
    public void getRegistration(User user) {
        List<User> userList = getUsers();
        if (userList.contains(user)) {
            System.out.println("Invalid registration! User  - " + user.getName() + " is already registered");
        } else {
            try (Connection connection = ConnectionManager.getConnection()) {
                String query = "INSERT INTO users (name_user, password, type_id) VALUES (?,?,?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, user.getName());
                statement.setString(2, user.getPassword());
                statement.setInt(3, user.getTypeUser().getId());
                statement.execute();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            System.out.println("Successful registration!\n");
        }
    }

    @Override
    public User logIn(User user) throws LogInException {
        List<User> userList = getUsers();
        for (User us : userList) {
            if (us.equals(user)) {
                System.out.println("Successful entry!\n");
                return us;
            }
        }
        throw new LogInException();
    }
}
