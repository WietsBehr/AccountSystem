package za.ac.nwu.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.logic.flow.FetchTransactionFlow;
import javax.transaction.Transactional;

@Transactional
@Component
public class FetchTransactionFlowImpl implements FetchTransactionFlow {
}
