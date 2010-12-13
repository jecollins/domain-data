package org.powertac.common.interfaces;

import org.powertac.common.commands.*;

import java.util.List;

public interface Customer {

    //void processTimeslot(TimeslotCreatedCommand timeslotCreatedCommand);
    //void processTimeslot(TimeslotChanged timeslotChanged);

    /**
     *
     * @param List<TariffPublishedCommand> tariffPublishList
     * @return A list of possible tariff replies which represent subscriptions or negotiation interactions
     */
    List<TariffReply> processTariffList(List<TariffPublish> tariffPublishList);

    MeterReading generateMeterReading(TimeslotChanged timeslotChanged);

    CustomerInfo generateCustomerInfo();
}
