package controller;

import bean.Product;
import dao.ProductDao;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by QuispeRoque on 07/12/16.
 */
public class ProductController implements ProductDao {

    private Connection cnn;
    private ResultSet rs;
    private Statement st;
    private PreparedStatement ps;
    private String sql;
    private String sqlins;
    private String sqlupd;
    private String sqldel;
    private static final String MYDB = "dblaravel";
    int resultI = 0;
    String resultS = "";

    @Override
    public int store(String varName, String varImage, int varQuantity, float varPrice, String varDescription) throws SQLException {
        cnn = _FactoryController.connect_to(MYDB);
        st = cnn.createStatement();
        sql = "insert into product ("
                + " name,"
                + " image,"
                + " quantity,"
                + " price,"
                + " description )"
                + " values("
                + " '" + varName.trim() + "',"
                + " '" + varImage.trim() + "',"
                + " " + varQuantity + ","
                + " " + varPrice + ","
                + " '" + varDescription.trim() + "'); ";
        System.out.println("sql = " + sql);
        resultI = st.executeUpdate(sql);
        return resultI;
    }

    @Override
    public ArrayList<Product> list() throws SQLException {
        ArrayList<Product> lista = new ArrayList<>();
        cnn = _FactoryController.connect_to(MYDB);
        st = cnn.createStatement();
        sql = "select id,name,image,quantity,price from product";
        System.out.println("sql = " + sql);
        rs = st.executeQuery(sql);
        while (rs.next()) {
            Product product = new Product();
            product.setId(rs.getInt(1));
            product.setName(rs.getString(2));
            product.setImage(rs.getString(3));
            product.setQuantity(rs.getInt(4));
            product.setPrice(rs.getFloat(5));
            lista.add(product);
        }
        return lista;
    }

    @Override
    public int clean() throws SQLException {
        cnn = _FactoryController.connect_to(MYDB);
        st = cnn.createStatement();
        sql = "TRUNCATE product";
        System.out.println("sql = " + sql);
        resultI = st.executeUpdate(sql);
        return resultI;
    }

    @Override
    public ArrayList<Product> listProductsName() throws SQLException {
        ArrayList<Product> lista = new ArrayList<>();
        cnn = _FactoryController.connect_to(MYDB);
        st = cnn.createStatement();
        sql = "select id,name from product";
        System.out.println("sql = " + sql);
        rs = st.executeQuery(sql);
        while (rs.next()) {
            Product product = new Product();
            product.setId(rs.getInt(1));
            product.setName(rs.getString(2));
            lista.add(product);
        }
        return lista;
    }

    @Override
    public Product show(int id) throws SQLException {
        cnn = _FactoryController.connect_to(MYDB);
        st = cnn.createStatement();
        sql = "select id,name,image,quantity,price,description from product where id =" + id + " and  state = 1 ";
        System.out.println("sql = " + sql);
        rs = st.executeQuery(sql);
        Product product = new Product();
        while (rs.next()) {
            product.setId(rs.getInt(1));
            product.setName(rs.getString(2));
            product.setImage(rs.getString(3));
            product.setQuantity(rs.getInt(4));
            product.setPrice(rs.getFloat(5));
            product.setDescription(rs.getString(6));
        }
        return product;
    }

    @Override
    public int update(Product product) throws SQLException {
        cnn = _FactoryController.connect_to(MYDB);
        sql = "update product set name = ?,image=?,quantity=?,price=? where id= ?";
        System.out.println("sql = " + sql);
        ps = cnn.prepareStatement(sql);
        ps.setString(1, product.getName());
        ps.setString(2, product.getImage());
        ps.setInt(3, product.getQuantity());
        ps.setFloat(4, product.getPrice());
        ps.setInt(5, product.getId());
        resultI = ps.executeUpdate();
        return resultI;
    }

    @Override
    public int delete(int id) throws SQLException {
        cnn = _FactoryController.connect_to(MYDB);
        sql = "delete from product where id=? ";
        ps = cnn.prepareStatement(sql);
        ps.setInt(1, id);
        resultI = ps.executeUpdate();
        return resultI;
    }
}

