package controller;

import dao.ProductDao;
import dao._FactoryDao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by QuispeRoque on 07/12/16.
 */
public class _FactoryController extends _FactoryDao {

    private static final String DB = "dblaravel";
    private static final String URLDB = "jdbc:mysql://127.0.0.1:3308/" + DB;
    private static final String USR = "root";
    private static final String PWD = "";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    static {
        try {
            Class.forName(DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Debug >> Class.forName(DRIVER) :" + e.getMessage());
        }
    }

    public static Connection connect_to(String varDB) throws SQLException {
        Connection connection = null;
        if (varDB == null ? DB == null : varDB.equals(DB)) {
            try {
                connection = DriverManager.getConnection(URLDB, USR, PWD);
                System.out.println("Console : Conectado Correctamente");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Debug >> Connection connection :" + e.getMessage());
            }
        }
        return connection;
    }

    @Override
    public ProductDao getProductDao() {
        return new ProductController();
    }
}