/*
 * Copyright 2009-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an
 * "AS IS" BASIS,  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package org.powertac.common.builders;

import org.joda.time.LocalDateTime;
import org.powertac.common.Constants;
import org.powertac.common.commands.ShoutChanged;
import org.powertac.common.commands.ShoutCreate;
import org.powertac.common.commands.ShoutDelete;
import org.powertac.common.commands.ShoutUpdate;
import org.powertac.common.enumerations.BuySellIndicator;
import org.powertac.common.enumerations.ModReasonCode;
import org.powertac.common.enumerations.OrderType;

import java.math.BigDecimal;

/**
 * Shout Builder allows easy creation and conversion of Shout objects using method chaining
 *
 * @author Carsten Block
 * @version 1.0, Date: 14.12.10
 */
public class ShoutBuilder {

    private String authToken;
    private Long timeslotId;
    private Long productId;
    private Long shoutId;
    private Long transactionId;
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

    /**
     * Private constructor used by static methods to construct CashBuilder instances
     */
    private ShoutBuilder() {
        super();
    }

    /**
     * Generates a new ShoutBuilder instance using null values for all shout fields
     *
     * @return ShoutBuilder initialized with null values for all shout fields
     */
    public static ShoutBuilder withEmpty() {
        return new ShoutBuilder();
    }

    /**
     * Generates a ShoutBuilder instance populating the shout properties with those from the
     * given shoutChanged object
     *
     * @param shoutChanged object from which shout properties are taken to populate shoutBuilder instance
     * @return shoutBuilder instance with properties populated from shoutChanged object
     */
    public static ShoutBuilder withShoutChanged(ShoutChanged shoutChanged) {
        ShoutBuilder shoutBuilder = new ShoutBuilder();
        if (shoutChanged != null) {
            shoutBuilder.shoutId = shoutChanged.getShoutId();
            shoutBuilder.transactionId = shoutChanged.getTransactionId();
            shoutBuilder.productId = shoutChanged.getProductId();
            shoutBuilder.timeslotId = shoutChanged.getTimeslotId();
            shoutBuilder.buySellIndicator = shoutChanged.getBuySellIndicator();
            shoutBuilder.quantity = shoutChanged.getQuantity();
            shoutBuilder.limitPrice = shoutChanged.getLimitPrice();
            shoutBuilder.orderType = shoutChanged.getOrderType();
            shoutBuilder.remainingQuantity = shoutChanged.getRemainingQuantity();
            shoutBuilder.executionQuantity = shoutChanged.getExecutionQuantity();
            shoutBuilder.executionPrice = shoutChanged.getExecutionPrice();
            shoutBuilder.dateCreated = shoutChanged.getDateCreated();
            shoutBuilder.lastUpdated = shoutChanged.getLastUpdated();
            shoutBuilder.modReasonCode = shoutChanged.getModReasonCode();
        }
        return shoutBuilder;
    }

    /**
     * Generates a ShoutBuilder instance populating the shout properties with those from the
     * given shoutCreate object
     *
     * @param shoutCreate object from which shout properties are taken to populate shoutBuilder instance
     * @return shoutBuilder instance with properties populated from shoutCreate object
     */
    public static ShoutBuilder withShoutCreate(ShoutCreate shoutCreate) {
        ShoutBuilder shoutBuilder = new ShoutBuilder();
        if (shoutCreate != null) {
            shoutBuilder.authToken = shoutCreate.getAuthToken();
            shoutBuilder.timeslotId = shoutCreate.getTimeslotId();
            shoutBuilder.productId = shoutCreate.getProductId();
            shoutBuilder.buySellIndicator = shoutCreate.getBuySellIndicator();
            shoutBuilder.quantity = shoutCreate.getQuantity();
            shoutBuilder.limitPrice = shoutCreate.getLimitPrice();
            shoutBuilder.orderType = shoutCreate.getOrderType();
        }
        return shoutBuilder;
    }

    /**
     * Generates a ShoutBuilder instance populating the shout properties with those from the
     * given shoutDelete object
     *
     * @param shoutDelete object from which shout properties are taken to populate shoutBuilder instance
     * @return shoutBuilder instance with properties populated from shoutDelete object
     */
    public static ShoutBuilder withShoutDelete(ShoutDelete shoutDelete) {
        ShoutBuilder shoutBuilder = new ShoutBuilder();
        if (shoutDelete != null) {
            shoutBuilder.authToken = shoutDelete.getAuthToken();
            shoutBuilder.shoutId = shoutDelete.getShoutId();
        }
        return shoutBuilder;
    }

