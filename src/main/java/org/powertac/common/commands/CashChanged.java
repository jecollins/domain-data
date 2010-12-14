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

package org.powertac.common.commands;

import org.joda.time.LocalDateTime;
import org.powertac.common.Constants;
import org.powertac.common.interfaces.Broker;

import java.math.BigDecimal;

/**
 * Command object that represents the result of a successful
 * cash transaction (add / deduce money) that was executed on a specific
 * broker cash account for a given reason.
 *
 * @author Carsten Block
 * @version 1.0, Date: 02.12.10
 */
public class CashChanged extends AbstractCash {

    private static final long serialVersionUID = -2283491588688754258L;

    private Long transactionId;
    private BigDecimal balance;
    private LocalDateTime dateCreated;

    public CashChanged(Long brokerId, Double moneyChange, String reason, String origin, Long transactionId, Double balance, LocalDateTime dateCreated) {
        super(brokerId, moneyChange, reason, origin);
        this.transactionId = transactionId;
        BigDecimal value = new BigDecimal(balance);
        value = value.setScale(Constants.DECIMALS, Constants.ROUNDING_MODE);
        this.balance = value;
        this.dateCreated = dateCreated;
    }

    public CashChanged(Long brokerId, BigDecimal moneyChange, String reason, String origin, Long transactionId, BigDecimal balance, LocalDateTime dateCreated) {
        super(brokerId, moneyChange, reason, origin);
        this.transactionId = transactionId;
        this.balance = balance;
        this.dateCreated = dateCreated;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
}
