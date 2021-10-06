package za.ac.nwu.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.BalanceDto;
import za.ac.nwu.logic.flow.FetchBalanceFlow;
import za.ac.nwu.repo.persistence.BalanceRepo;
import za.ac.nwu.translator.BalanceTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchBalanceFlowImpl implements FetchBalanceFlow {

    private final BalanceTranslator balanceTranslator;

    @Autowired
    public FetchBalanceFlowImpl(BalanceTranslator balanceTranslator){
        this.balanceTranslator = balanceTranslator;
    }

    @Override
    public List<BalanceDto> getAllBalances(){
        return viewAllBalances();
//        List<BalanceDto> balanceList = viewAllBalances();
//        return balanceList;
    }

    private List<BalanceDto> viewAllBalances(){
        return balanceTranslator.getAllBalances();
    }


}
