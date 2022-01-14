package ru.airconcept.service;

import ru.airconcept.dao.ConnectionFactory;
import ru.airconcept.dao.DaoException;
import ru.airconcept.model.ModelCart;
import ru.airconcept.model.ModelCost;
import ru.airconcept.model.ModelOrder;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderService {


    public static final String INSERT_CUSTOMER_ID = "INSERT INTO test_airconcept.customers(name, phone, email, comment) VALUES (?,?,?,?);";
    public static final String INSERT_ORDER_ID = "INSERT INTO orders (customerId, nametemplate, namematerial, typematerial, number, size, width, height, totalNDC, img, createdAt) VALUES (?,?,?,?,?,?,?,?,?,?, NOW());";
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

    // Сохраняем клиента в базу
    public int saveCustomer(String name, String phone, String email, String comment){
        int lastInsertId = 0;
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
                    lastInsertId = generatedKeys.getInt(1);
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

        }catch (Exception e){
            throw new DaoException (String.format("Method saveCustomer(name: '%s') has thrown an exception.", name), e);
        }
        return lastInsertId;
    }

    // Сохраняем заказ клиента в базу
    public void saveOrder(int customerId, String nametemplate, String namematerial, int typematerial, int number, int size, int width, int height, BigDecimal totalNDC, String img){
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_ORDER_ID)){
            statement.setInt (1, customerId);
            statement.setString (2, nametemplate);
            statement.setString (3, namematerial);
            statement.setInt (4, typematerial);
            statement.setInt (5, number);
            statement.setInt (6, size);
            statement.setInt (7, width);
            statement.setInt (8, height);
            statement.setBigDecimal (9, totalNDC);
            statement.setString (10, img);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            throw new DaoException (String.format("Method saveOrder(id: '%d') has thrown an exception.", customerId), e);
        }
    }



























}
