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

import org.powertac.common.commands.GenericTariff;
import org.powertac.common.commands.TariffPublish;
import org.powertac.common.commands.TariffReply;
import org.powertac.common.enumerations.CustomerType;
import org.powertac.common.enumerations.TariffState;

import java.util.Set;

/**
 * TariffBuilder allows the easy creation of Tariff objects using
 * method chaining.
 *
 * Example:
 * TariffReply tr = TariffBuilder.withTariff(tariff1).setSignupFee(0.2).build()
 *
 * @author Carsten Block
 * @version 1.0, Date: 03.12.10
 */
public class TariffBuilder {

    private final GenericTariff genericTariff;
    private TariffState tariffState;
    private Set<CustomerType> permittedCustomerTypes;
    private String authToken;

    /*
     * Private constructor to be invoked from the static factory methods only
     */
    private TariffBuilder(GenericTariff originalTariff) {
        this.genericTariff = originalTariff;
    }

    public static TariffBuilder fromTariff(GenericTariff originalTariff) {
        return new TariffBuilder(originalTariff);
    }

    public TariffBuilder setTariffState (TariffState tariffState) {
        this.tariffState = tariffState;
        return this;
    }

    public TariffBuilder setPermittedCustomerTypes(Set<CustomerType> permittedCustomerTypes) {
        this.permittedCustomerTypes = permittedCustomerTypes;
        return this;
    }

    public TariffBuilder setAuthToken (String authToken) {
        this.authToken = authToken;
        return this;
    }

    public TariffReply buildTariffReplyCommand() {
        return new TariffReply(this.genericTariff, this.tariffState);
    }

    public TariffPublish buildTariffPublish() {
        return new TariffPublish(this.permittedCustomerTypes, this.authToken, this.genericTariff);
    }
}
