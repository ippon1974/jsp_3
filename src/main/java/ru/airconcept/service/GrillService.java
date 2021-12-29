package ru.airconcept.service;

import ru.airconcept.dao.ConnectionFactory;
import ru.airconcept.dao.DaoException;
import ru.airconcept.model.ModelGrill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GrillService {
    public static final String SELECT_BY_ID_QUERY = "SELECT gid, gname FROM cgrill WHERE gid = ?";
    public static final String SELECT_BY_TRANSLITERATIONS_QUERY = "SELECT * FROM cgrill WHERE gtransliterations = ? AND gispubl = '1'";
    public static final String SELECT_ALL_QUERY = "SELECT gid, gname, gtransliterations FROM cgrill WHERE gispubl = '1' AND gispubl = '1'";
    public static final String COLUMN_ID = "gid";
    public static final String COLUMN_NAME = "gname";
    public static final String COLUMN_TRANSLITERATIONS = "gtransliterations";

    private ConnectionFactory connectionFactory = null;

    public GrillService(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public ModelGrill getByTransliterations(String transliterations) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_TRANSLITERATIONS_QUERY);) {
            statement.setString(1, transliterations);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    return new ModelGrill (resultSet.getInt(COLUMN_ID),
                            resultSet.getString(COLUMN_NAME),
                            resultSet.getString (COLUMN_TRANSLITERATIONS)
                    );
                }
            }
        } catch (Exception e) {
            throw new DaoException (String.format("Method getByTransliterations(name: '%s') has thrown an exception.", transliterations), e);
        }
        return null;
    }

    public ModelGrill getById(int id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY);) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    return new ModelGrill (resultSet.getInt(COLUMN_ID),
                            resultSet.getString(COLUMN_NAME),
                            resultSet.getString(COLUMN_TRANSLITERATIONS)
                    );
                }
            }
        } catch (Exception e) {
            throw new DaoException (String.format("Method getById(id: '%d') has thrown an exception.", id), e);
        }
        return null;
    }

    public List<ModelGrill> getAll() {
        List<ModelGrill> all = new ArrayList<ModelGrill>();
        try (Connection connection = connectionFactory.getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY);) {
                while (resultSet.next()) {
                    all.add(new ModelGrill (resultSet.getInt(COLUMN_ID),
                            resultSet.getString(COLUMN_NAME),
                            resultSet.getString(COLUMN_TRANSLITERATIONS)
                    ));
                }
            }
        } catch (Exception e) {
            throw new DaoException("Method getAll() has thrown an exception.", e);
        }
        return all;
    }
}
