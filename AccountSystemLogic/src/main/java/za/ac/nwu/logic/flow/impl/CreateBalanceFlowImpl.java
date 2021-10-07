package za.ac.nwu.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.BalanceDto;
import za.ac.nwu.logic.flow.CreateBalanceFlow;
import za.ac.nwu.translator.BalanceTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
public class CreateBalanceFlowImpl implements CreateBalanceFlow {

    private final BalanceTranslator balanceTranslator;

    @Autowired
    public CreateBalanceFlowImpl(BalanceTranslator balanceTranslator) {
        this.balanceTranslator = balanceTranslator;
    }
    //private static final Logger LOGGER = LoggerFactory.getLogger(CreateBalanceFlowImpl.class);

    @Override
    public BalanceDto create(BalanceDto balance){
        //LOGGER.info("Input: {}", balance);
//        if(null == balance.getBalanceToday()) {
//            balance.setBalanceToday(1000L);
//        }

        BalanceDto createBal = createBalance(balance);
        return createBal;
    }

    private BalanceDto createBalance(BalanceDto balance) {
        return balanceTranslator.create(balance);
    }
}
