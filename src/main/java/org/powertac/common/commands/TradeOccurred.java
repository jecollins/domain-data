package org.powertac.common.commands;

import java.math.BigDecimal;

/**
 * Command object that represents trade date, i.e. price and
 * and quantity of a product that was traded in the market.
 *
 * @author Carsten Block
 * @version 1.0, Date: 01.12.10
 */
public class TradeOccurred {
  Long timeslotId;
  Long productId;
  BigDecimal price;
  BigDecimal quantity;
}
