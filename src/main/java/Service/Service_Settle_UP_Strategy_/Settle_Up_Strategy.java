package Service.Service_Settle_UP_Strategy_;

import Entity.Expense;
import Entity.Settlement_Transcation;

import java.util.List;

public interface Settle_Up_Strategy {
    List<Settlement_Transcation>  getSettlementTransactions(List<Expense> expenses);
}
