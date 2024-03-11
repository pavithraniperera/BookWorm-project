package lk.ijse.Bo.custom;

import lk.ijse.dto.BookDto;

import java.sql.SQLException;
import java.util.List;

public interface BookBo {
    void saveBook(BookDto bookDto) throws SQLException;

    List<BookDto> getAllBook() throws SQLException;

    BookDto getBook(String text) throws SQLException;

    void deleteBook(int id) throws SQLException;

    void updateBook(BookDto bookDto) throws SQLException;

    List<BookDto> getBookByBranch(String branchName) throws SQLException;

    List<BookDto> getBookByCategory(String category, String branchName) throws SQLException;
}
