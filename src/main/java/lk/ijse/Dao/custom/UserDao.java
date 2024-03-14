package lk.ijse.Dao.custom;

import lk.ijse.Dao.CrudDao;
import lk.ijse.entity.User;

import java.sql.SQLException;

public interface UserDao extends CrudDao<User> {

    long getUserCount() throws SQLException;
}
