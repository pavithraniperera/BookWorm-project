package lk.ijse.Bo.custom.Boimpl;

import lk.ijse.Bo.custom.ManageBookBo;
import lk.ijse.Dao.custom.BranchDao;
import lk.ijse.Dao.custom.ManageBookDao;
import lk.ijse.Dao.custom.daoImpl.BranchDaoImpl;
import lk.ijse.Dao.custom.daoImpl.ManageBookDaoImpl;
import lk.ijse.dto.BookDto;
import lk.ijse.entity.Book;
import lk.ijse.entity.Branch;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageBookBoImpl implements ManageBookBo {
    private ManageBookDao manageBookDao = new ManageBookDaoImpl();
    private BranchDao branchDao = new BranchDaoImpl();
    @Override
    public void saveBook(BookDto bookDto) throws SQLException {
        Branch branch = branchDao.getbyId(bookDto.getBranchId());
        manageBookDao.save(new Book(bookDto.getTitle(), bookDto.getAuthor(), bookDto.getCategory(), bookDto.getAvailability(),branch ));

    }

    @Override
    public List<BookDto> getAllBook() throws SQLException {
        List<BookDto> bookDtos = new ArrayList<>();
        List<Book> books = manageBookDao.loadAll();
        for (Book book : books){
            bookDtos.add(new BookDto(book.getBookId(), book.getTitle(), book.getAuthor(), book.getCategory(), book.getAvailability(), book.getBranchId().getBranchId()));
        }
        return bookDtos;
    }

    @Override
    public BookDto getBook(String data) throws SQLException {
        Book book = manageBookDao.get(data);
        return new BookDto(book.getBookId(), book.getTitle(), book.getAuthor(), book.getCategory(), book.getAvailability(), book.getBranchId().getBranchId());
    }

    @Override
    public void deleteBook(int id) throws SQLException {
     manageBookDao.delete(id);
    }

    @Override
    public void updateBook(BookDto bookDto) throws SQLException {
        Branch branch = branchDao.getbyId(bookDto.getBranchId());
        manageBookDao.update(new Book(bookDto.getBookId(), bookDto.getTitle(), bookDto.getAuthor(), bookDto.getCategory(), bookDto.getAvailability(), branch));
    }
}
