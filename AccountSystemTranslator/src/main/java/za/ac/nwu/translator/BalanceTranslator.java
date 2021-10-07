package za.ac.nwu.translator;

import za.ac.nwu.domain.dto.BalanceDto;

import java.util.List;

public interface BalanceTranslator {
    List<BalanceDto> getAllBalances();

    BalanceDto create(BalanceDto balanceDto);

    BalanceDto getBalanceNativeQuery(Long balanceId);
}
