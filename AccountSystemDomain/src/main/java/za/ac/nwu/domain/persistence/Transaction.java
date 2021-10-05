package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "TRANSACTION", schema = "HR")
public class Transaction implements Serializable{

    private static final long serialVersionUID = 8335433203216599611L;
    private Long transactionId;
    private BalanceTable balanceId;
    private float valueToAdd;
    private float valueToSubtract;
    private LocalDate createdDate;

    private Set<TransactionsInfo> transactionsInfo;


    public Transaction(Long transactionId, BalanceTable balanceId, float valueToAdd, float valueToSubtract, LocalDate createdDate, Set<TransactionsInfo> transactionsInfo) {
        this.transactionId = transactionId;
        this.balanceId = balanceId;
        this.valueToAdd = valueToAdd;
        this.valueToSubtract = valueToSubtract;
        this.createdDate = createdDate;
        this.transactionsInfo = transactionsInfo;
    }

    @Id
    @SequenceGenerator(name = "TRANSACTION_ID_GENERIC_SEQ", sequenceName = "HR.TRANSACTION_ID_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTION_ID_GENERIC_SEQ")
    @Column(name = "TRANSACTION_ID")
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
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

    @Column(name = "VALUE_TO_ADD")
    public float getValueToAdd() {
        return valueToAdd;
    }

    public void setValueToAdd(float valueToAdd) {
        this.valueToAdd = valueToAdd;
    }

    @Column(name = "VALUE_TO_SUBTRACT")
    public float getValueToSubtract() {
        return valueToSubtract;
    }

    public void setValueToSubtract(float valueToSubtract) {
        this.valueToSubtract = valueToSubtract;
    }

    @Column(name = "CREATED_DATE")
    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @OneToMany(targetEntity = TransactionsInfo.class, fetch = FetchType.LAZY, mappedBy = "balanceId", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<TransactionsInfo> getTransactionsInfo(){
        return transactionsInfo;
    }

    public void setTransactionsInfo(Set<TransactionsInfo> transactionsInfo){
        this.transactionsInfo = transactionsInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Float.compare(that.valueToAdd, valueToAdd) == 0 && Float.compare(that.valueToSubtract, valueToSubtract) == 0 && Objects.equals(transactionId, that.transactionId) && Objects.equals(balanceId, that.balanceId) && Objects.equals(createdDate, that.createdDate) && Objects.equals(transactionsInfo, that.transactionsInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, balanceId, valueToAdd, valueToSubtract, createdDate, transactionsInfo);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", balanceId=" + balanceId +
                ", valueToAdd=" + valueToAdd +
                ", valueToSubtract=" + valueToSubtract +
                ", createdDate=" + createdDate +
                ", transactionsInfo=" + transactionsInfo +
                '}';
    }
}
