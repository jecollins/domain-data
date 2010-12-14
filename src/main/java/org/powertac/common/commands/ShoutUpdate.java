package org.powertac.common.commands;

import org.powertac.common.Constants;

import java.math.BigDecimal;

/**
 * Command object that can be used by
 * a broker to require the server to change
 * price and / or quantity
 * an already issued shout specific shout;
 * <p/>
 * Note: Use ShoutBuilder to create new or convert between Shout objects
 *
 * @author Carsten Block
 * @version 1.0, Date: 01.12.10
 * @see org.powertac.common.builders.ShoutBuilder
 */
public class ShoutUpdate {
    private String authToken;
    private Long shoutId;
    private BigDecimal quantity;
    private BigDecimal limitPrice;

    public ShoutUpdate(String authToken, Long shoutId, BigDecimal quantity, BigDecimal limitPrice) {
        this.authToken = authToken;
        this.shoutId = shoutId;
        this.quantity = quantity;
        this.limitPrice = limitPrice;
    }

    public ShoutUpdate(String authToken, Long shoutId, Double quantity, Double limitPrice) {
        this.authToken = authToken;
        this.shoutId = shoutId;
        this.quantity = quantity == null ? null : new BigDecimal(quantity).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE);
        this.limitPrice = limitPrice == null ? null : new BigDecimal(limitPrice).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE);
    }

    public String getAuthToken() {
        return authToken;
    }

    public Long getShoutId() {
        return shoutId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getLimitPrice() {
        return limitPrice;
    }
}
