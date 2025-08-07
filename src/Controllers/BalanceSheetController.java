package Controllers;

import Balance.Balance;
import Balance.UserExpenseBalanceSheet;
import Split.Split;
import User.User;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {
    public void updateUserExpenseBalanceSheet(User payer, List<Split> splits, double totalExpense){
        UserExpenseBalanceSheet payerSheet = payer.getUserExpenseBalanceSheet();

        payerSheet.setTotalBalance(payerSheet.getTotalBalance()+totalExpense);

        for (Split split : splits) {
            User personWhoOwes=split.getUser();
            UserExpenseBalanceSheet owesSheet=personWhoOwes.getUserExpenseBalanceSheet();

            double amountToPay=split.getAmountOwe();

            if(payer.getUserId()==personWhoOwes.getUserId()){
                payerSheet.setYourExpense(payerSheet.getYourExpense()+amountToPay);
            }
            else{
                payerSheet.setYouGetBack(payerSheet.getYouGetBack()+amountToPay);
                Balance payerBalance=payerSheet.getUserVsBalance().get(personWhoOwes.getUserId());
                if(payerBalance==null){
                    payerBalance=new Balance();
                    payerSheet.getUserVsBalance().put(personWhoOwes.getUserId(),payerBalance);
                }
                payerBalance.setAmountGetBack(payerBalance.getAmountGetBack()+amountToPay);

                owesSheet.setYouOwe(owesSheet.getYouOwe()+amountToPay);
                owesSheet.setYourExpense(owesSheet.getYourExpense()+amountToPay);

                Balance owesBalance=owesSheet.getUserVsBalance().get(payer.getUserId());
                if(owesBalance==null){
                    owesBalance=new Balance();
                    owesSheet.getUserVsBalance().put(payer.getUserId(), owesBalance);
                }
                owesBalance.setAmountDue(owesBalance.getAmountDue()+amountToPay);
            }

        }
    }

    public void showBalanceSheet(User user){
        System.out.println("---------------------------------------");

        System.out.println("Balance sheet of user : " + user.getUserId());

        UserExpenseBalanceSheet userExpenseBalanceSheet =  user.getUserExpenseBalanceSheet();

        System.out.println("TotalYourExpense: " + userExpenseBalanceSheet.getYourExpense());
        System.out.println("TotalGetBack: " + userExpenseBalanceSheet.getYouGetBack());
        System.out.println("TotalYourOwe: " + userExpenseBalanceSheet.getYouOwe());
        System.out.println("TotalPaymnetMade: " + userExpenseBalanceSheet.getTotalBalance());
        for(Map.Entry<Integer,Balance> entity: userExpenseBalanceSheet.getUserVsBalance().entrySet()){
            Integer userID = entity.getKey();
            Balance balance = entity.getValue();

            System.out.println("userID:" + userID + " YouGetBack:" + balance.getAmountGetBack() + " YouOwe:" + balance.getAmountDue());
        }

        System.out.println("---------------------------------------");
    }
}
