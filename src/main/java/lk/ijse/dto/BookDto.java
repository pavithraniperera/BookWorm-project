package lk.ijse.dto;

public class BookDto {

    private String BookId;
    private String title;
    private String author;
    private String category;
    private  String availability;
    private String branchId;

    public BookDto(String bookId, String title, String author, String category, String availability, String branchId) {
        BookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.availability = availability;
        this.branchId = branchId;
    }

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "BookId='" + BookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", availability='" + availability + '\'' +
                ", branchId='" + branchId + '\'' +
                '}';
    }
}
