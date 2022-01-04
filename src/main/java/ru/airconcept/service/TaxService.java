package ru.airconcept.service;

import ru.airconcept.dao.ConnectionFactory;
import ru.airconcept.dao.DaoException;
import ru.airconcept.model.ModelCost;
import ru.airconcept.model.ModelTax;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaxService {

    public static final String SELECT_ALL_TAX = "SELECT * FROM ltax";
    public static final String SELECT_BY_TAX_ID = "SELECT * FROM ltax WHERE taxid = ?";

    public static final String COLUMN_TAX_ID = "taxid";
    public static final String COLUMN_TAX_NDC = "taxndc";
    public static final String COLUMN_TAX_IO = "taxio";
    public static final String COLUMN_TAX_CUT = "coeffcut";
    public static final String COLUMN_TAX_MAT = "coeffmat";

    private ConnectionFactory connectionFactory = null;
    public TaxService(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public List<ModelTax> getAllTax() {
        List<ModelTax> all = new ArrayList<ModelTax> ();
        try (Connection connection = connectionFactory.getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_ALL_TAX);) {
                while (resultSet.next()) {
                    all.add(new ModelTax (resultSet.getInt(COLUMN_TAX_ID),
                            resultSet.getInt (COLUMN_TAX_NDC),
                            resultSet.getInt(COLUMN_TAX_IO),
                            resultSet.getInt(COLUMN_TAX_CUT),
                            resultSet.getInt(COLUMN_TAX_MAT)
                    ));
                }
            }
        } catch (Exception e) {
            throw new DaoException ("Method getAllTax() has thrown an exception.", e);
        }
        return all;
    }

    public ModelTax getByTaxID(int id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_TAX_ID);) {
            statement.setInt (1, id);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    return new ModelTax (resultSet.getInt(COLUMN_TAX_ID),
                            resultSet.getInt(COLUMN_TAX_NDC),
                            resultSet.getInt(COLUMN_TAX_IO),
                            resultSet.getInt(COLUMN_TAX_CUT),
                            resultSet.getInt(COLUMN_TAX_MAT)
                    );
                }
            }
        } catch (Exception e) {
            throw new DaoException (String.format("Method getByTaxID(id: '%d') has thrown an exception.", id), e);
        }
        return null;
    }





}
