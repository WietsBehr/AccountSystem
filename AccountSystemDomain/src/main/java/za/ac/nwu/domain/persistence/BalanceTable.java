package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "BALANCE")
public class BalanceTable implements Serializable {
    private static final long serialVersionUID = 600388944427184027L;

    private Long balanceId;
    private String currency;
    private Long getBalanceToday;
    private Long balanceValueLastWeek;

    private Set<Transaction> transaction;

    public BalanceTable(Long balanceId, String currency, Long getBalanceToday, Long balanceValueLastWeek) {
        this.balanceId = balanceId;
        this.currency = currency;
        this.getBalanceToday = getBalanceToday;
        this.balanceValueLastWeek = balanceValueLastWeek;
    }

    public BalanceTable() {
    }

    @Column(name = "BALANCE_VALUE_LAST_WEEK")
    public Long getBalanceLastWeek() {
        return balanceValueLastWeek;
    }

    public void setBalanceLastWeek(Long balanceValueLastWeek) {
        this.balanceValueLastWeek = balanceValueLastWeek;
    }

    @Column(name = "BALANCE_VALUE_TODAY")
    public Long getBalanceToday() {
        return getBalanceToday;
    }

    public void setBalanceToday(Long balanceValueToday) {
        this.getBalanceToday = balanceValueToday;
    }

    @Column(name = "CURRENCY", length = 10)
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @OneToMany(targetEntity = Transaction.class, fetch = FetchType.LAZY, mappedBy = "balanceTable", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<Transaction> getTransaction(){
        return transaction;
    }

    public void setTransaction(Set<Transaction> transaction){
        this.transaction = transaction;
    }

    @Id
    @Column(name = "BALANCE_ID", nullable = false)
    public Long getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(Long balanceId) {
        this.balanceId = balanceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalanceTable that = (BalanceTable) o;
        return Objects.equals(balanceId, that.balanceId) && Objects.equals(currency, that.currency) && Objects.equals(getBalanceToday, that.getBalanceToday) && Objects.equals(balanceValueLastWeek, that.balanceValueLastWeek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balanceId, currency, getBalanceToday, balanceValueLastWeek);
    }

    @Override
    public String toString() {
        return "BalanceTable{" +
                "balanceId=" + balanceId +
                ", currency='" + currency + '\'' +
                ", getBalanceToday=" + getBalanceToday +
                ", balanceValueLastWeek=" + balanceValueLastWeek +
                '}';
    }
}