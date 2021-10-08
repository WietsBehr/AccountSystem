package za.ac.nwu.translator;

import za.ac.nwu.domain.dto.BalanceDto;
import za.ac.nwu.domain.dto.TransactionDto;

import java.util.List;

public interface TransactionTranslator {

    List<TransactionDto> getAllTransactions();

    TransactionDto createT(TransactionDto balance);
}
