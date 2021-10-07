package za.ac.nwu.repo.persistence;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.persistence.BalanceTable;

@Repository
public interface BalanceRepo  extends JpaRepository<BalanceTable, Long> {

    @Query(value = "SELECT " +
            " BALANCE_ID, " +
            " BALANCE_VALUE_LAST_WEEK, " +
            " BALANCE_VALUE_TODAY, " +
            " CURRENCY " +
            " FROM "+
            " HR.BALANCE "+
            " WHERE BALANCE_ID = :balanceId ", nativeQuery = true)
    BalanceTable getBalanceNativeQuery(Long balanceId);

}
