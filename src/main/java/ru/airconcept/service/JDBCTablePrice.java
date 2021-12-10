package ru.airconcept.service;

import ru.airconcept.dao.DaoException;
import ru.airconcept.dao.ConnectionFactory;
import ru.airconcept.model.*;
import ru.airconcept.service.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JDBCTablePrice {
    //ModelPrice tp;
    public static final String SELECT_ALL_PRICE = "SELECT * FROM calc_tb_price";
    public static final String SELECT_BY_ID_QUERY = "SELECT * FROM calc_tb_price WHERE calc_id = ?";
    public static final String COLUMN_ID = "calc_id";
    public static final String COLUMN_MATERIAL_ID = "material_id";
    public static final String COLUMN_S_5 = "s_5";
    public static final String COLUMN_S_10 = "s_10";
    public static final String COLUMN_S_15 = "s_15";
    public static final String COLUMN_S_20 = "s_20";
    public static final String COLUMN_S_25 = "s_25";
    public static final String COLUMN_S_30 = "s_30";
    public static final String COLUMN_S_35 = "s_35";
    public static final String COLUMN_S_40 = "s_40";
    public static final String COLUMN_S_45 = "s_45";
    public static final String COLUMN_S_50 = "s_50";
    public static final String COLUMN_S_55 = "s_55";
    public static final String COLUMN_S_60 = "s_60";
    public static final String COLUMN_S_65 = "s_65";
    public static final String COLUMN_S_70 = "s_70";
    public static final String COLUMN_S_75 = "s_75";
    public static final String COLUMN_S_80 = "s_80";
    public static final String COLUMN_S_85 = "s_85";
    public static final String COLUMN_S_90 = "s_90";
    public static final String COLUMN_S_95 = "s_95";
    public static final String COLUMN_S_100 = "s_100";

    private ConnectionFactory connectionFactory = null;

    public JDBCTablePrice(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public ModelPrice getById(int id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY);) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    return new ModelPrice (resultSet.getInt(COLUMN_ID),
                            resultSet.getInt(COLUMN_MATERIAL_ID),
                            resultSet.getBigDecimal (COLUMN_S_5),
                            resultSet.getBigDecimal (COLUMN_S_10),
                            resultSet.getBigDecimal (COLUMN_S_15),
                            resultSet.getBigDecimal (COLUMN_S_20),
                            resultSet.getBigDecimal (COLUMN_S_25),
                            resultSet.getBigDecimal (COLUMN_S_30),
                            resultSet.getBigDecimal (COLUMN_S_35),
                            resultSet.getBigDecimal (COLUMN_S_40),
                            resultSet.getBigDecimal (COLUMN_S_45),
                            resultSet.getBigDecimal (COLUMN_S_50),
                            resultSet.getBigDecimal (COLUMN_S_55),
                            resultSet.getBigDecimal (COLUMN_S_60),
                            resultSet.getBigDecimal (COLUMN_S_65),
                            resultSet.getBigDecimal (COLUMN_S_70),
                            resultSet.getBigDecimal (COLUMN_S_75),
                            resultSet.getBigDecimal (COLUMN_S_80),
                            resultSet.getBigDecimal (COLUMN_S_85),
                            resultSet.getBigDecimal (COLUMN_S_90),
                            resultSet.getBigDecimal (COLUMN_S_95),
                            resultSet.getBigDecimal(COLUMN_S_100)
                    );
                }
            }
        } catch (Exception e) {
            throw new DaoException (String.format("Method getById(id: '%d') has thrown an exception.", id), e);
        }
        return null;
    }

}
