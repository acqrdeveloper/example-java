package dao;

import controller._FactoryController;

/**
 * Created by QuispeRoque on 07/12/16.
 */
public abstract class _FactoryDao {

    public static final int MYSQL = 1;

    public _FactoryDao() {
    }

    public static _FactoryDao getfactoryDao(int varCase) {
        switch (varCase) {
            case 1:
                return new _FactoryController();
            default:
                return getfactoryDao(MYSQL);
        }
    }

    public abstract ProductDao getProductDao();

}