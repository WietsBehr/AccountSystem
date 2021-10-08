package za.ac.nwu.logic.flow;

import za.ac.nwu.domain.dto.TransactionDto;

public interface CreateTransactionFlow {
    TransactionDto createT(TransactionDto transactionDto);
}
