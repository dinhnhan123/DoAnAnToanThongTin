package model;

public class Customer {
    private int customer_id;
    private String fullname;
    private String email;
    private String address;
    private String num_phone;
    private String note;

    public Customer(int customer_id, String fullname, String email, String address, String num_phone, String note) {
        this.customer_id = customer_id;
        this.fullname = fullname;
        this.email = email;
        this.address = address;
        this.num_phone = num_phone;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", num_phone='" + num_phone + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNum_phone(String num_phone) {
        this.num_phone = num_phone;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getNum_phone() {
        return num_phone;
    }

    public String getNote() {
        return note;
    }
}