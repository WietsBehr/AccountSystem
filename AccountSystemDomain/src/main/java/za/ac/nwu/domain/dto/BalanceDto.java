package za.ac.nwu.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.domain.persistence.BalanceTable;

import java.io.Serializable;
import java.util.Objects;

public class BalanceDto implements Serializable {

    private static final long serialVersionUID = -4937287778746371405L;



    private Long balanceId;
    private String currency;
    private Long balanceToday;
    private Long balanceLastWeek;


    public BalanceDto(Long balanceId,String currency, Long balanceToday, Long balanceLastWeek) {
        this.balanceId = balanceId;
        this.currency = currency;
        this.balanceToday = balanceToday;
        this.balanceLastWeek = balanceLastWeek;
    }

    public BalanceDto(BalanceTable balanceTable){
        this.setBalanceId(balanceTable.getBalanceId());
        this.setCurrency(balanceTable.getCurrency());
        this.setBalanceToday(balanceTable.getBalanceToday());
        this.setBalanceLastWeek(balanceTable.getBalanceLastWeek());
    }


    @ApiModelProperty(position = 1,
            value = "BalanceTable Balance_Id",
            name = "Balance Id",
            notes = "Identifies the client's balance Id",
            dataType = "java.lang.Long",
            example = "00001L",
            required = true)
    public Long getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(Long balanceId) {
        this.balanceId = balanceId;
    }

    @ApiModelProperty(position = 2,
            value = "BalanceTable Currency",
            name = "Currency",
            notes = "Identifies the currency",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)
    public String getCurrency() {return currency;}

    public void setCurrency(String currency) {this.currency = currency;}

    @ApiModelProperty(position = 3,
            value = "BalanceTable Balance_Value_Today",
            name = "BalanceToday",
            notes = "Today's balance",
            dataType = "java.lang.Long",
            example = "1000L",
            allowEmptyValue = true)
    public Long getBalanceToday() {
        return balanceToday;
    }

    public void setBalanceToday(Long balanceToday) {
        this.balanceToday = balanceToday;
    }

    @ApiModelProperty(position = 4,
            value = "BalanceTable Balance_Value_Last_Week",
            name = "BalanceLastWeek",
            notes = "Balance of 7 days ago",
            dataType = "java.lang.Long",
            example = "1000L",
            allowEmptyValue = true)
    public Long getBalanceLastWeek() {
        return balanceLastWeek;
    }

    public void setBalanceLastWeek(Long balanceLastWeek) {
        this.balanceLastWeek = balanceLastWeek;
    }

    @JsonIgnore
    public BalanceTable getBalanceTable(){
        return new BalanceTable(getBalanceId(), getCurrency(),getBalanceToday(),getBalanceLastWeek());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalanceDto that = (BalanceDto) o;
        return Objects.equals(balanceId, that.balanceId) && Objects.equals(currency, that.currency) && Objects.equals(balanceToday, that.balanceToday) && Objects.equals(balanceLastWeek, that.balanceLastWeek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balanceId, currency, balanceToday, balanceLastWeek);
    }

    @Override
    public String toString() {
        return "BalanceDto{" +
                "balanceId=" + balanceId +
                ", currency='" + currency + '\'' +
                ", balanceToday=" + balanceToday +
                ", balanceLastWeek=" + balanceLastWeek +
                '}';
    }
}
