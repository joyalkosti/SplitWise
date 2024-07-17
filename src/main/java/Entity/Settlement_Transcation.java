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
    private User lender;
    private double amount;
    private Currency currency;
}
