package model;

public class Account {
    private int id;
    private String user;
    private String pass;
    private int isSell;
    private int isAdmin;

    private String email;
    private String public_key;
    private  String data;
    private  String signature;

    public Account(int id, String user, String pass, int isSell, int isAdmin,String email,String public_key,String data, String signature) {
        this.id = id;
        this.user =user;
        this.pass = pass;
        this.isSell = isSell;
        this.isAdmin = isAdmin;
        this.email = email;
        this.public_key = public_key;
        this.data = data;
        this.signature = signature;
    }

    public String getEmail() {
        return email;
    }

    public String getPublic_key() {
        return public_key;
    }

    public String getData() {
        return data;
    }

    public String getSignature() {
        return signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIsSell() {
        return isSell;
    }

    public void setIsSell(int isSell) {
        this.isSell = isSell;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", user='" + user + '\'' + ", pass='" + pass + '\'' + ", isSell=" + isSell + ", isAdmin=" + isAdmin + ", signature=" + signature + ", publicKey=" + public_key +", data=" + data +'}';
    }
}


