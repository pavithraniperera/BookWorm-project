package lk.ijse.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TransactionDto {
  private int userId;
  private String bookname;
  private LocalDateTime borrowed;

  private LocalDate dueDate;
  private LocalDateTime returnedDate;
  private Boolean isReturn;

  public TransactionDto(int userId, String bookId, LocalDateTime borrowed, LocalDate dueDate, LocalDateTime returnedDate, Boolean isReturn) {
    this.userId = userId;
    this.bookname = bookId;
    this.borrowed = borrowed;
    this.dueDate = dueDate;
    this.returnedDate = returnedDate;
    this.isReturn = isReturn;
  }

  public TransactionDto(int userId, String bookname, LocalDate borrowed, String dueDate, boolean isReturn) {
    this.userId = userId;
    this.bookname = bookname;
    this.borrowed = LocalDateTime.of(borrowed, LocalTime.now());
    this.dueDate = LocalDate.parse(dueDate);
    this.isReturn = isReturn;
  }



  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getBookId() {
    return bookname;
  }

  public void setBookId(String bookId) {
    this.bookname = bookId;
  }

  public LocalDateTime getBorrowed() {
    return borrowed;
  }

  public void setBorrowed(LocalDateTime borrowed) {
    this.borrowed = borrowed;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  public LocalDateTime getReturnedDate() {
    return returnedDate;
  }

  public void setReturnedDate(LocalDateTime returnedDate) {
    this.returnedDate = returnedDate;
  }

  public Boolean getReturn() {
    return isReturn;
  }

  public void setReturn(Boolean aReturn) {
    isReturn = aReturn;
  }

  @Override
  public String toString() {
    return "TransactionDto{" +
            "userId='" + userId + '\'' +
            ", bookId='" + bookname + '\'' +
            ", borrowed=" + borrowed +
            ", dueDate=" + dueDate +
            ", returnedDate=" + returnedDate +
            ", isReturn=" + isReturn +
            '}';
  }

}
