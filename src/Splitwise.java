import Controllers.BalanceSheetController;
import Controllers.GroupController;
import Controllers.UserController;
import Expense.ExpenseSplitType;
import Group.Group;
import Split.Split;
import User.User;

import java.util.ArrayList;
import java.util.List;

public class Splitwise {
    private static Splitwise instance;
    private final UserController userController;
    private final GroupController groupController;
    private final BalanceSheetController balanceSheetController;

    private Splitwise() {
        userController = new UserController();
        groupController = new GroupController();
        balanceSheetController = new BalanceSheetController();
    }

    public static Splitwise getInstance() {
        if (instance == null) {
            synchronized (Splitwise.class) {
                if (instance == null) {
                    instance = new Splitwise();
                }
            }
        }
        return instance;
    }

    public void runSplitwiseDemo() {
        setupUsersAndGroups();

        Group group = groupController.getGroup(1);
        group.addMember(userController.getUser(2));
        group.addMember(userController.getUser(3));

        List<Split> splits1 = new ArrayList<>();
        splits1.add(new Split(userController.getUser(1), 300));
        splits1.add(new Split(userController.getUser(2), 300));
        splits1.add(new Split(userController.getUser(3), 300));

        group.createExpense(1, "Breakfast", 900, splits1, ExpenseSplitType.EQUAL, userController.getUser(1));

        List<Split> splits2 = new ArrayList<>();
        splits2.add(new Split(userController.getUser(1), 600));
        splits2.add(new Split(userController.getUser(2), 600));

        group.createExpense(1, "Dinner", 1200, splits2, ExpenseSplitType.EQUAL, userController.getUser(2));

        for(User user: userController.getAllUsers()){
            balanceSheetController.showBalanceSheet(user);
        }
    }

    private void setupUsersAndGroups(){
        registerUsers();
        groupController.createGroup(1,"Road-trip",userController.getUser(1));
    }
    private void registerUsers(){
        userController.addUser(new User(1,"Akshat"));
        userController.addUser(new User(2,"Kritin"));
        userController.addUser(new User(3,"Aryan"));

    }

}
