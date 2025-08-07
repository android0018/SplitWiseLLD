package Controllers;

import Expense.Expense;
import Split.Split;
import Split.SplitStrategy.EqualExpenseSplit;
import User.User;
import Expense.ExpenseSplitType;
import Split.ExpenseSplitStrategy;
import Split.SplitStrategy.PercentageExpenseSplit;
import Split.SplitStrategy.EqualExpenseSplit;
import Split.SplitStrategy.UnequalExpenseSplit;
import java.util.List;

public class ExpenseController {
    BalanceSheetController balanceSheetController = new BalanceSheetController();
    public ExpenseController() {
        balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(int expenseId, String description, double expenseAmount, List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser) {
        ExpenseSplitStrategy expenseSplitStrategy;
        switch(splitType){
            case EQUAL:
                expenseSplitStrategy=new EqualExpenseSplit();
                break;
            case UNEQUAL:
                expenseSplitStrategy=new UnequalExpenseSplit();
                break;
            case PERCENTAGE:
                expenseSplitStrategy=new PercentageExpenseSplit();
                break;
            default:
                throw new IllegalArgumentException("Wrong split type");
        }

        expenseSplitStrategy.validateSplit(splitDetails,expenseAmount);
        Expense expense = new Expense(expenseId,expenseAmount,description,paidByUser,splitType,splitDetails);
        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser,splitDetails,expenseAmount);
        return expense;
    }
}
