package za.ac.nwu.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.BalanceDto;
import za.ac.nwu.domain.dto.TransactionDto;
import za.ac.nwu.logic.flow.FetchTransactionFlow;
import za.ac.nwu.translator.TransactionTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchTransactionFlowImpl implements FetchTransactionFlow {

    private final TransactionTranslator transactionTranslator;

    @Autowired
    public FetchTransactionFlowImpl(TransactionTranslator transactionTranslator) {
        this.transactionTranslator = transactionTranslator;
    }

    @Override
    public List<TransactionDto> getAllTransactions(){
        return transactionTranslator.getAllTransactions();
    }
}
