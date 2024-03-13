package lk.ijse.Dao.custom;

import lk.ijse.entity.Book;
import lk.ijse.entity.Transaction;
import lk.ijse.entity.User;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public interface TransactionDao  {

    List<Transaction> getByUserId(User user) throws SQLException;

    List<Transaction> getByBookUser(User user, Book book) throws SQLException;

    void save(Transaction transaction) throws SQLException;

    boolean update(Transaction transaction) throws SQLException;
}