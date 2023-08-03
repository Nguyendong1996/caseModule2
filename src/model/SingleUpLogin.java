package model;

import java.io.Serializable;

public class SingleUpLogin implements Serializable {
    private static final long serialVersionUID = 123456789L;
    private String account;
    private String passWork;
    private String email;

    public SingleUpLogin(String account, String passWork, String email) {
        this.account = account;
        this.passWork = passWork;
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassWork() {
        return passWork;
    }

    public void setPassWork(String passWork) {
        this.passWork = passWork;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SingleUpLogin{" +
                "account='" + account + '\'' +
                ", passWork='" + passWork + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
