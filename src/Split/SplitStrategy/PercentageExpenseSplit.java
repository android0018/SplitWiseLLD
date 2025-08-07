package Split.SplitStrategy;

import Split.ExpenseSplitStrategy;
import Split.Split;

import java.util.List;

public class PercentageExpenseSplit implements ExpenseSplitStrategy {
    @Override
    public void validateSplit(List<Split> splits, double totalAmount){
        double splitAmount = 0.0;
        for(Split split:splits){
            splitAmount+=(split.getAmountOwe()*totalAmount/100.0);
        }
        if(splitAmount!=totalAmount){
            System.out.println("Not properly splited");
        }
        return;
    }
}
