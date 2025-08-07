package Balance;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
    private Map<Integer,Balance> userVsBalance;
    private double totalBalance;
    private double yourExpense;
    private double youGetBack;
    private double youOwe;

    public UserExpenseBalanceSheet(){
        userVsBalance = new HashMap<>();
        totalBalance = 0;
        yourExpense = 0;
        youGetBack = 0;
        youOwe = 0;
    }

    public Map<Integer, Balance> getUserVsBalance() {
        return userVsBalance;
    }

    public void setUserVsBalance(Map<Integer, Balance> userVsBalance) {
        this.userVsBalance = userVsBalance;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public double getYourExpense() {
        return yourExpense;
    }

    public void setYourExpense(double yourExpense) {
        this.yourExpense = yourExpense;
    }

    public double getYouGetBack() {
        return youGetBack;
    }

    public void setYouGetBack(double youGetBack) {
        this.youGetBack = youGetBack;
    }

    public double getYouOwe() {
        return youOwe;
    }

    public void setYouOwe(double youOwe) {
        this.youOwe = youOwe;
    }
}
