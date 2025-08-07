package User;

import Balance.UserExpenseBalanceSheet;

public class User {
    private int userId;
    private String UserName;
    UserExpenseBalanceSheet userExpenseBalanceSheet;

    public User(int userId, String UserName) {
        this.userId = userId;
        this.UserName = UserName;
        userExpenseBalanceSheet= new UserExpenseBalanceSheet();
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return UserName;
    }
    public void setUserName(String userName) {
        UserName = userName;
    }
    public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return userExpenseBalanceSheet;
    }

}
