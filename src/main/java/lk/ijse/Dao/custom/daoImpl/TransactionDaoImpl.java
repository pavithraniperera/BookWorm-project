package lk.ijse.Dao.custom.daoImpl;

import lk.ijse.Dao.custom.TransactionDao;
import lk.ijse.entity.Book;
import lk.ijse.entity.Transaction;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

import static lk.ijse.Dao.BaseDao.executeTransaction;

public class TransactionDaoImpl implements TransactionDao {


    @Override
    public List<Transaction> getByUserId(User user) throws SQLException {
        System.out.println("ok");
        return executeTransaction(session -> {
            Query query = session.createQuery("from Transaction where user =:user and isReturn=:return");
            query.setParameter("user", user);
            query.setParameter("return", false);
            List<Transaction> transactions = query.getResultList();
            return transactions;

        });
    }



    @Override
    public List<Transaction> getByBookUser(User user, Book book) throws SQLException {

        System.out.println("ok");
        return executeTransaction(session -> {
            Query query = session.createQuery("from Transaction where user =:user and book=:book");
            query.setParameter("user", user);
            query.setParameter("book", book);
            List<Transaction> transactions = query.getResultList();
            return transactions;

        });
    }

    @Override
    public void save(Transaction transaction) throws SQLException {
        executeTransaction(session -> session.save(transaction));
    }

    @Override
    public boolean update(Transaction transaction) throws SQLException {
        return executeTransaction(session -> {
            Query query = session.createQuery("update Transaction set isReturn=:return,returnedDate=:date where id=:id");
            query.setParameter("return", transaction.getReturn());
            query.setParameter("date", transaction.getReturnedDate());
            query.setParameter("id", transaction.getId());
            int i = query.executeUpdate();
            System.out.println(i);
            if (i > 0) {
                return true;
            }

            return false;
        });

    }
}
