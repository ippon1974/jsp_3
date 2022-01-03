package ru.airconcept.service;

import ru.airconcept.dao.ConnectionFactory;
import ru.airconcept.dao.DaoException;
import ru.airconcept.model.ModelCalc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CalcService {
    public static final String SELECT_COST_MAT_STORE_QUERY = "select cmaterial.mname, csize.size, ccost.cost, ccost.costmcut from cmaterial join  csize on cmaterial.mid = csize.mid join  ccost on csize.sid = ccost.sid where cmaterial.mid = ? and csize.size = ?";

    public static final String COLUMM_ID_MATERIAL = "id";
    public static final String COLUMM_ID_SIZE = "size";

    private ConnectionFactory connectionFactory = null;
    public CalcService(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public ModelCalc getCostMatStore(int material, int size) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_COST_MAT_STORE_QUERY);) {
            statement.setInt (1, material);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    return new ModelCalc (resultSet.getInt(COLUMM_ID_MATERIAL),
                            resultSet.getInt(COLUMM_ID_SIZE)
                    );
                }
            }
        } catch (Exception e) {
            throw new DaoException (String.format("Method getCostMatStore(name: '%s') has thrown an exception.", material), e);
        }
        return null;
    }


}
