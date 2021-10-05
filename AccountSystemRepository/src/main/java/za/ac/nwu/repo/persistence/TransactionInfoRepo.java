package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.persistence.TransactionsInfo;

@Repository
public interface TransactionInfoRepo extends JpaRepository<TransactionsInfo, Long>{
}

