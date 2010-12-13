package org.powertac.common.interfaces;

import org.powertac.common.commands.*;

import java.util.List;

public interface AccountingService {

    /**
     * Save individual meter reading on a customer basis
     * and calculate meter reading balance
     * @param meterReadingCommandList
     * @return List<MeterReadingBalanceCommand> a list of meter reading balances per broker
     */
    List<MeterReadingBalance> processMeterReadings(List<MeterReadingCommand> meterReadingCommandList);

    /**
     *
     * @param depotUpdate
     * @return DepotChangedCommand Latest DepotChanged which contains change, balance and reason
     */
    DepotChanged processDepotUpdate(DepotUpdate depotUpdate);

    /**
     *
     * @param cashUpdate
     * @return CashChangedCommand Latest CashChanged which contains change, balance and reason
     */
    CashChanged processCashUpdate(CashUpdate cashUpdate);

    /**
     *
     * @return a list of all active tariffs
     */
    List<TariffPublishCommand> publishTariffList();

    /**
     * Stores and forwards the tariffReplyCommand to its corresponding broker
     * @param tariffReplyCommand
     * @return the identical tariffReplyCommand parameter
     */
    TariffReplyCommand processTariffReply(TariffReplyCommand tariffReplyCommand);

    /**
     * Stores and forwards the list of customer info
     * @return the identical customerInfo parameter
     */
    List<CustomerInfo> processCustomerInfo(List<CustomerInfo> customerInfo);

}
