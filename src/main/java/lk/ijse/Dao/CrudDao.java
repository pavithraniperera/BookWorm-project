package lk.ijse.Dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao <T>{
  void save(T entity) throws SQLException;
  void update(T entity) throws  SQLException;
  void delete(int id) throws  SQLException;
  List<T> loadAll() throws SQLException;
  T get(String data) throws SQLException;

}
