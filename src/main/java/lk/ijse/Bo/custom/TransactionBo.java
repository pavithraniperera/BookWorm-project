package lk.ijse.Bo.custom;

import lk.ijse.dto.TransactionDto;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public interface TransactionBo {


    List<TransactionDto> getUnreturned(int userId) throws SQLException;


    TransactionDto gettransactionByBookUser(String bookId, int userId) throws SQLException;

    void saveTransactiondata(int userId, String bookTitle, TransactionDto dto) throws SQLException;

    boolean update(TransactionDto dto) throws SQLException;
}
