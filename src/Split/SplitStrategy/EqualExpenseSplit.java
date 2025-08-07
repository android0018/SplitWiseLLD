package Split.SplitStrategy;

import Split.ExpenseSplitStrategy;
import Split.Split;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplitStrategy {
    @Override
    public void validateSplit(List<Split> splits, double totalAmount){
        int size = splits.size();
        double individualExpense = totalAmount/size;
        for(Split split:splits){
            if(split.getAmountOwe()!=individualExpense) {
                System.out.println("Not properly splited");
                break;
            }
        }
        return;
    }
}
