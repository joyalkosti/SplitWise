package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Currency;

@Getter
@Setter
@Entity
public class Settlement_Transcation extends Base_Model{
    @ManyToOne
    private User borrower;

    @ManyToOne
    private User lendor;
    private double amount;
    private Currency currency;

    public Settlement_Transcation() {
    }

    public Settlement_Transcation(User borrower, User lendor, double amount) {
        this.borrower = borrower;
        this.lendor = lendor;
        this.amount = amount;
    }
}
