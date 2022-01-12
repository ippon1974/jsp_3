package ru.airconcept.service;

import ru.airconcept.dao.ConnectionFactory;
import ru.airconcept.dao.DaoException;
import ru.airconcept.model.ModelCart;
import ru.airconcept.model.ModelCost;
import ru.airconcept.model.ModelOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    public static final String INSERT_ORDER_ID = "INSERT INTO test_airconcept.order(name) VALUES (?);";

    private ConnectionFactory connectionFactory = null;
    public OrderService(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    // Список для хранения OrderItem
    private List<ModelOrder> list = new ArrayList<ModelOrder>();

    public List<ModelOrder> list() {
        return list;
    }

    public void add(ModelOrder modelOrder) {
        this.list.add(modelOrder);
    }

    public void saveOrderUser(){}

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
