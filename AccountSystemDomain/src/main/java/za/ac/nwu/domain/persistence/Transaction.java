package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Table(name = "TRANSACTION")
@Entity
public class Transaction implements Serializable {
    private static final long serialVersionUID = 2956492891373735075L;
    @Id
    @Column(name = "TRANSACTION_ID", nullable = false)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "BALANCE_ID")
    private BalanceTable balanceTable;

    @Column(name = "VALUE_TO_ADD")
    private Long valueToAdd;

    @Column(name = "VALUE_TO_SUBTRACT")
    private Long valueToSubtract;

    @Column(name = "CREATED_DATE")
    private LocalDate createdDate;



    public Transaction(Long transactionId, BalanceTable balanceTable, Long valueToAdd, Long valueToSubtract, LocalDate createdDate) {
        this.transactionId = transactionId;
        this.balanceTable = balanceTable;
        this.valueToAdd = valueToAdd;
        this.valueToSubtract = valueToSubtract;
        this.createdDate = createdDate;
    }

    public Transaction(BalanceTable balanceId, Long valueToAdd, Long valueToSubtract, LocalDate createdDate) {

    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Long getValueToSubtract() {
        return valueToSubtract;
    }

    public void setValueToSubtract(Long valueToSubtract) {
        this.valueToSubtract = valueToSubtract;
    }

    public Long getValueToAdd() {
        return valueToAdd;
    }

    public void setValueToAdd(Long valueToAdd) {
        this.valueToAdd = valueToAdd;
    }

    public BalanceTable getBalanceId() {
        return balanceTable;
    }

    public void setBalanceId(BalanceTable balanceId) {
        this.balanceTable = balanceId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long id) {
        this.transactionId = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return balanceTable.equals(that.balanceTable) && Objects.equals(valueToAdd, that.valueToAdd) && Objects.equals(valueToSubtract, that.valueToSubtract) && Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balanceTable, valueToAdd, valueToSubtract, createdDate);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", balanceTable=" + balanceTable +
                ", valueToAdd=" + valueToAdd +
                ", valueToSubtract=" + valueToSubtract +
                ", createdDate=" + createdDate +
                '}';
    }
}