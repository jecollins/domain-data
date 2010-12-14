package org.powertac.common.commands;

import org.joda.time.LocalDateTime;
import org.powertac.common.Constants;
import org.powertac.common.enumerations.BuySellIndicator;
import org.powertac.common.enumerations.ModReasonCode;
import org.powertac.common.enumerations.OrderType;

import java.math.BigDecimal;

/**
 * Command object that contains all data of a
 * particular shout from the Power TAC wholesale
 * market. It is an "enriched" version of the
 * <code>ShoutCreate</code> a broker originially
 * sends to the server and used to report back the current
 * execution status of a shout to the broker.
 *
 * Once created this object is immutable
 *
 * Note: Use ShoutBuilder to create new or convert between Shout objects
 *
 * @author Carsten Block
 * @version 1.0, Date: 01.12.10
 * @see org.powertac.common.builders.ShoutBuilder
 */
public class ShoutChanged {
    private Long shoutId;
    private Long transactionId;
    private Long productId;
    private Long timeslotId;
    private BuySellIndicator buySellIndicator;
    private BigDecimal quantity;
    private BigDecimal limitPrice;
    private OrderType orderType;

    private BigDecimal remainingQuantity;
    private BigDecimal executionQuantity;
    private BigDecimal executionPrice;

    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
    private ModReasonCode modReasonCode;

    public ShoutChanged(Long shoutId, Long transactionId, Long productId, Long timeslotId, BuySellIndicator buySellIndicator, BigDecimal quantity, BigDecimal limitPrice, OrderType orderType, BigDecimal remainingQuantity, BigDecimal executionQuantity, BigDecimal executionPrice, LocalDateTime dateCreated, LocalDateTime lastUpdated, ModReasonCode modReasonCode) {
        this.shoutId = shoutId;
        this.transactionId = transactionId;
        this.productId = productId;
        this.timeslotId = timeslotId;
        this.buySellIndicator = buySellIndicator;
        this.quantity = quantity;
        this.limitPrice = limitPrice;
        this.orderType = orderType;
        this.remainingQuantity = remainingQuantity;
        this.executionQuantity = executionQuantity;
        this.executionPrice = executionPrice;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
        this.modReasonCode = modReasonCode;
    }

    public ShoutChanged(Long shoutId, Long transactionId, Long productId, Long timeslotId, BuySellIndicator buySellIndicator, Double quantity, Double limitPrice, OrderType orderType, Double remainingQuantity, Double executionQuantity, Double executionPrice, LocalDateTime dateCreated, LocalDateTime lastUpdated, ModReasonCode modReasonCode) {
        this.shoutId = shoutId;
        this.transactionId = transactionId;
        this.productId = productId;
        this.timeslotId = timeslotId;
        this.buySellIndicator = buySellIndicator;
        this.quantity = quantity == null ? null : new BigDecimal(quantity).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE);
        this.limitPrice = limitPrice == null ? null : new BigDecimal(limitPrice).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE);
        this.orderType = orderType;
        this.remainingQuantity = remainingQuantity == null ? null : new BigDecimal(remainingQuantity).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE);
        this.executionQuantity = executionQuantity == null ? null : new BigDecimal(executionQuantity).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE);
        this.executionPrice = executionPrice == null ? null : new BigDecimal(executionPrice).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE);
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
        this.modReasonCode = modReasonCode;
    }

    public Long getShoutId() {
        return shoutId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getTimeslotId() {
        return timeslotId;
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

    public BigDecimal getRemainingQuantity() {
        return remainingQuantity;
    }

    public BigDecimal getExecutionQuantity() {
        return executionQuantity;
    }

    public BigDecimal getExecutionPrice() {
        return executionPrice;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public ModReasonCode getModReasonCode() {
        return modReasonCode;
    }
}
