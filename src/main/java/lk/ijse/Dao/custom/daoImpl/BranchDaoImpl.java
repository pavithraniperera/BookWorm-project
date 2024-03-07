package lk.ijse.Dao.custom.daoImpl;

import lk.ijse.Dao.BaseDao;
import lk.ijse.Dao.custom.BranchDao;
import lk.ijse.entity.Admin;
import lk.ijse.entity.Branch;
import lk.ijse.entity.User;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

import static lk.ijse.Dao.BaseDao.executeTransaction;

public class BranchDaoImpl implements BranchDao {
    @Override
    public void save(Branch entity) throws SQLException {
        BaseDao.executeTransaction(session -> session.save(entity));
    }

    @Override
    public void update(Branch entity) throws SQLException {
        BaseDao.executeTransaction(session -> {
            session.update(entity);
            return null;
        });
    }

    @Override
    public void delete(int id) throws SQLException {
        BaseDao.executeTransaction(session -> {
            Branch entity = null;
            try {
                entity = getbyId(id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            session.delete(entity);
            return null;
        });
    }

    public Branch getbyId(int id) throws SQLException {
        return executeTransaction(session -> session.get(Branch.class,id));
    }

    @Override
    public List<Branch> loadAll() throws SQLException {
        return   BaseDao.executeTransaction(session -> {
            Query query = session.createQuery("FROM Branch ");
            return query.getResultList();

        });
    }

    @Override
    public Branch get(String data) throws SQLException {
        return executeTransaction(session -> {
            Query query = session.createQuery("from Branch where branchName=:branchName");
            query.setParameter("branchName", data);
            List<Branch> branches= query.getResultList();
            for (Branch branch : branches){
                return branch;
            }
            System.out.println("ok");
            return null;
        });
    }
}
