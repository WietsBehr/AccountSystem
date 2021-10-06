package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "TRANSACTIONS_INFO", schema = "HR")
public class TransactionsInfo implements Serializable{


    private static final long serialVersionUID = -4751001031163275754L;
    private Long transactionInfoId;
    private Transaction transactionId;
    private BalanceTable balanceId;
    private LocalDate transactionDate;
    private Long transactionValue;

    public TransactionsInfo(){}

    public TransactionsInfo(Long transactionInfoId, Transaction transactionId, BalanceTable balanceId, LocalDate transactionDate, Long transactionValue) {
        this.transactionInfoId = transactionInfoId;
        this.transactionId = transactionId;
        this.balanceId = balanceId;
        this.transactionDate = transactionDate;
        this.transactionValue = transactionValue;
    }

    @Id
    @Column(name = "TRANSACTION_INFO_ID")
    public Long getTransactionInfoId() {
        return transactionInfoId;
    }

    public void setTransactionInfoId(Long transactionInfoId) {
        this.transactionInfoId = transactionInfoId;
    }

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
    public Long getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(Long transactionValue) {
        this.transactionValue = transactionValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionsInfo that = (TransactionsInfo) o;
        return Float.compare(that.transactionValue, transactionValue) == 0 && Objects.equals(transactionInfoId, that.transactionInfoId) && Objects.equals(transactionId, that.transactionId) && Objects.equals(balanceId, that.balanceId) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionInfoId, transactionId, balanceId, transactionDate, transactionValue);
    }

    @Override
    public String toString() {
        return "TransactionsInfo{" +
                "transactionInfoId=" + transactionInfoId +
                ", transactionId=" + transactionId +
                ", balanceId=" + balanceId +
                ", transactionDate=" + transactionDate +
                ", transactionValue=" + transactionValue +
                '}';
    }
}

