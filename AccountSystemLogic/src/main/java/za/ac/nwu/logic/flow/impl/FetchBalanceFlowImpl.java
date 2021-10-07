package za.ac.nwu.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.BalanceDto;
import za.ac.nwu.logic.flow.FetchBalanceFlow;
import za.ac.nwu.repo.persistence.BalanceRepo;
import za.ac.nwu.translator.BalanceTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
@Primary
@Qualifier("fetchBalanceFlowName")
public class FetchBalanceFlowImpl implements FetchBalanceFlow {

    private final BalanceTranslator balanceTranslator;

    @Autowired
    public FetchBalanceFlowImpl(BalanceTranslator balanceTranslator){
        this.balanceTranslator = balanceTranslator;
    }

    @Override
    public List<BalanceDto> getAllBalances(){
        return balanceTranslator.getAllBalances();
    }

    @Override
    public BalanceDto getBalanceNativeQuery(Long balanceId) {
        return balanceTranslator.getBalanceNativeQuery(balanceId);
    }

//    @Override
//    public BalanceDto getBalanceByBalanceId(Long balanceId){
//        return balanceTranslator.getBalanceNativeQuery(balanceId);
//    }


}
