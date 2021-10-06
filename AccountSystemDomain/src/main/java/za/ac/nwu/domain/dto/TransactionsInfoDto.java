package za.ac.nwu.domain.dto;

import za.ac.nwu.domain.persistence.BalanceTable;
import za.ac.nwu.domain.persistence.Transaction;
import za.ac.nwu.domain.persistence.TransactionsInfo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class TransactionsInfoDto implements Serializable {

    private static final long serialVersionUID = -9211955514926827806L;
    private Transaction transactionId;
    private BalanceTable balanceId;
    private LocalDate transactionDate;
    private Long transactionValue;

    public TransactionsInfoDto(){}

    public TransactionsInfoDto(Transaction transactionId, BalanceTable balanceId, LocalDate transactionDate, Long transactionValue) {
        this.transactionId = transactionId;
        this.balanceId = balanceId;
        this.transactionDate = transactionDate;
        this.transactionValue = transactionValue;
    }

    public TransactionsInfoDto(TransactionsInfo transactionsInfo){
        this.setTransactionId(transactionsInfo.getTransactionId());
        this.setBalanceId(transactionsInfo.getBalanceId());
        this.setTransactionDate(transactionsInfo.getTransactionDate());
        this.setTransactionValue(transactionsInfo.getTransactionValue());

    }

    public Transaction getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Transaction transactionId) {
        this.transactionId = transactionId;
    }

    public BalanceTable getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(BalanceTable balanceId) {
        this.balanceId = balanceId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

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
        TransactionsInfoDto that = (TransactionsInfoDto) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(balanceId, that.balanceId) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(transactionValue, that.transactionValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, balanceId, transactionDate, transactionValue);
    }

    @Override
    public String toString() {
        return "TransactionsInfoDto{" +
                "transactionId=" + transactionId +
                ", balanceId=" + balanceId +
                ", transactionDate=" + transactionDate +
                ", transactionValue=" + transactionValue +
                '}';
    }
}
