package workshopea.webserver.usersManager;

public class User {
    private String userName;
    private String password;
    private boolean isManager;

    public User(String userName, String password, boolean isManager) {
        this.userName = userName;
        this.password = password;
        this.isManager = isManager;
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

    public boolean isManager() {
        return isManager;
    }
}
