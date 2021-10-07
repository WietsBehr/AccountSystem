package za.ac.nwu.repo.persistence;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.persistence.Transaction;

@Qualifier("transaction")
@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long>{
}
