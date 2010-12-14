package org.powertac.common.commands;

import org.powertac.common.interfaces.Customer;

import java.math.BigDecimal;


public class MeterReading {
  Customer customer;
  Long timeslotId;
  BigDecimal meterReading;
}
