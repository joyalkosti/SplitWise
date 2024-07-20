package Service.Service_Settle_UP_Strategy_;

import DTOs.User_Amount;
import Entity.*;

import java.util.*;

public class Minimum_Transaction_Settlement_Strategy implements Settle_Up_Strategy{
    public List<Settlement_Transcation> getSettlementTransactions(List<Expense> expenses){
        HashMap<User, Double> map=getOutStandingbalances(expenses);
        // Compare for Max Heap
        Comparator<User_Amount> maxHeapCompare=Comparator.comparingDouble(User_Amount::getAmount).reversed();

        // Compare for Min Heap
        Comparator<User_Amount> minHeapCompare=Comparator.comparingDouble(User_Amount::getAmount);

        // Max Heap
        PriorityQueue<User_Amount> maxHeap=new PriorityQueue<>(maxHeapCompare);

        //Min Heap
        PriorityQueue<User_Amount> minHeap=new PriorityQueue<>(minHeapCompare);

        for(Map.Entry<User, Double> entry: map.entrySet()){
            if(entry.getValue()<0){
                minHeap.add(new User_Amount(entry.getKey(), entry.getValue()));
            }
            else if (entry.getValue()>0){
                maxHeap.add(new User_Amount(entry.getKey(), entry.getValue()));
            }
            else {
                System.out.println("chill");
            }
        }

        List<Settlement_Transcation> settlement_transcationList = new ArrayList<>();
        while(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
            User_Amount borrower = minHeap.poll();
            User_Amount lendor = maxHeap.poll();


            if(Math.abs(borrower.getAmount()) > lendor.getAmount()){
                //Lendor = 500, Borrower = -1000 , borrower pays lendor 500
                borrower.setAmount(borrower.getAmount() + lendor.getAmount());
                minHeap.add(borrower);

                Settlement_Transcation settlement_transcation=new Settlement_Transcation(borrower.getUser(), lendor.getUser(), lendor.getAmount());
                settlement_transcationList.add(settlement_transcation);


            } else if(Math.abs(borrower.getAmount()) < lendor.getAmount()){
                //Lendor = 1000, Borrower = -500
                lendor.setAmount(lendor.getAmount() + borrower.getAmount());
                maxHeap.add(lendor);

                Settlement_Transcation settlement_transcation=new Settlement_Transcation(borrower.getUser(), lendor.getUser(), Math.abs(borrower.getAmount()));
                settlement_transcationList.add(settlement_transcation);


            } else { // Math.abs(borrower.getAmount()) == lendor.getAmount()
                //Lendor = 500, Borrower = -500
                //Transaction -> Borrower to Lendor 500, and both are free from settle up
                System.out.println("Do nothing, both are equal");


                Settlement_Transcation settlement_transcation=new Settlement_Transcation(borrower.getUser(), lendor.getUser(), lendor.getAmount());
                settlement_transcationList.add(settlement_transcation);

            }
        }
        return settlement_transcationList;

    }
    private HashMap<User, Double> getOutStandingbalances(List<Expense> expenseList){
        HashMap<User , Double> expenseMap=new HashMap<>();
        for(Expense expense:expenseList){
            for(User_Expense userExpense:expense.getUser_expenseList()){
                User participant=userExpense.getUser();
                double amount= userExpense.getAmount();
                if(expenseMap.containsKey(participant)){
                    if(userExpense.getUserExpenseType().equals(User_Expense_Type.PAID)){
                        expenseMap.put(participant, expenseMap.get(participant)+amount);
                    }
                    else {
                        expenseMap.put(participant, expenseMap.get(participant)-amount);
                    }
                }
                else {
                    if(userExpense.getUserExpenseType().equals(User_Expense_Type.PAID)){
                        expenseMap.put(participant, 0+amount);
                    }
                    else {
                        expenseMap.put(participant, 0-amount);
                    }
                }

            }
        }
        return expenseMap;
    }

}
