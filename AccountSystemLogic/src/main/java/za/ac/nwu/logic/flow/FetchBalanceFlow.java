package za.ac.nwu.logic.flow;

import za.ac.nwu.domain.dto.BalanceDto;

import java.util.List;

public interface FetchBalanceFlow {
    List<BalanceDto> getAllBalances();
}
