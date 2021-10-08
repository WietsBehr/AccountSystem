package za.ac.nwu.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.BalanceDto;
import za.ac.nwu.domain.dto.TransactionDto;
import za.ac.nwu.domain.persistence.BalanceTable;
import za.ac.nwu.domain.persistence.Transaction;
import za.ac.nwu.repo.persistence.BalanceRepo;
import za.ac.nwu.repo.persistence.TransactionRepo;
import za.ac.nwu.translator.TransactionTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionTranslatorImpl implements TransactionTranslator {
    private final TransactionRepo transactionRepo;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public TransactionTranslatorImpl(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        List<TransactionDto> transactions = new ArrayList<>();
        try {
            for (Transaction transaction : transactionRepo.findAll()) {
                transactions.add(new TransactionDto(transaction));
            }
        } catch (Exception e) {
            throw new RuntimeException("Not able to read from database.", e);
        }
        return transactions;
    }

    @Override
    public TransactionDto createT(TransactionDto transactionDto) {
        try {
            Transaction transaction = transactionRepo.save(transactionDto.getTransaction());
            return new TransactionDto(transaction);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to database", e);
        }
    }


}
