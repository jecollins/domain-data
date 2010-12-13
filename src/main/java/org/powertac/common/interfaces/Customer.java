package org.powertac.common.interfaces;

import org.powertac.common.commands.*;

import java.util.List;

public interface Customer {

    //void processTimeslot(TimeslotCreated timeslotCreatedCommand);
    //void processTimeslot(TimeslotChanged timeslotChanged);

    /**
     *
     * @param List<TariffPublishedCommand> tariffPublishList
     * @return A list of possible tariff replies which represent subscriptions or negotiation interactions
     */
    List<TariffReply> processTariffList(List<TariffPublish> tariffPublishList);

    /**
     * Called when a new weather forecast is available
     * @param weatherForecastDataList weather forecast for a timeslot
     */
    void processWeatherForecasts(List<WeatherForecastData> weatherForecastDataList);

    MeterReading generateMeterReading(WeatherRealData weatherRealData);

    CustomerInfo generateCustomerInfo();
}
