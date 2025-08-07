package Group;

import Controllers.ExpenseController;
import Controllers.GroupController;
import Expense.Expense;
import Split.Split;
import User.User;
import Expense.ExpenseSplitType;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private int groupId;
    private List<User> groupMembers;
    private String groupName;
    private List<Expense> expenseList;

    ExpenseController expenseController;
    GroupController groupController;

    public Group(){
        groupMembers= new ArrayList<>();
        expenseList= new ArrayList<>();
        expenseController = new ExpenseController();
        groupController= new GroupController();
    }

    public void addMember(User user){
        if(!groupMembers.contains(user)){
            groupMembers.add(user);
            System.out.println("User "+user.getUserName()+" added to the group");
        }
        else{
            System.out.println("User "+user.getUserName()+" id already a member of the group");
        }
        groupMembers.add(user);
    }

    public int getGroupId(int groupId) {
        return this.groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public String getGroupName(String groupName) {
        return this.groupName;
    }

    public List<User> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(List<User> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }
    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public void createExpense(int expenseId, String description, double expenseAmount, List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser){
        Expense expense= expenseController.createExpense(expenseId,description,expenseAmount,splitDetails,splitType,paidByUser);
        expenseList.add(expense);
        return;
    }
}
