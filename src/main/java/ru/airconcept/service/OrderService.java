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

//    public static final String SELECT_ALL_COST = "NSERT INTO order(name) VALUES (’osel’)";
    public static final String query = "INSERT INTO order VALUES (?)";
    String sql = "INSERT INTO order(`id`, `name`) VALUES (?,?);";
    public static final String ID = "id";
    public static final String NAME = "name";


    private ConnectionFactory connectionFactory = null;
    public OrderService(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

//    public void saveOrder(String name){
//        try (Connection connection = connectionFactory.getConnection();
//             PreparedStatement statement = connection.prepareStatement(query);) {
//            statement.setString (1, name);
//
//        } catch (Exception e) {
//            throw new DaoException ("Method saveOrder() has thrown an exception.", e);
//        }
//    }

    public void saveOrder(int id, String name){
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString (2, name);
            statement.executeUpdate();
        }catch (Exception e){
            throw new DaoException("ole", e);
        }

//        PreparedStatement ps=connection.prepareStatement("insert into tbl_patient values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    }



}
