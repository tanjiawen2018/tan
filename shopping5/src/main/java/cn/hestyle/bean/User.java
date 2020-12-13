package cn.hestyle.bean;

public class User {
    private String userName;
    private String password;
    private String gender;
    private String emailAddr;

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(String userName, String password, String gender, String emailAddr) {
        super();
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.emailAddr = emailAddr;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    @Override
    public String toString() {
        return "[userName=" + userName + ", password=" + password + ", gender=" + gender + ", emailAddr="
                + emailAddr + "]";
    }
}

