package lk.ijse.Dao.custom;

import lk.ijse.Dao.CrudDao;
import lk.ijse.entity.Book;
import lk.ijse.entity.Branch;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public interface BookDao extends CrudDao<Book> {


    List<Book> getBookByBranch(Branch branch) throws SQLException;

    List<Book> getByCategory(String category, Branch branch) throws SQLException;


    long getBookCount() throws SQLException;
}
