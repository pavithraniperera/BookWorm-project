package lk.ijse.Bo.custom.Boimpl;

import lk.ijse.Bo.custom.TransactionBo;
import lk.ijse.Dao.DaoFactory;
import lk.ijse.Dao.custom.BookDao;
import lk.ijse.Dao.custom.TransactionDao;
import lk.ijse.Dao.custom.UserDao;
import lk.ijse.Dao.custom.daoImpl.BookDaoImpl;
import lk.ijse.Dao.custom.daoImpl.TransactionDaoImpl;
import lk.ijse.Dao.custom.daoImpl.UserDaoImpl;
import lk.ijse.dto.TransactionDto;
import lk.ijse.entity.Book;
import lk.ijse.entity.Transaction;
import lk.ijse.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionBoImpl implements TransactionBo {
    private TransactionDao transactionDao = new TransactionDaoImpl();
    private UserDao userDao = (UserDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataType.USER);
    private BookDao bookDao = (BookDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataType.BOOK);

    @Override
    public List<TransactionDto> getUnreturned(int userId) throws SQLException {
        List<TransactionDto> dtos = new ArrayList<>();
        User user = userDao.getbyId(userId);
        List<Transaction> transactions = transactionDao.getByUserId(user);
        for (Transaction transaction : transactions){
            dtos.add(new TransactionDto(transaction.getUser().getUserId(),transaction.getBook().getTitle(),transaction.getBorrowed().toLocalDate(),transaction.getDueDate().toString(),transaction.getReturn()));
        }
        return dtos;

    }

    @Override
    public TransactionDto gettransactionByBookUser(String bookId, int userId) throws SQLException {
        User user = userDao.getbyId(userId);
        Book book = bookDao.get(bookId);
        TransactionDto transactionDto = null;
        List<Transaction> byBookUser = transactionDao.getByBookUser(user, book);
        for (Transaction transaction : byBookUser){
            transactionDto = new TransactionDto(transaction.getId(), transaction.getUser().getUserId(),transaction.getBook().getTitle(),transaction.getBorrowed(),transaction.getDueDate(),transaction.getReturnedDate(),transaction.getReturn());
        }
        return transactionDto;
    }

    @Override
    public void saveTransactiondata(int userId, String bookTitle, TransactionDto dto) throws SQLException{
        User user = userDao.getbyId(userId);
        Book book = bookDao.get(bookTitle);
        if (user!=null && book!=null){
            transactionDao.save(new Transaction(user,book,dto.getBorrowed(),dto.getDueDate(),dto.getReturn()));
        }



    }

    @Override
    public boolean update(TransactionDto transactionDto) throws SQLException {
        User user = userDao.getbyId(transactionDto.getUserId());
        Book book = bookDao.get(transactionDto.getBookId());
        return   transactionDao.update(new Transaction(transactionDto.getId(),user,book,transactionDto.getBorrowed(),transactionDto.getDueDate(),transactionDto.getReturnedDate(),transactionDto.getReturn()));
    }

    @Override
    public List<TransactionDto> getAll() throws SQLException {
        List<TransactionDto> dtoList = new ArrayList<>();
        List<Transaction> transactions = transactionDao.getAll();
        for (Transaction transaction : transactions){
            dtoList.add(new TransactionDto(transaction.getId(), transaction.getUser().getUserId(),transaction.getUser().getName(),transaction.getBook().getBranchId().getBranchName(),transaction.getBook().getBookId(),transaction.getBook().getTitle(),transaction.getBorrowed(),transaction.getDueDate(),transaction.getReturnedDate(),transaction.getReturn()));
        }
        return dtoList;
    }

    @Override
    public List<TransactionDto> getOverDue() throws SQLException {
        List<Transaction> transactionList = transactionDao.getOverDue();
        List<TransactionDto> dtos = new ArrayList<>();
        for (Transaction transaction : transactionList){
            dtos.add(new TransactionDto(transaction.getUser().getName(),transaction.getBook().getTitle(),transaction.getUser().getBranch().getBranchName(),transaction.getDueDate()));

        }

        return dtos;
    }

    @Override
    public List<TransactionDto> getByUser(int userId) throws SQLException {
        List<TransactionDto> dtoList = new ArrayList<>();
        User user = userDao.getbyId(userId);
        List<Transaction> transactions = transactionDao.getAllByUser(user);
        for (Transaction transaction : transactions){
            dtoList.add(new TransactionDto(transaction.getId(), transaction.getUser().getUserId(),transaction.getUser().getName(),transaction.getBook().getBranchId().getBranchName(),transaction.getBook().getBookId(),transaction.getBook().getTitle(),transaction.getBorrowed(),transaction.getDueDate(),transaction.getReturnedDate(),transaction.getReturn()));
        }
        return dtoList;
    }

    @Override
    public List<TransactionDto> getTodayCheckOuts() throws SQLException {
        List<Transaction> list = transactionDao.getTodayCheckOuts();
        List<TransactionDto> dtoList = new ArrayList<>();
        for (Transaction transaction : list){
            dtoList.add(new TransactionDto(transaction.getId(), transaction.getUser().getUserId(),transaction.getUser().getName(),transaction.getBook().getBranchId().getBranchName(),transaction.getBook().getBookId(),transaction.getBook().getTitle(),transaction.getBorrowed(),transaction.getDueDate(),transaction.getReturnedDate(),transaction.getReturn()));
        }
        return dtoList;
    }
}
