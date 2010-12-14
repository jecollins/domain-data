package org.powertac.common.commands;

import org.powertac.common.Constants;
import org.powertac.common.enumerations.BuySellIndicator;
import org.powertac.common.enumerations.OrderType;

import java.math.BigDecimal;

/**
 * Command object that represents a new (incoming) shout from a broker that should be
 * matched in the power tac wholesale market
 *
 * Note: Use ShoutBuilder to create new or convert between Shout objects
 *
 * @author Carsten Block
 * @version 1.0, Date: 01.12.10
 * @see org.powertac.common.builders.ShoutBuilder
 */
public class ShoutCreate {
  private String authToken;
  private Long timeslotId;
  private Long productId;
  private BuySellIndicator buySellIndicator;
  private BigDecimal quantity;
  private BigDecimal limitPrice;
  private OrderType orderType = OrderType.MARKET;

    public ShoutCreate(String authToken, Long timeslotId, Long productId, BuySellIndicator buySellIndicator, BigDecimal quantity, BigDecimal limitPrice, OrderType orderType) {
        this.authToken = authToken;
        this.timeslotId = timeslotId;
        this.productId = productId;
        this.buySellIndicator = buySellIndicator;
        this.quantity = quantity;
        this.limitPrice = limitPrice;
        this.orderType = orderType;
    }

    public ShoutCreate(String authToken, Long timeslotId, Long productId, BuySellIndicator buySellIndicator, Double quantity, Double limitPrice, OrderType orderType) {
        this.authToken = authToken;
        this.timeslotId = timeslotId;
        this.productId = productId;
        this.buySellIndicator = buySellIndicator;
        this.quantity = quantity == null ? null : new BigDecimal(quantity).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE);
        this.limitPrice = limitPrice == null ? null : new BigDecimal(limitPrice).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE);
        this.orderType = orderType;
    }

    public String getAuthToken() {
        return authToken;
    }

    public Long getTimeslotId() {
        return timeslotId;
    }

    public Long getProductId() {
        return productId;
    }

    public BuySellIndicator getBuySellIndicator() {
        return buySellIndicator;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getLimitPrice() {
        return limitPrice;
    }

    public OrderType getOrderType() {
        return orderType;
    }
}
