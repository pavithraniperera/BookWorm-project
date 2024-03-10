package lk.ijse.dto;

public class UserDto {
    private int userId;


    private String name;
    private String email;
    private String password;
    private String branchName;


    public UserDto(int userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;

    }
    public UserDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

    }

    public UserDto(String name, String email, String password, String branchName) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.branchName = branchName;

    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", branchName='" + branchName + '\'' +
                '}';
    }

}
