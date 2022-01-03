package ru.airconcept.service;

import ru.airconcept.dao.ConnectionFactory;
import ru.airconcept.dao.DaoException;
import ru.airconcept.model.ModelMaterial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MaterialService {

    public static final String SELECT_ALL_MATERIAL = "SELECT * FROM cmaterial WHERE mispubl = '1'";
    public static final String SELECT_BY_MATERIAL_ID = "SELECT * FROM cmaterial WHERE mid = ?";

    public static final String COLUMN_MATERIAL_ID = "mid";
    public static final String COLUMN_TYPE_MATERIAL = "mtype";
    public static final String COLUMN_NAME_MATERIAL = "mname";

    private ConnectionFactory connectionFactory = null;
    public MaterialService(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public List<ModelMaterial> getlistMaterial() {
        List<ModelMaterial> all = new ArrayList<ModelMaterial> ();
        try (Connection connection = connectionFactory.getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_ALL_MATERIAL);) {
                while (resultSet.next()) {
                    all.add(new ModelMaterial (resultSet.getInt(COLUMN_MATERIAL_ID),
                            resultSet.getInt(COLUMN_TYPE_MATERIAL),
                            resultSet.getString(COLUMN_NAME_MATERIAL)
                    ));
                }
            }
        } catch (Exception e) {
            throw new DaoException("Method getlistMaterial() has thrown an exception.", e);
        }
        return all;
    }

    public ModelMaterial getByMaterialID(int id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_MATERIAL_ID);) {
            statement.setInt (1, id);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    return new ModelMaterial (resultSet.getInt(COLUMN_MATERIAL_ID),
                            resultSet.getInt(COLUMN_TYPE_MATERIAL),
                            resultSet.getNString (COLUMN_NAME_MATERIAL)
                    );
                }
            }
        } catch (Exception e) {
            throw new DaoException (String.format("Method getByMaterialID(id: '%d') has thrown an exception.", id), e);
        }
        return null;
    }


}
