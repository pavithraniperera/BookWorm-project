package lk.ijse.Bo.custom;

import lk.ijse.dto.TransactionDto;

import java.sql.SQLException;
import java.util.List;

public interface TransactionBo {
    boolean saveTransactiondata(int userId, String text, TransactionDto dto) throws SQLException;

    List<TransactionDto> getUnreturned(int userId) throws SQLException;
}
