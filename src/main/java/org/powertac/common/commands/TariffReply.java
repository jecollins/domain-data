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
import org.powertac.common.enumerations.TariffState;

import java.math.BigDecimal;

/**
 * Command object that represents a tariff reply, i.e.
 * a subscription to a <code>PublishTariffCommand</code>
 * or a counter offer in a negotiation process.
 *
 * Once created this command object is immutable.
 *
 * @author Carsten Block
 * @version 1.0, Date: 01.12.10
 * @see TariffPublish , GenericTariff
 */
public class TariffReply extends GenericTariff {

    private static final long serialVersionUID = -2880976902173580921L;

    private TariffState tariffState;

    public TariffReply(GenericTariff genericTariff, TariffState tariffState) {
        super(genericTariff.getTariffId(), genericTariff.getSignupFee(), genericTariff.getBaseFee(), genericTariff.getPowerConsumptionPriceArray(), genericTariff.getPowerProductionPriceArray(), genericTariff.getContractStartDate(), genericTariff.getContractEndDate(), genericTariff.getMinimumContractRuntime(), genericTariff.getMaximumContractRuntime(), genericTariff.getPowerConsumptionThreshold(), genericTariff.getPowerConsumptionSurcharge(), genericTariff.getPowerProductionThreshold(), genericTariff.getPowerProductionSurcharge());
        this.tariffState = tariffState;
    }

    public TariffReply(TariffState tariffState, Long tariffId, BigDecimal signupFee, BigDecimal baseFee, BigDecimal[] powerConsumptionPriceArray, BigDecimal[] powerProductionPriceArray, LocalDateTime contractStartDate, LocalDateTime contractEndDate, Integer minimumContractRuntime, Integer maximumContractRuntime, BigDecimal powerConsumptionThreshold, BigDecimal powerConsumptionSurcharge, BigDecimal powerProductionThreshold, BigDecimal powerProductionSurcharge) {
        super(tariffId, signupFee, baseFee, powerConsumptionPriceArray, powerProductionPriceArray, contractStartDate, contractEndDate, minimumContractRuntime, maximumContractRuntime, powerConsumptionThreshold, powerConsumptionSurcharge, powerProductionThreshold, powerProductionSurcharge);
        this.tariffState = tariffState;
    }

    public TariffReply(TariffState tariffState, Long tariffId, Double signupFee, Double baseFee, Double[] powerConsumptionPriceArray, Double[] powerProductionPriceArray, LocalDateTime contractStartDate, LocalDateTime contractEndDate, Integer minimumContractRuntime, Integer maximumContractRuntime, Double powerConsumptionThreshold, Double powerConsumptionSurcharge, Double powerProductionThreshold, Double powerProductionSurcharge) {
        super(tariffId, signupFee, baseFee, powerConsumptionPriceArray, powerProductionPriceArray, contractStartDate, contractEndDate, minimumContractRuntime, maximumContractRuntime, powerConsumptionThreshold, powerConsumptionSurcharge, powerProductionThreshold, powerProductionSurcharge);
        this.tariffState = tariffState;
    }

    public TariffState getTariffState() {
        return tariffState;
    }
}