    /**
     * Generates a ShoutBuilder instance populating the shout properties with those from the
     * given shoutUpdate object
     *
     * @param shoutUpdate object from which shout properties are taken to populate shoutBuilder instance
     * @return shoutBuilder instance with properties populated from shoutUpdate object
     */
    public static ShoutBuilder withShoutUpdate(ShoutUpdate shoutUpdate) {
        ShoutBuilder shoutBuilder = new ShoutBuilder();
        if (shoutUpdate != null) {
            shoutBuilder.authToken = shoutUpdate.getAuthToken();
            shoutBuilder.shoutId = shoutUpdate.getShoutId();
            shoutBuilder.quantity = shoutUpdate.getQuantity();
            shoutBuilder.limitPrice = shoutUpdate.getLimitPrice();
        }
        return shoutBuilder;
    }

    /**
     * Sets the authToken in the ShoutBuilder
     *
     * @param authToken object to use for building new shout instances
     * @return shoutBuilder instance with updated authToken property
     */
    public ShoutBuilder setAuthToken(String authToken) {
        this.authToken = authToken;
        return this;
    }

    /**
     * Sets the timeslotId in the ShoutBuilder
     *
     * @param timeslotId value to use for building new shout instances
     * @return shoutBuilder instance with updated timeslotId property
     */
    public ShoutBuilder setTimeslotId(Long timeslotId) {
        this.timeslotId = timeslotId;
        return this;
    }

    /**
     * Sets the productId in the ShoutBuilder
     *
     * @param productId value to use for building new shout instances
     * @return shoutBuilder instance with updated productId property
     */
    public ShoutBuilder setProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    /**
     * Sets the shoutId in the ShoutBuilder
     *
     * @param shoutId value to use for building new shout instances
     * @return shoutBuilder instance with updated shoutId property
     */
    public ShoutBuilder setShoutId(Long shoutId) {
        this.shoutId = shoutId;
        return this;
    }

    /**
     * Sets the transactionId in the ShoutBuilder
     *
     * @param transactionId value to use for building new shout instances
     * @return shoutBuilder instance with updated transactionId property
     */
    public ShoutBuilder setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    /**
     * Sets the buySellIndicator in the ShoutBuilder
     *
     * @param buySellIndicator value to use for building new shout instances
     * @return shoutBuilder with updated buySellIndicator property
     */
    public ShoutBuilder setBuySellIndicator(BuySellIndicator buySellIndicator) {
        this.buySellIndicator = buySellIndicator;
        return this;
    }

