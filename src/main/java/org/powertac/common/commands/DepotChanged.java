package org.powertac.common.commands;

import org.joda.time.LocalDateTime;

import java.math.BigDecimal;

/**
 * User: cblock
 * Date: 01.12.10
 * Time: 16:45
 */
public class DepotChanged {
  Long brokerId;
  Long productId;
  Long transactionId;
  BigDecimal depotChange;
  BigDecimal balance;
  String reason;
  String origin;
  LocalDateTime dateCreated;
}
