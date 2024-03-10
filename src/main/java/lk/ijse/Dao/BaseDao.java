package lk.ijse.Dao;

import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class BaseDao<T> {

    //Function<Session, R> action, it means that the action variable is expected to hold a function that takes a Session object as input and produces(return) a result of type R
    public static  <R> R executeTransaction(Function<Session, R> action) throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession(); // Get a Hibernate session
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); // Begin the transaction
            R result = action.apply(session); // Execute the action and capture the result
            transaction.commit(); // Commit the transaction
            return result; // Return the captured result
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rollback if any errors occur
            }
            throw e; // Re-throw the exception
        } finally {
            session.close(); // Close the session regardless of success or failure
        }
    }
}

