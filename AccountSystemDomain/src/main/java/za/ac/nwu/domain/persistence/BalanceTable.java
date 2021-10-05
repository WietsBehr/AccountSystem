package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "BALANCE", schema = "HR")
public class BalanceTable implements Serializable{

    private static final long serialVersionUID = 2236142550177114386L;

    private Long balanceId;
    private String currency;
    private float balanceToday;
    private float balanceLastWeek;

    private Set<TransactionsInfo> transactionsInfo;
    private Set<Transaction> transaction;

    public BalanceTable(Long balanceId, String currency, float balanceToday, float balanceLastWeek, Set<TransactionsInfo> transactionsInfo, Set<Transaction> transaction) {
        this.balanceId = balanceId;
        this.currency = currency;
        this.balanceToday = balanceToday;
        this.balanceLastWeek = balanceLastWeek;
        this.transactionsInfo = transactionsInfo;
        this.transaction = transaction;
    }

    @Id
    @SequenceGenerator(name = "BALANCE_ID_GENERIC_SEQ", sequenceName = "HR.BALANCE_ID_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BALANCE_ID_GENERIC_SEQ")
    @Column(name = "BALANCE_ID")
    public Long getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(Long balanceId) {
        this.balanceId = balanceId;
    }

    @Column(name = "CURRENCY")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Column(name = "BALANCE_VALUE_TODAY")
    public float getBalanceToday() {
        return balanceToday;
    }

    public void setBalanceToday(float balanceToday) {
        this.balanceToday = balanceToday;
    }

    @Column(name = "BALANCE_VALUE_LAST_WEEK")
    public float getBalanceLastWeek() {
        return balanceLastWeek;
    }

    public void setBalanceLastWeek(float balanceLastWeek) {
        this.balanceLastWeek = balanceLastWeek;
    }

    @OneToMany(targetEntity = TransactionsInfo.class, fetch = FetchType.LAZY, mappedBy = "balanceId", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<TransactionsInfo> getTransactionsInfo(){
        return transactionsInfo;
    }

    public void setTransactionsInfo(Set<TransactionsInfo> transactionsInfo){
        this.transactionsInfo = transactionsInfo;
    }

    @OneToMany(targetEntity = Transaction.class, fetch = FetchType.LAZY, mappedBy = "balanceId", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<Transaction> getTransaction(){
        return transaction;
    }

    public void setTransaction(Set<Transaction> transaction){
        this.transaction = transaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalanceTable that = (BalanceTable) o;
        return Float.compare(that.balanceToday, balanceToday) == 0 && Float.compare(that.balanceLastWeek, balanceLastWeek) == 0 && Objects.equals(balanceId, that.balanceId) && Objects.equals(currency, that.currency) && Objects.equals(transactionsInfo, that.transactionsInfo) && Objects.equals(transaction, that.transaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balanceId, currency, balanceToday, balanceLastWeek, transactionsInfo, transaction);
    }

    @Override
    public String toString() {
        return "BalanceTable{" +
                "balanceId=" + balanceId +
                ", currency='" + currency + '\'' +
                ", balanceToday=" + balanceToday +
                ", balanceLastWeek=" + balanceLastWeek +
                ", transactionsInfo=" + transactionsInfo +
                ", transaction=" + transaction +
                '}';
    }
}
