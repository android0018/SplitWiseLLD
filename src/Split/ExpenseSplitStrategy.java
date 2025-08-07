package Split;

import Expense.Expense;

import java.util.List;

public interface ExpenseSplitStrategy {
    public void validateSplit(List<Split> splits, double totalAmount);
}
