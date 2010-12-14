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
import org.powertac.common.commands.CashChanged;
import org.powertac.common.commands.CashUpdate;

import java.math.BigDecimal;

/**
 * CashBuilder allows the easy creation of
 * CashObjects (<code>CashChanged<code> or <code>CashUpdate</code>)
 * using method chaning.
 * <p/>
 * Example: <code>CashBuilder
 * .withCashChanged(cashChangedInstance)
 * .setBalance(100.0)
 * .buildCashUpdate()</code>
 *
 * @author Carsten Block
 * @version 1.0, Date: 13.12.10
 * @see org.powertac.common.commands.CashChanged, CashUpdate
 */
public class CashBuilder {

    private Long brokerId;
    private BigDecimal moneyChange;
    private String reason;
    private String origin;
    private Long transactionId;
    private BigDecimal balance;
    private LocalDateTime dateCreated;

    /**
     * Private constructor used by static methods to construct CashBuilder instances
     */
    private CashBuilder() {
        super();
    }

    /**
     * Generates a new CashBuilder instance using null values for all cash fields
     *
     * @return CashBuilder initialized with null values for all cash fields
     */
    public static CashBuilder withEmpty() {
        return new CashBuilder();
    }

    /**
     * Generates a new CashBuilder instance using the cashChanged object
     * to pre-populate the Cash properties of the builder.
     *
     * @param cashChanged properties used to pre-populate the properties of the new Builder
     * @return CashBuilder initialized with the given values of the cashChanged object
     */
    public static CashBuilder withCashChanged(CashChanged cashChanged) {
        CashBuilder cashBuilder = new CashBuilder();
        if (cashChanged != null) {
            cashBuilder.brokerId = cashChanged.getBrokerId();
            cashBuilder.moneyChange = cashChanged.getMoneyChange();
            cashBuilder.reason = cashChanged.getReason();
            cashBuilder.origin = cashChanged.getOrigin();
            cashBuilder.transactionId = cashChanged.getTransactionId();
            cashBuilder.balance = cashChanged.getBalance();
            cashBuilder.dateCreated = cashChanged.getDateCreated();
        }
        return cashBuilder;
    }

    /**
     * Generates a new CashBuilder instance using the given cashUpdate object
     * to pre-populate the Cash properties of the builder.
     *
     * @param cashUpdate properties used to prepoluate Builder values
     * @return CashBuilder initialized with the given values of the given cashUpdate object
     */
    public static CashBuilder withCashUpdate(CashUpdate cashUpdate) {
        CashBuilder cashBuilder = new CashBuilder();
        if (cashUpdate != null) {
            cashBuilder.brokerId = cashUpdate.getBrokerId();
            cashBuilder.moneyChange = cashUpdate.getMoneyChange();
            cashBuilder.reason = cashUpdate.getReason();
            cashBuilder.origin = cashUpdate.getOrigin();
        }
        return cashBuilder;
    }

    /**
     * Sets the broker in the CashBuilder
     * @param brokerId id of the broker
     * @return CashBuilder instance with updated brokerId property
     */
    public CashBuilder setBrokerId(Long brokerId) {
        this.brokerId = brokerId;
        return this;
    }

    /**
     * Sets the moneyChange property in the CashBuilder
     * @param moneyChange value to use for building new CashUpdate or CashChanged objects
     * @return CashBuilder instance with updated moneyChange property
     */
    public CashBuilder setMoneyChange(BigDecimal moneyChange) {
        this.moneyChange = moneyChange == null ? null : moneyChange.setScale(Constants.DECIMALS, Constants.ROUNDING_MODE);
        return this;
    }

    /**
     * Sets the money change property in the CashBuilder
     *
     * @param moneyChange value to use for building new CashUpdate or CashChanged objects
     * @return CashBuilder instance with updated moneyChange property
     */
    public CashBuilder setMoneyChange(Double moneyChange) {
        this.moneyChange = moneyChange == null ? null : new BigDecimal(moneyChange).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE);
        return this;
    }

    /**
     * Sets the reason property in the CashBuilder
     * @param reason value to use for building new CashUpdate or CashChanged objects
     * @return CashBuilder instance with updated reason property
     */
    public CashBuilder setReason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Sets the origin property in the CashBuilder
     * @param origin value to use for building new CashUpdate or CashChanged objects
     * @return CashBuilder instance with updated origin property
     */
    public CashBuilder setOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    /**
     * Sets the transactionId property in the CashBuilder
     * @param transactionId value to use for building new CashUpdate or CashChanged objects
     * @return CashBuilder instance with updated transactionId property
     */
    public CashBuilder setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    /**
     * Sets the Balance property in the Cash Builder
     * @param balance value to use for building new CashUpdate or CashChanged objects
     * @return CashBuilder instance with updated balance property
     */
    public CashBuilder setBalance(BigDecimal balance) {
        this.balance = balance == null ? null : balance.setScale(Constants.DECIMALS, Constants.ROUNDING_MODE);
        return this;
    }

    /**
     * Sets the Balance property in the Cash Builder converting the double value into a corresponding BigDecimal value internally
     *
     * @param balance value to use for building new CashUpdate or CashChanged objects
     * @return CashBuilder instance with updated balance property
     */
    public CashBuilder setBalance(Double balance) {
        this.balance = balance == null ? null : new BigDecimal(balance).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE);
        return this;
    }

    /**
     * Sets the dateCreated property in the CashBuilder
     * @param dateCreated value value to use for building new CashUpdate or CashChanged objects
     * @return CashBuilder instance with updated dateCreated property
     */
    public CashBuilder setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    /**
     * Sets the dateCreated property in the CashBuilder to the instant in time the method was called
     * @return CashBuilder instance with updated dateCreated property
     */
    public CashBuilder setDateCreatedToNow() {
        this.dateCreated = new LocalDateTime();
        return this;
    }

    /**
     * Creates a CashUpdate object based on the builder's own cash properties that were set previously (possibly using method chaning)
     * @return CashUpdate object
     */
    public CashUpdate buildCashUpdate() {
        CashUpdate cashUpdate = new CashUpdate(this.brokerId, this.moneyChange, this.reason, this.origin);
        return cashUpdate;
    }


    /**
     * Creates a CashChanged object based on the builder's own cash properties that were set previously (possibly using method chaning)
     * @return CashChanged object
     */
    public CashChanged buildCashChanged() {
        CashChanged cashChanged = new CashChanged(this.brokerId, this.moneyChange, this.reason, this.origin, this.transactionId, this.balance, this.dateCreated);
        return cashChanged;
    }

}
