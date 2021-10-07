package za.ac.nwu.logic.flow;

import za.ac.nwu.domain.dto.BalanceDto;

public interface CreateBalanceFlow {
    BalanceDto create(BalanceDto balanceDto);
}
