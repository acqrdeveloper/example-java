package dao;

import bean.Product;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Created by QuispeRoque on 07/12/16.
 */
public interface ProductDao {

    int store (String varName,String varImage,int varQuantity,float varPrice,String varDescription) throws SQLException;
    ArrayList<Product> list() throws SQLException;
    int clean() throws SQLException;
    ArrayList<Product> listProductsName() throws SQLException;
    Product show(int id) throws SQLException;
    int update(Product product) throws SQLException;
    int delete(int id) throws  SQLException;

}
