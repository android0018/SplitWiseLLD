package Expense;

import Split.Split;
import User.User;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    private int expenseId;
    private double expenseAmount;
    private String description;
    private User paidByUser;
    private ExpenseSplitType splitType;
    private List<Split> splitDetails =new ArrayList<>();

    public Expense(int expenseId, double expenseAmount, String description, User paidByUser,ExpenseSplitType splitType,List<Split> splitsDetails) {
        this.expenseId = expenseId;
        this.expenseAmount = expenseAmount;
        this.description = description;
        this.paidByUser = paidByUser;
        this.splitType = splitType;
        this.splitDetails=splitDetails;
    }

}
