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

import java.math.BigDecimal;

/**
 * Command object that represents an cash transaction
 * (add / deduce money) that should be executed on a
 * specific broker cash account for a given reason.
 *
 * @author Carsten Block
 * @version 1.0, Date: 02.12.10
 */
public class CashUpdate extends AbstractCash {

    private static final long serialVersionUID = 1865147840672112686L;

    public CashUpdate(Long brokerId, BigDecimal moneyChange, String reason, String origin) {
        super(brokerId, moneyChange, reason, origin);
    }

    public CashUpdate(Long brokerId, Double moneyChange, String reason, String origin) {
        super(brokerId, moneyChange, reason, origin);
    }

}
