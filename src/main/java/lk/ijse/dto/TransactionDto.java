package lk.ijse.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransactionDto {
  private String userId;
  private String bookId;
  private LocalDateTime borrowed;

  private LocalDate dueDate;
  private LocalDateTime returnedDate;
  private Boolean isReturn;

  public TransactionDto(String userId, String bookId, LocalDateTime borrowed, LocalDate dueDate, LocalDateTime returnedDate, Boolean isReturn) {
    this.userId = userId;
    this.bookId = bookId;
    this.borrowed = borrowed;
    this.dueDate = dueDate;
    this.returnedDate = returnedDate;
    this.isReturn = isReturn;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getBookId() {
    return bookId;
  }

  public void setBookId(String bookId) {
    this.bookId = bookId;
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
            ", bookId='" + bookId + '\'' +
            ", borrowed=" + borrowed +
            ", dueDate=" + dueDate +
            ", returnedDate=" + returnedDate +
            ", isReturn=" + isReturn +
            '}';
  }

}