    /**
     * Sets the quantity variable in the ShoutBuilder
     *
     * @param quantity value to use during building of target object
     * @return ShoutBuilder with updated quantity property
     */
    public ShoutBuilder setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * Sets the quantity variable in the ShoutBuilder
     *
     * @param quantity value to use during building of target object
     * @return ShoutBuilder with updated quantity property
     */
    public ShoutBuilder setQuantity(Double quantity) {
        this.quantity = quantity == null ? null : new BigDecimal(quantity).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE);
        return this;
    }

    /**
     * Sets the limitPrice variable in the ShoutBuilder
     *
     * @param limitPrice value to use during building of target object
     * @return ShoutBuilder with updated limitPrice property
     */
    public ShoutBuilder setLimitPrice(BigDecimal limitPrice) {
        this.limitPrice = limitPrice;
        return this;
    }

    /**
     * Sets the limitPrice variable in the ShoutBuilder
     *
     * @param limitPrice value to use during building of target object
     * @return ShoutBuilder with updated limitPrice property
     */
    public ShoutBuilder setLimitPrice(Double limitPrice) {
        this.limitPrice = limitPrice == null ? null : new BigDecimal(limitPrice).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE);
        return this;
    }

    /**
     * Sets the orderType variable in the ShoutBuilder
     *
     * @param orderType value to use during building of target object
     * @return ShoutBuilder with updated orderType property
     */
    public ShoutBuilder setOrderType(OrderType orderType) {
        this.orderType = orderType;
        return this;
    }

    /**
     * Sets the remainingQuantity variable in the ShoutBuilder
     *
     * @param remainingQuantity value to use during building of target object
     * @return ShoutBuilder with updated remainingQuantity property
     */
    public ShoutBuilder setRemainingQuantity(BigDecimal remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
        return this;
    }

    /**
     * Sets the remainingQuantity variable in the ShoutBuilder
     *
     * @param remainingQuantity value to use during building of target object
     * @return ShoutBuilder with updated remainingQuantity property
     */
    public ShoutBuilder setRemainingQuantity(Double remainingQuantity) {
        this.remainingQuantity = remainingQuantity == null ? null : new BigDecimal(remainingQuantity).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE);
        return this;
    }

    /**
     * Sets the executionQuantity variable in the ShoutBuilder
     *
     * @param executionQuantity value to use during building of target object
     * @return ShoutBuilder with updated executionQuantity property
     */
    public ShoutBuilder setExecutionQuantity(BigDecimal executionQuantity) {
        this.executionQuantity = executionQuantity;
        return this;
    }

    /**
     * Sets the executionQuantity variable in the ShoutBuilder
     *
     * @param executionQuantity value to use during building of target object
     * @return ShoutBuilder with updated executionQuantity property
     */
    public ShoutBuilder setExecutionQuantity(Double executionQuantity) {
        this.executionQuantity = executionQuantity == null ? null : new BigDecimal(executionQuantity).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE);
        return this;
    }

    /**
     * Sets the executionPrice variable in the ShoutBuilder
     *
     * @param executionPrice value to use during building of target object
     * @return ShoutBuilder with updated executionPrice property
     */
    public ShoutBuilder setExecutionPrice(BigDecimal executionPrice) {
        this.executionPrice = executionPrice;
        return this;
    }

    /**
     * Sets the executionPrice variable in the ShoutBuilder
     *
     * @param executionPrice value to use during building of target object
     * @return ShoutBuilder with updated executionPrice property
     */
    public ShoutBuilder setExecutionPrice(Double executionPrice) {
        this.executionPrice = executionPrice == null ? null : new BigDecimal(executionPrice).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE);
        return this;
    }

    /**
     * Sets the dateCreated variable in the ShoutBuilder
     *
     * @param dateCreated value to use during building of target object
     * @return ShoutBuilder with updated dateCreated property
     */
    public ShoutBuilder setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    /**
     * Sets the lastUpdated variable in the ShoutBuilder
     *
     * @param lastUpdated value to use during building of target object
     * @return ShoutBuilder with updated lastUpdated property
     */
    public ShoutBuilder setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    /**
     * Sets the modReasonCode variable in the ShoutBuilder
     *
     * @param modReasonCode value to use during building of target object
     * @return ShoutBuilder with updated modReasonCode property
     */
    public ShoutBuilder setModReasonCode(ModReasonCode modReasonCode) {
        this.modReasonCode = modReasonCode;
        return this;
    }

    /**
     * Creates a new {@link ShoutChanged} instance using previously set or updated shout properties from the builder
     *
     * @return new {@link ShoutChanged} object
     */
    public ShoutChanged buildShoutChanged() {
        return new ShoutChanged(this.shoutId, this.transactionId, this.productId, this.timeslotId, this.buySellIndicator, this.quantity, this.limitPrice, this.orderType, this.remainingQuantity, this.executionQuantity, this.executionPrice, this.dateCreated, this.lastUpdated, this.modReasonCode);
    }

    /**
     * Creates a new {@link ShoutCreate} instance using previously set or updated shout properties from the builder
     *
     * @return new {@link ShoutCreate} object
     */
    public ShoutCreate buildShoutCreate() {
        return new ShoutCreate(this.authToken, this.timeslotId, this.productId, this.buySellIndicator, this.quantity, this.limitPrice, this.orderType);
    }

    /**
     * Creates a new {@link ShoutDelete} instance using previously set or updated shout properties from the builder
     * @return new {@link ShoutDelete} object
     */
    public ShoutDelete buildShoutDelete() {
        return new ShoutDelete(this.authToken, this.shoutId);
    }

    public ShoutUpdate buildShoutUpdate() {
        return new ShoutUpdate(this.authToken, this.shoutId, this.quantity, this.limitPrice);
    }
}

