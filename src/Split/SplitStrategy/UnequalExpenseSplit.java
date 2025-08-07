package Split.SplitStrategy;

import Split.ExpenseSplitStrategy;
import Split.Split;

import java.util.List;

public class UnequalExpenseSplit implements ExpenseSplitStrategy {
    @Override
    public void validateSplit(List<Split> splits, double totalAmount){
        double splitAmount = 0.0;
        for(Split split : splits){
            splitAmount+=split.getAmountOwe();
        }
        if(splitAmount!=totalAmount){
            System.out.println("Not properly splited");
        }
        return;
    }
}
