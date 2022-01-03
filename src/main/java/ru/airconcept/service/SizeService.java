package ru.airconcept.service;

import ru.airconcept.dao.ConnectionFactory;
import ru.airconcept.dao.DaoException;
import ru.airconcept.model.ModelSize;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SizeService {

    public static final String SELECT_ALL_SIZE = "SELECT * FROM csize WHERE sispubl = '1'";
    public static final String SELECT_BY_SIZE_ID = "SELECT * FROM csize WHERE sid = ?";

    public static final String COLUMN_SIZE_ID = "sid";
    public static final String COLUMN_SIZE = "size";
    public static final String COLUMN_SIZE_MATERIAL_ID = "mid";

    private ConnectionFactory connectionFactory = null;
    public SizeService(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public List<ModelSize> getlistSize() {
        List<ModelSize> all = new ArrayList<ModelSize> ();
        try (Connection connection = connectionFactory.getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_ALL_SIZE);) {
                while (resultSet.next()) {
                    all.add(new ModelSize (resultSet.getInt(COLUMN_SIZE_ID),
                            resultSet.getInt(COLUMN_SIZE),
                            resultSet.getInt(COLUMN_SIZE_MATERIAL_ID)
                    ));
                }
            }
        } catch (Exception e) {
            throw new DaoException ("Method getlistSize() has thrown an exception.", e);
        }
        return all;
    }

    public ModelSize getBySizelID(int id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_SIZE_ID);) {
            statement.setInt (1, id);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    return new ModelSize (resultSet.getInt(COLUMN_SIZE_ID),
                            resultSet.getInt(COLUMN_SIZE),
                            resultSet.getInt (COLUMN_SIZE_MATERIAL_ID)
                    );
                }
            }
        } catch (Exception e) {
            throw new DaoException (String.format("Method getBySizelID(id: '%d') has thrown an exception.", id), e);
        }
        return null;
    }


}
