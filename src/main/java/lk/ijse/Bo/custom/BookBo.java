package lk.ijse.Bo.custom;

import lk.ijse.Bo.SuperBo;
import lk.ijse.dto.BookDto;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public interface BookBo extends SuperBo {
    void saveBook(BookDto bookDto) throws SQLException;

    List<BookDto> getAllBook() throws SQLException;

    BookDto getBook(String text) throws SQLException;

    void deleteBook(int id) throws SQLException;

    void updateBook(BookDto bookDto) throws SQLException;

    List<BookDto> getBookByBranch(String branchName) throws SQLException;

    List<BookDto> getBookByCategory(String category, String branchName) throws SQLException;


    long getBookCount() throws SQLException;
}
