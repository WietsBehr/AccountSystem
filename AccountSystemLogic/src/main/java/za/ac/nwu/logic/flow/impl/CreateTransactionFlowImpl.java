package za.ac.nwu.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.BalanceDto;
import za.ac.nwu.domain.dto.TransactionDto;
import za.ac.nwu.logic.flow.CreateTransactionFlow;
import za.ac.nwu.translator.BalanceTranslator;
import za.ac.nwu.translator.TransactionTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
public class CreateTransactionFlowImpl implements CreateTransactionFlow {
    private final TransactionTranslator transactionTranslator;

    @Autowired
    public CreateTransactionFlowImpl(TransactionTranslator transactionTranslator) {
        this.transactionTranslator = transactionTranslator;
    }

    @Override
    public TransactionDto createT(TransactionDto transactionDto){
        TransactionDto createTrans = createTransaction(transactionDto);
        return createTrans;
    }

    private TransactionDto createTransaction(TransactionDto balance) {
        return transactionTranslator.createT(balance);
    }
}



