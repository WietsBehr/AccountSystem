package za.ac.nwu.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.domain.persistence.BalanceTable;

import java.io.Serializable;
import java.util.Objects;

public class BalanceDto implements Serializable {

    private static final long serialVersionUID = -4937287778746371405L;

    private String currency;
    private Long balanceToday;
    private Long balanceLastWeek;

    public BalanceDto(){
    }

    public BalanceDto(String currency, Long balanceToday, Long balanceLastWeek) {
        this.currency = currency;
        this.balanceToday = balanceToday;
        this.balanceLastWeek = balanceLastWeek;
    }

    public BalanceDto(BalanceTable balanceTable){
        this.setCurrency(balanceTable.getCurrency());
        this.setBalanceToday(balanceTable.getBalanceToday());
        this.setBalanceLastWeek(balanceTable.getBalanceLastWeek());
    }



    //TODO: Check names
    @ApiModelProperty(position = 1,
            value = "BalanceTable Currency",
            name = "Currency",
            notes = "Identifies the currency",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)
    public String getCurrency() {return currency;}

    public void setCurrency(String currency) {this.currency = currency;}

    @ApiModelProperty(position = 2,
            value = "BalanceTable BalanceToday",
            name = "BalanceToday",
            notes = "Today's balance",
            dataType = "java.lang.Long",
            example = "1000",
            allowEmptyValue = true)
    public Long getBalanceToday() {
        return balanceToday;
    }

    public void setBalanceToday(Long balanceToday) {
        this.balanceToday = balanceToday;
    }

    @ApiModelProperty(position = 3,
            value = "BalanceTable BalanceLastWeek",
            name = "BalanceLastWeek",
            notes = "Balance of 7 days ago",
            dataType = "java.lang.Long",
            example = "1000",
            allowEmptyValue = true)
    public Long getBalanceLastWeek() {
        return balanceLastWeek;
    }

    public void setBalanceLastWeek(Long balanceLastWeek) {
        this.balanceLastWeek = balanceLastWeek;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalanceDto that = (BalanceDto) o;
        return Objects.equals(currency, that.currency) && Objects.equals(balanceToday, that.balanceToday) && Objects.equals(balanceLastWeek, that.balanceLastWeek);
    }

    @JsonIgnore
    public BalanceTable getBalanceTable(){
        return new BalanceTable(getCurrency(),getBalanceToday(),getBalanceLastWeek());
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, balanceToday, balanceLastWeek);
    }

    @Override
    public String toString() {
        return "BalanceDto{" +
                "currency='" + currency + '\'' +
                ", balanceToday=" + balanceToday +
                ", balanceLastWeek=" + balanceLastWeek +
                '}';
    }


}
