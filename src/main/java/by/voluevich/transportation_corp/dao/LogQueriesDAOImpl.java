package by.voluevich.transportation_corp.dao;

import by.voluevich.transportation_corp.service.log.Query;
import by.voluevich.transportation_corp.service.log.TypeQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LogQueriesDAOImpl implements LogQueriesDAO {
    @Override
    public List<Query> getQueries() {
        List<Query> queryList = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            String query = "SELECT * FROM transportation_corp.getlogqueries";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                queryList.add(new Query(
                        resultSet.getString("date"),
                        resultSet.getString("city_one_name"),
                        resultSet.getString("city_two_name"),
                        resultSet.getString("transport"),
                        resultSet.getInt("num_pass"),
                        resultSet.getInt("cargo_w"),
                        new TypeQuery(
                                resultSet.getInt("type_id"),
                                resultSet.getString("name_type")
                        )
                ));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return queryList;
    }

    @Override
    public List<TypeQuery> getTypeQueries() {
        List<TypeQuery> typeQueries = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            String query = "SELECT * FROM transportation_corp.type_query";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                typeQueries.add(new TypeQuery(
                        resultSet.getInt("type_id"),
                        resultSet.getString("name_type")));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return typeQueries;
    }

    @Override
    public void addQuery(Query query) {
        try (Connection connection = ConnectionManager.getConnection()) {
            String qr = "INSERT INTO queries (date, city_one_name, city_two_name, transport, num_pass," +
                    "cargo_w, type_query_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(qr);
            statement.setString(1, query.getDate());
            statement.setString(2, query.getCityFromWhere());
            statement.setString(3, query.getCityWhereTo());
            statement.setString(4, query.getTransport());
            statement.setInt(5, query.getNumPass());
            statement.setInt(6, query.getCargoW());
            statement.setInt(7, query.getTypeQuery().getId());
            statement.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
