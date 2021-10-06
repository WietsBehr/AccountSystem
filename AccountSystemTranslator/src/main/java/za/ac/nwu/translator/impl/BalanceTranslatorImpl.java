package za.ac.nwu.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.BalanceDto;
import za.ac.nwu.domain.persistence.BalanceTable;
import za.ac.nwu.repo.persistence.BalanceRepo;
import za.ac.nwu.translator.BalanceTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class BalanceTranslatorImpl implements BalanceTranslator {
    private final BalanceRepo balanceRepo;

    @Autowired
    public BalanceTranslatorImpl(BalanceRepo balanceRepo){
        this.balanceRepo = balanceRepo;
    }

    @Override
    public List<BalanceDto> getAllBalances() {
        List<BalanceDto> balances = new ArrayList<>();
        try {
            for (BalanceTable balance : balanceRepo.findAll()) {
                balances.add(new BalanceDto(balance));
            }
        } catch (Exception e) {
            throw new RuntimeException("Not able to read from database.", e);
        }
        return balances;
    }

    @Override
    public BalanceDto create(BalanceDto balanceDto) {
        try {
            BalanceTable balanceTable = balanceRepo.save(balanceDto.getBalanceTable());
            return new BalanceDto(balanceTable);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to database", e);
        }
    }
}
