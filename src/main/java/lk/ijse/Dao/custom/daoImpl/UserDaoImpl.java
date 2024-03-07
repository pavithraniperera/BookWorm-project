package lk.ijse.Dao.custom.daoImpl;

import lk.ijse.Dao.BaseDao;
import lk.ijse.Dao.CrudDao;
import lk.ijse.Dao.custom.UserDao;
import lk.ijse.entity.User;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

import static lk.ijse.Dao.BaseDao.executeTransaction;

public class UserDaoImpl implements UserDao  {

    @Override
    public void save(User entity) throws SQLException {
        executeTransaction(session -> session.save(entity));
    }

    @Override
    public void update(User entity) throws SQLException {
         BaseDao.<Void>executeTransaction(session -> {
             session.update(entity);
             return null;
         });

    }

    @Override
    public void delete(int id) throws SQLException {
        User user = getbyId(id);
        BaseDao.<Void>executeTransaction(session ->{
                session.delete(user);
                return null;
        });

    }

    @Override
    public List<User> loadAll() throws SQLException {
        return executeTransaction(session -> {
            Query query = session.createQuery("from User");
            return query.getResultList();
        });

    }

    @Override
    public User get( String data) throws SQLException {

        return executeTransaction(session -> {
           Query query = session.createQuery("from User where email=:email");
            query.setParameter("email", data);
          List<User> users= query.getResultList();
          for (User user : users){
              return user;
          }
            System.out.println("ok");
          return null;
        });
    }


    @Override
    public User getbyId(int id) throws SQLException {
        return executeTransaction(session -> session.get(User.class,id));
    }
}
