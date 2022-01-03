package ru.airconcept.service;


import ru.airconcept.dao.ConnectionFactory;
import ru.airconcept.dao.DaoException;
import ru.airconcept.model.ModelCost;
import ru.airconcept.model.ModelGrill;
import ru.airconcept.model.ModelMaterial;
import ru.airconcept.model.ModelSize;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GrillService {

    public static final String SELECT_BY_ID_QUERY = "SELECT gid, gname FROM cgrill WHERE gid = ?";
    public static final String SELECT_BY_TRANSLITERATIONS_QUERY = "SELECT * FROM cgrill WHERE gtransliterations = ? AND gispubl = '1'";
    public static final String SELECT_ALL_QUERY = "SELECT * FROM cgrill WHERE gispubl = '1' ORDER BY gname";

    public static final String COLUMN_ID = "gid";
    public static final String COLUMN_TYPE = "gtype";
    public static final String COLUMN_NAME = "gname";
    public static final String COLUMN_TRANSLITERATIONS = "gtransliterations";
    public static final String COLUMM_WIDTH = "gw";
    public static final String COLUMM_HEIGHT = "gh";
    public static final String COLUMM_BORDER = "gbord";
    public static final String COLUMM_LEN_INSIDE = "glenin";
    public static final String COLUMM_ALL_METER_POG = "glenall";
    public static final String COLUMM_PATH_TO_IMG = "gpathimg";
    public static final String COLUMM_DESC_TEMPLATE = "gdesc";
    public static final String COLUMM_KEYWORDS_TEMPLATE = "gkeyw";
    public static final String COLUMM_DT = "gdt";
    public static final String COLUMM_PUBLISH= "gispubl";

    public static final String SELECT_ALL_MATERIAL = "SELECT * FROM cmaterial";
    public static final String COLUMN_ID_MATERIAL = "mid";
    public static final String COLUMN_TYPE_MATERIAL = "mtype";
    public static final String COLUMN_NAME_MATERIAL = "mname";

    public static final String SELECT_ALL_SIZE = "SELECT * FROM csize WHERE sid < 6";
    public static final String COLUMN_ID_SIZE = "sid";
    public static final String COLUMN_SIZE = "size";
    public static final String COLUMN_MATERIAL_SIZE_ID = "mid";

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
                            resultSet.getInt(COLUMN_TYPE),
                            resultSet.getString(COLUMN_NAME),
                            resultSet.getString (COLUMN_TRANSLITERATIONS),
                            resultSet.getInt(COLUMM_WIDTH),
                            resultSet.getInt(COLUMM_HEIGHT),
                            resultSet.getInt(COLUMM_BORDER),
                            resultSet.getInt(COLUMM_LEN_INSIDE),
                            resultSet.getInt (COLUMM_ALL_METER_POG),
                            resultSet.getString(COLUMM_PATH_TO_IMG),
                            resultSet.getString (COLUMM_DESC_TEMPLATE),
                            resultSet.getString(COLUMM_KEYWORDS_TEMPLATE),
                            resultSet.getDate(COLUMM_DT),
                            resultSet.getBoolean(COLUMM_PUBLISH)
                    );
                }
            }
        } catch (Exception e) {
            throw new DaoException (String.format("Method getByTransliterations(name: '%s') has thrown an exception.", transliterations), e);
        }
        return null;
    }

//    public ModelGrill getById(int id) {
//        try (Connection connection = connectionFactory.getConnection();
//             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY);) {
//            statement.setLong(1, id);
//            try (ResultSet resultSet = statement.executeQuery();) {
//                while (resultSet.next()) {
//                    return new ModelGrill (resultSet.getInt(COLUMN_ID),
//                            resultSet.getString(COLUMN_NAME),
//                            resultSet.getString(COLUMN_TRANSLITERATIONS)
//                    );
//                }
//            }
//        } catch (Exception e) {
//            throw new DaoException (String.format("Method getById(id: '%d') has thrown an exception.", id), e);
//        }
//        return null;
//    }

    public List<ModelGrill> getAll() {
        List<ModelGrill> all = new ArrayList<ModelGrill>();
        try (Connection connection = connectionFactory.getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY);) {
                while (resultSet.next()) {
                    all.add(new ModelGrill (resultSet.getInt(COLUMN_ID),
                            resultSet.getInt(COLUMN_TYPE),
                            resultSet.getString(COLUMN_NAME),
                            resultSet.getString(COLUMN_TRANSLITERATIONS),
                            resultSet.getInt(COLUMM_WIDTH),
                            resultSet.getInt(COLUMM_HEIGHT),
                            resultSet.getInt(COLUMM_BORDER),
                            resultSet.getInt(COLUMM_LEN_INSIDE),
                            resultSet.getInt (COLUMM_ALL_METER_POG),
                            resultSet.getString(COLUMM_PATH_TO_IMG),
                            resultSet.getString (COLUMM_DESC_TEMPLATE),
                            resultSet.getString(COLUMM_KEYWORDS_TEMPLATE),
                            resultSet.getDate(COLUMM_DT),
                            resultSet.getBoolean(COLUMM_PUBLISH)
                    ));
                }
            }
        } catch (Exception e) {
            throw new DaoException("Method getAll() has thrown an exception.", e);
        }
        return all;
    }

    public List<ModelMaterial> getListMaterial() {
        List<ModelMaterial> all = new ArrayList<ModelMaterial>();
        try (Connection connection = connectionFactory.getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_ALL_MATERIAL);) {
                while (resultSet.next()) {
                    all.add(new ModelMaterial (resultSet.getInt(COLUMN_ID_MATERIAL),
                            resultSet.getInt (COLUMN_TYPE_MATERIAL),
                            resultSet.getString(COLUMN_NAME_MATERIAL)
                    ));
                }
            }
        } catch (Exception e) {
            throw new DaoException("Method getListMaterial() has thrown an exception.", e);
        }
        return all;
    }

    public List<ModelSize> getListSize() {
        List<ModelSize> all = new ArrayList<ModelSize>();
        try (Connection connection = connectionFactory.getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_ALL_SIZE);) {
                while (resultSet.next()) {
                    all.add(new ModelSize (resultSet.getInt(COLUMN_ID_SIZE),
                            resultSet.getInt(COLUMN_SIZE),
                            resultSet.getInt(COLUMN_MATERIAL_SIZE_ID)
                    ));
                }
            }
        } catch (Exception e) {
            throw new DaoException("Method getListSize() has thrown an exception.", e);
        }
        return all;
    }
}
