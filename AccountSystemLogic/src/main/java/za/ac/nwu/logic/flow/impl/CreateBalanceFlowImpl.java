package za.ac.nwu.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.BalanceDto;
import za.ac.nwu.logic.flow.CreateBalanceFlow;
import za.ac.nwu.translator.BalanceTranslator;

import javax.transaction.Transactional;

@Transactional
@Component("createBalanceFlowName")
public class CreateBalanceFlowImpl implements CreateBalanceFlow {

    private final BalanceTranslator balanceTranslator;

    public CreateBalanceFlowImpl(BalanceTranslator balanceTranslator) {
        this.balanceTranslator = balanceTranslator;
    }
    //private static final Logger LOGGER = LoggerFactory.getLogger(CreateBalanceFlowImpl.class);

    @Override
    public BalanceDto create(BalanceDto balance){
        //LOGGER.info("Input: {}", balance);
        if(null == balance.getBalanceToday()) {
            balance.setBalanceToday(1000L);
        }

        BalanceDto createMem = createMember(balance);
        return createMem;
    }

    private BalanceDto createMember(BalanceDto balanceToday) {
        return balanceTranslator.create(balanceToday);
    }
}
