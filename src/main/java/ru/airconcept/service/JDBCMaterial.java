package ru.airconcept.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ru.airconcept.dao.DaoException;
import ru.airconcept.dao.ConnectionFactory;
import ru.airconcept.model.ModelMaterials;

public class JDBCMaterial {
    public static final String SELECT_BY_ID_QUERY = "SELECT material_id, name_ru FROM c_materials WHERE material_id = ?";
    public static final String SELECT_ALL_QUERY = "SELECT material_id, name_ru FROM c_materials WHERE is_published = 1";
    public static final String INSERT_AUTHOR_QUERY = "INSERT INTO authors (name, trade_union) VALUES (?, ?)";
    public static final String UPDATE_AUTHOR_QUERY = "UPDATE authors SET name = ?, trade_union = ? WHERE id = ?";
    public static final String DELETE_BY_ID_QUERY = "DELETE FROM authors WHERE id = ?";
    public static final String DELETE_ALL_QUERY = "DELETE FROM authors";
    public static final String COLUMN_ID = "material_id";
    public static final String COLUMN_NAME = "name_ru";
    //public static final String COLUMN_NAME_EN = "name_en";

    private ConnectionFactory connectionFactory = null;

    public JDBCMaterial(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public ModelMaterials getById(int id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY);) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    return new ModelMaterials (resultSet.getInt(COLUMN_ID),
                            resultSet.getString(COLUMN_NAME)
                            //resultSet.getString()
                    );
                }
            }
        } catch (Exception e) {
            throw new DaoException (String.format("Method getById(id: '%d') has thrown an exception.", id), e);
        }
        return null;
    }

    public List<ModelMaterials> getAll() {
        List<ModelMaterials> all = new ArrayList<ModelMaterials> ();
        try (Connection connection = connectionFactory.getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY);) {
                while (resultSet.next()) {
                    all.add(new ModelMaterials (resultSet.getInt(COLUMN_ID),
                            resultSet.getString(COLUMN_NAME)
                            //resultSet.getString()
                    ));
                }
            }
        } catch (Exception e) {
            throw new DaoException ("Method getAll() has thrown an exception.", e);
        }
        return all;
    }
}
