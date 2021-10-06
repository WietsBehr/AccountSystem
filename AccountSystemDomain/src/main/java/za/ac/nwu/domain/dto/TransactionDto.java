package za.ac.nwu.domain.dto;

import za.ac.nwu.domain.persistence.BalanceTable;
import za.ac.nwu.domain.persistence.Transaction;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class TransactionDto implements Serializable {

    private static final long serialVersionUID = 8785041498325393838L;
    private BalanceTable balanceId;
    private Long valueToAdd;
    private Long valueToSubtract;
    private LocalDate createdDate;

    public TransactionDto(){}

    public TransactionDto(BalanceTable balanceId, Long valueToAdd, Long valueToSubtract, LocalDate createdDate) {
        this.balanceId = balanceId;
        this.valueToAdd = valueToAdd;
        this.valueToSubtract = valueToSubtract;
        this.createdDate = createdDate;
    }

    public TransactionDto(Transaction transaction){
        this.setBalanceId(transaction.getBalanceId());
        this.setValueToAdd(transaction.getValueToAdd());
        this.setValueToSubtract(transaction.getValueToSubtract());
        this.setCreatedDate(transaction.getCreatedDate());
    }

    public BalanceTable getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(BalanceTable balanceId) {
        this.balanceId = balanceId;
    }

    public Long getValueToAdd() {
        return valueToAdd;
    }

    public void setValueToAdd(Long valueToAdd) {
        this.valueToAdd = valueToAdd;
    }

    public Long getValueToSubtract() {
        return valueToSubtract;
    }

    public void setValueToSubtract(Long valueToSubtract) {
        this.valueToSubtract = valueToSubtract;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDto that = (TransactionDto) o;
        return Objects.equals(balanceId, that.balanceId) && Objects.equals(valueToAdd, that.valueToAdd) && Objects.equals(valueToSubtract, that.valueToSubtract) && Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balanceId, valueToAdd, valueToSubtract, createdDate);
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "balanceId=" + balanceId +
                ", valueToAdd=" + valueToAdd +
                ", valueToSubtract=" + valueToSubtract +
                ", createdDate=" + createdDate +
                '}';
    }
}

