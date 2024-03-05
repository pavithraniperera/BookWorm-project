package lk.ijse.dto;

public class BranchDto {

    private  String branchId;
    private String branchName;
    private String contact;

    private String Address;

    private String  adminId;

    public BranchDto(String branchId, String branchName, String contact, String address, String adminId) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.contact = contact;
        Address = address;
        this.adminId = adminId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "BranchDto{" +
                "branchId='" + branchId + '\'' +
                ", branchName='" + branchName + '\'' +
                ", contact='" + contact + '\'' +
                ", Address='" + Address + '\'' +
                ", adminId='" + adminId + '\'' +
                '}';
    }
}
