package org.powertac.common.commands;

import java.math.BigDecimal;

/**
 * User: cblock
 * Date: 01.12.10
 * Time: 16:45
 */
public class DepotUpdate {
  Long brokerId;
  Long productId;
  BigDecimal depotChange;
  String reason;
  String origin; //the person or entity that caused the update
}
