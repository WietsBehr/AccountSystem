package za.ac.nwu.logic.flow;

import za.ac.nwu.domain.dto.TransactionDto;

import java.util.List;

public interface FetchTransactionFlow {
    List<TransactionDto> getAllTransactions();
}
