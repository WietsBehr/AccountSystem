package za.ac.nwu.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.domain.persistence.BalanceTable;
import za.ac.nwu.domain.persistence.Transaction;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "Transaction", description = "A DTO that represents the Transaction")
public class TransactionDto implements Serializable {

    private static final long serialVersionUID = 8785041498325393838L;
    private BalanceTable balanceId;
    private Long valueToAdd;
    private Long valueToSubtract;
    private LocalDate createdDate;

    public TransactionDto(BalanceTable balanceId,Long valueToAdd, Long valueToSubtract, LocalDate createdDate) {
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





    @ApiModelProperty(position = 1,
            value = "Transaction Balance_Id",
            name = "BalanceId",
            notes = "Identifies the client's balance Id",
            dataType = "java.lang.Long",
            example = "31535L",
            required = true)
    public BalanceTable getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(BalanceTable balanceId) {
        this.balanceId = balanceId;
    }

    @ApiModelProperty(position = 2,
            value = "Transaction Value to add",
            name = "ValueToAdd",
            notes = "The value to add to the balance.",
            dataType = "java.lang.Long",
            example = "1500L",
            allowEmptyValue = true)
    public Long getValueToAdd() {
        return valueToAdd;
    }

    public void setValueToAdd(Long valueToAdd) {
        this.valueToAdd = valueToAdd;
    }

    @ApiModelProperty(position = 3,
            value = "Transaction Value_To_Subtract",
            name = "ValueToSubtract",
            notes = "The value to subtract to the balance.",
            dataType = "java.lang.Long",
            example = "500L",
            allowEmptyValue = true)
    public Long getValueToSubtract() {
        return valueToSubtract;
    }

    public void setValueToSubtract(Long valueToSubtract) {
        this.valueToSubtract = valueToSubtract;
    }

    @ApiModelProperty(position = 4,
            value = "Transaction Created_Date",
            name = "CreatedDate",
            notes = "The date the transaction was made",
            dataType = "java.lang.String",
            example = "2021-10-10",
            allowEmptyValue = true)
    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @JsonIgnore
    public Transaction getTransaction(){
        return new Transaction(getBalanceId(),getValueToAdd(), getValueToSubtract(), getCreatedDate());
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

