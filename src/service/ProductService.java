package service;

import bean.Product;
import dao.ProductDao;
import dao._FactoryDao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by QuispeRoque on 07/12/16.
 */
public class ProductService implements ProductDao {

    _FactoryDao fabrica = _FactoryDao.getfactoryDao(_FactoryDao.MYSQL);
    ProductDao productDao = fabrica.getProductDao();

    public int store(String varName, String varImage, int varQuantity, float varPrice,String varDescription) {
        int result = 0;
        try {
            result = productDao.store(varName, varImage, varQuantity, varPrice,varDescription);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Product> list() {
        ArrayList<Product> lista = new ArrayList<>();
        try {
            lista = productDao.list();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public int clean() {
        int result = 0;
        try {
            result = productDao.clean();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Product> listProductsName() throws SQLException {
        ArrayList<Product> lista = new ArrayList<>();
        try {
            lista = productDao.listProductsName();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Product show(int id) {
        Product product = new Product();
        try {
            product = productDao.show(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public int update(Product product) {
        int result = 0;
        try {
            result = productDao.update(product);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(int id) {
        int result = 0;
        try {
            result = productDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
