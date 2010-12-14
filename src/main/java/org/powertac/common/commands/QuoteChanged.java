package org.powertac.common.commands;

import org.joda.time.LocalDateTime;

import java.math.BigDecimal;

/**
 * A QuoteChanged essentially represents
 * an orderbook state up to the depth of 1 order on
 * the buy and sell side.
 *
 * @author Carsten Block
 * @version 1.0, Date: 01.12.10
 * @see OrderbookChanged
 */
public class QuoteChanged {
  LocalDateTime dateCreated;
    Long transactionID;
    Long timeslotId;
    Long productId;
    BigDecimal bid = null;
    BigDecimal bidSize = new BigDecimal(0);
    BigDecimal ask = null;
    BigDecimal askSize = new BigDecimal(0);

}
