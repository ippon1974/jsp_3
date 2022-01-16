package ru.airconcept.service;

import ru.airconcept.dao.ConnectionFactory;
import ru.airconcept.dao.DaoException;
import ru.airconcept.model.ModelCart;
import ru.airconcept.model.ModelCustomerOrder;
import ru.airconcept.model.ModelGrill;

import javax.swing.plaf.PanelUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerOrderService {
    public static final String SELECT_CUSTOMER_ORDER = "SELECT customers.id,customers.name,customers.phone,customers.email,customers.comment,orders.customerId,orders.nametemplate,orders.namematerial,orders.typematerial,orders.`number`,orders.`size`,orders.width,orders.height,orders.totalNDC,orders.img,orders.createdAt FROM customers JOIN orders ON customers.id=orders.customerId WHERE customers.id = ?;";
    public static final String SELECT_CUSTOMER_ORDER_ALL = "SELECT customers.id,customers.name,customers.phone,customers.email,customers.comment,orders.customerId,orders.nametemplate,orders.namematerial,orders.typematerial, orders.`number`,orders.`size`,orders.width,orders.height,orders.totalNDC,orders.img,orders.createdAt FROM customers JOIN orders ON customers.id=orders.customerId;";
    public static final String COLUMN_CUSTOMER_ID = "customerId";
    public static final String COLUMN_CUSTOMER_NAME = "name";
    public static final String COLUMN_CUSTOMER_PHONE = "phone";
    public static final String COLUMN_CUSTOMER_EMAIL = "email";
    public static final String COLUMN_CUSTOMER_COMMENT = "comment";
    public static final String COLUMN_ORDER_NAMETEMPLATE = "nameTemplate";
    public static final String COLUMN_ORDER_MATERIAL = "nameMaterial";
    public static final String COLUMN_ORDER_TYPE_MATERIAL = "typematerial";
    public static final String COLUMN_ORDER_NUMBER = "number";
    public static final String COLUMN_ORDER_SIZE = "size";
    public static final String COLUMN_ORDER_TEMPLATE_WIDTH = "width";
    public static final String COLUMN_ORDER_TEMPLATE_HEIGHT = "height";
    public static final String COLUMN_ORDER_TOTALNDC = "totalNDC";
    public static final String COLUMN_ORDER_IMG = "img";
    public static final String COLUMN_ORDER_DT = "createdAt";

    private ConnectionFactory connectionFactory = null;
    public CustomerOrderService(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public ModelCustomerOrder getByCustomerOrder(int customerID) {
        List<ModelCustomerOrder> all = new ArrayList<ModelCustomerOrder>();
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_CUSTOMER_ORDER);) {
            statement.setInt(1, customerID);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    return new ModelCustomerOrder (resultSet.getInt(COLUMN_CUSTOMER_ID),
                            resultSet.getString(COLUMN_CUSTOMER_NAME),
                            resultSet.getString(COLUMN_CUSTOMER_PHONE),
                            resultSet.getString(COLUMN_CUSTOMER_EMAIL),
                            resultSet.getString(COLUMN_CUSTOMER_COMMENT),
                            resultSet.getString (COLUMN_ORDER_NAMETEMPLATE),
                            resultSet.getString(COLUMN_ORDER_MATERIAL),
                            resultSet.getInt(COLUMN_ORDER_TYPE_MATERIAL),
                            resultSet.getInt(COLUMN_ORDER_NUMBER),
                            resultSet.getInt(COLUMN_ORDER_SIZE),
                            resultSet.getInt(COLUMN_ORDER_TEMPLATE_WIDTH),
                            resultSet.getInt(COLUMN_ORDER_TEMPLATE_HEIGHT),
                            resultSet.getBigDecimal(COLUMN_ORDER_TOTALNDC),
                            resultSet.getString(COLUMN_ORDER_IMG),
                            resultSet.getDate(COLUMN_ORDER_DT)
                    );
                }
            }
        } catch (Exception e) {
            throw new DaoException (String.format("Method getByCustomerOrder(name: '%s') has thrown an exception.", customerID), e);
        }
        return null;
    }


    public List<ModelCustomerOrder> getAll() {
        List<ModelCustomerOrder> all = new ArrayList<ModelCustomerOrder>();
        try (Connection connection = connectionFactory.getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_CUSTOMER_ORDER_ALL);) {
                while (resultSet.next()) {
                    all.add(new ModelCustomerOrder (resultSet.getInt(COLUMN_CUSTOMER_ID),
                            resultSet.getString(COLUMN_CUSTOMER_NAME),
                            resultSet.getString(COLUMN_CUSTOMER_PHONE),
                            resultSet.getString(COLUMN_CUSTOMER_EMAIL),
                            resultSet.getString(COLUMN_CUSTOMER_COMMENT),
                            resultSet.getString (COLUMN_ORDER_NAMETEMPLATE),
                            resultSet.getString(COLUMN_ORDER_MATERIAL),
                            resultSet.getInt(COLUMN_ORDER_TYPE_MATERIAL),
                            resultSet.getInt(COLUMN_ORDER_NUMBER),
                            resultSet.getInt(COLUMN_ORDER_SIZE),
                            resultSet.getInt(COLUMN_ORDER_TEMPLATE_WIDTH),
                            resultSet.getInt(COLUMN_ORDER_TEMPLATE_HEIGHT),
                            resultSet.getBigDecimal(COLUMN_ORDER_TOTALNDC),
                            resultSet.getString(COLUMN_ORDER_IMG),
                            resultSet.getDate(COLUMN_ORDER_DT)
                    ));
                }
            }
        } catch (Exception e) {
            throw new DaoException("Method getAll() has thrown an exception.", e);
        }
        return all;
    }












}