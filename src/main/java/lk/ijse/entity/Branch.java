package lk.ijse.entity;

import jakarta.persistence.*;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int branchId;
    @Column(nullable = false)
    private String branchName;
    private String contact;

    private String Address;
    @ManyToOne
    private Admin admin;

    public Branch() {
    }

    public Branch(int branchId, String branchName, String contact, String address, Admin admin) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.contact = contact;
        Address = address;
        this.admin = admin;
    }

    public Branch(String branchName, String contact, String address, Admin admin) {
        this.branchName = branchName;
        this.contact = contact;
        Address = address;
        this.admin = admin;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchId='" + branchId + '\'' +
                ", branchName='" + branchName + '\'' +
                ", contact='" + contact + '\'' +
                ", Address='" + Address + '\'' +
                ", admin=" + admin +
                '}';
    }
}
