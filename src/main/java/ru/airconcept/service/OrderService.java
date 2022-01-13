package ru.airconcept.service;

import ru.airconcept.dao.ConnectionFactory;
import ru.airconcept.dao.DaoException;
import ru.airconcept.model.ModelCart;
import ru.airconcept.model.ModelCost;
import ru.airconcept.model.ModelOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    public static final String INSERT_ORDER_ID = "INSERT INTO test_airconcept.order(name) VALUES (?);";
    public static final String INSERT_CUSTOMER_ID = "INSERT INTO test_airconcept.customers(name, phone, email, comment) VALUES (?,?,?,?);";
    public static final String LAST_ID = "SET @last_id_in_customers = LAST_INSERT_ID();";
    public static final String MAX_ID = "SELECT MAX(id) FROM test_airconcept.customers";

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

    public int saveCustomer(String name, String phone, String email, String comment){
        int lastid = 0;
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_CUSTOMER_ID,Statement.RETURN_GENERATED_KEYS)){
             statement.setString (1, name);
             statement.setString (2, phone);
             statement.setString (3, email);
             statement.setString (4, comment);
             statement.executeUpdate();
//             int affectedRows = statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    lastid = generatedKeys.getInt(1);
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

        }catch (Exception e){
            throw new DaoException (String.format("Method saveCustomer(name: '%s') has thrown an exception.", name), e);
        }
        return lastid;
    }

    public void saveOrder(int id){
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO orders (customerId, createdAt) VALUES (?, NOW());")){
            statement.setInt (1, id);
            statement.executeUpdate();
            statement.close();
            connection.close();
        }catch (Exception e){
            throw new DaoException (String.format("Method saveOrder(id: '%d') has thrown an exception.", id), e);
        }
    }


























}
