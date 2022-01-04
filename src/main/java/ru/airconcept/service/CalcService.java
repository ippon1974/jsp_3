package ru.airconcept.service;

import ru.airconcept.dao.ConnectionFactory;
import ru.airconcept.dao.DaoException;
import ru.airconcept.model.ModelCalc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CalcService {
    public static final String SELECT_COST_MAT_STORE = "select cmaterial.mname, csize.size, ccost.cost, ccost.costmcut from cmaterial join  csize on cmaterial.mid = csize.mid join ccost on csize.sid = ccost.sid where cmaterial.mid = ? and csize.size = ?";

    public static final String COLUMM_MATERIAL_NAME = "mname";
    public static final String COLUMM_SIZE = "size";
    public static final String COLUMM_COST_STORE = "cost";
    public static final String COLUMM_COST_M_CUT = "costmcut";

    private ConnectionFactory connectionFactory = null;
    public CalcService(ConnectionFactory connectionFactory){this.connectionFactory = connectionFactory; }

    public ModelCalc getCostMatStore(int material, int size) {
        if(material == 0 || size == 0)throw new IllegalArgumentException ( );
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_COST_MAT_STORE);) {
            statement.setInt (1, material);
            statement.setInt (2, size);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    return new ModelCalc (resultSet.getString(COLUMM_MATERIAL_NAME),
                            resultSet.getInt(COLUMM_SIZE),
                            resultSet.getBigDecimal(COLUMM_COST_STORE),
                            resultSet.getBigDecimal(COLUMM_COST_M_CUT)
                    );
                }
            }
        } catch (Exception e) {
            throw new DaoException (String.format("Method getCostMatStore(name: '%d') has thrown an exception.", material), e);
        }
        return null;
    }




}
