package org.powertac.common.interfaces;

import org.powertac.common.commands.MeterReadingBalance;

import java.util.List;

public interface DistributionUtility {

      /* Model identification */
    String id();
    String name();

    void log(String message);

    /**
     *
     * @param meterReadingBalances
     * @return a list of DepotUpdate and CashUpdate objects
     */
    List processMeterReadingBalances(List<MeterReadingBalance> meterReadingBalances);

}
