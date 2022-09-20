package main2;

public class User {
    private int userid;
    private String account;
    private String passwd;

    public int getUserid() {
        return userid;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", account='" + account + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }

    public User(int userid, String account, String passwd) {
        this.userid = userid;
        this.account = account;
        this.passwd = passwd;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
