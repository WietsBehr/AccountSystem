package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "TRANSACTIONS", schema = "HR")
public class TransactionsInfo implements Serializable{

    private static final long serialVersionUID = -4499175612711763619L;

    private Transaction transactionId;
    private BalanceTable balanceId;
    private LocalDate transactionDate;
    private float transactionValue;

    public TransactionsInfo(Transaction transactionId, BalanceTable balanceId, LocalDate transactionDate, float transactionValue) {
        this.transactionId = transactionId;
        this.balanceId = balanceId;
        this.transactionDate = transactionDate;
        this.transactionValue = transactionValue;
    }

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRANSACTION_ID")
    public Transaction getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Transaction transactionId) {
        this.transactionId = transactionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BALANCE_ID")
    public BalanceTable getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(BalanceTable balanceId) {
        this.balanceId = balanceId;
    }

    @Column(name = "TRANSACTION_DATE")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Column(name = "TRANSACTION_VALUE")
    public float getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(float transactionValue) {
        this.transactionValue = transactionValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionsInfo that = (TransactionsInfo) o;
        return Float.compare(that.transactionValue, transactionValue) == 0 && Objects.equals(transactionId, that.transactionId) && Objects.equals(balanceId, that.balanceId) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, balanceId, transactionDate, transactionValue);
    }

    @Override
    public String toString() {
        return "TransactionsInfo{" +
                "transactionId=" + transactionId +
                ", balanceId=" + balanceId +
                ", transactionDate=" + transactionDate +
                ", transactionValue=" + transactionValue +
                '}';
    }
}

