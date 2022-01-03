package ru.airconcept.service;

import ru.airconcept.dao.ConnectionFactory;
import ru.airconcept.dao.DaoException;
import ru.airconcept.model.ModelCost;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CostService {

    public static final String SELECT_ALL_COST = "SELECT * FROM ccost WHERE cispubl = '1'";
    public static final String SELECT_BY_COST_ID = "SELECT * FROM ccost WHERE cid = ?";

    public static final String COLUMN_COST_ID = "cid";
    public static final String COLUMN_COST = "cost";
    public static final String COLUMN_COST_CUT = "costmcut";


    private ConnectionFactory connectionFactory = null;
    public CostService(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public List<ModelCost> getlistCost() {
        List<ModelCost> all = new ArrayList<ModelCost> ();
        try (Connection connection = connectionFactory.getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_ALL_COST);) {
                while (resultSet.next()) {
                    all.add(new ModelCost (resultSet.getInt(COLUMN_COST_ID),
                            resultSet.getBigDecimal (COLUMN_COST),
                            resultSet.getBigDecimal(COLUMN_COST_CUT)
                    ));
                }
            }
        } catch (Exception e) {
            throw new DaoException ("Method getlistCost() has thrown an exception.", e);
        }
        return all;
    }

        public ModelCost getByCostID(int id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_COST_ID);) {
            statement.setInt (1, id);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    return new ModelCost (resultSet.getInt(COLUMN_COST_ID),
                            resultSet.getBigDecimal(COLUMN_COST),
                            resultSet.getBigDecimal(COLUMN_COST_CUT)
                    );
                }
            }
        } catch (Exception e) {
            throw new DaoException (String.format("Method getByCostID(id: '%d') has thrown an exception.", id), e);
        }
        return null;
    }
}
