package ru.airconcept.service;

import ru.airconcept.dao.ConnectionFactory;
import ru.airconcept.dao.DaoException;
import ru.airconcept.model.ModelCost;
import ru.airconcept.model.ModelOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderService {

    public static final String INSERT_ORDER_ID = "INSERT INTO test_airconcept.order(name) VALUES (?);";

    private ConnectionFactory connectionFactory = null;
    public OrderService(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void saveOrder(String name){
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_ORDER_ID)){
            statement.setString (1, name);
            statement.executeUpdate();
            statement.close();
            connection.close();
        }catch (Exception e){
            throw new DaoException (String.format("Method getByMaterialID(name: '%s') has thrown an exception.", name), e);
        }
    }

}
