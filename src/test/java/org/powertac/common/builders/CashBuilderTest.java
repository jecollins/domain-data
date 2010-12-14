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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powertac.common.Constants;
import org.powertac.common.commands.CashChanged;
import org.powertac.common.commands.CashUpdate;
import org.powertac.common.interfaces.Broker;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * JUnit tests for CashBuilder
 *
 * @author Carsten Block
 * @version 1.0, Date: 13.12.10
 */
public class CashBuilderTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void testWithEmpty() throws Exception {
        CashChanged cashChanged = CashBuilder.withEmpty().buildCashChanged();
        assertNull(cashChanged.getBalance());
        assertNull(cashChanged.getBrokerId());
        assertNull(cashChanged.getMoneyChange());
        assertNull(cashChanged.getOrigin());
        assertNull(cashChanged.getReason());
        assertNull(cashChanged.getDateCreated());
        assertNull(cashChanged.getTransactionId());

        CashUpdate cashUpdate = CashBuilder.withEmpty().buildCashUpdate();
        assertNull(cashUpdate.getBrokerId());
        assertNull(cashUpdate.getMoneyChange());
        assertNull(cashUpdate.getOrigin());
        assertNull(cashUpdate.getReason());
    }

    @Test
    public void testWithCashChanged() throws Exception {
        Broker bob = null;
        Double moneyChange = .1; //specifically use .1 as this cannot represented as a finite double number during conversion into BigDecimal
        String reason = "No reason";
        String origin = "No origin";
        Long transactionId = 1l;
        Double balance = 10.1;
        LocalDateTime dateTime = new LocalDateTime();

        CashChanged originalCashChanged = new CashChanged(null, moneyChange, reason, origin, transactionId, balance, dateTime);

        //generate new originalCashChanged object based on existing originalCashChanged object
        CashChanged newCashChanged = CashBuilder.withCashChanged(originalCashChanged).buildCashChanged();
        assertNotSame(originalCashChanged, newCashChanged);
        assertEquals(null, newCashChanged.getBrokerId());
        assertEquals(new BigDecimal(".1").setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), newCashChanged.getMoneyChange()); //use String constructor for BigDecimal as adviced in JDK docs
        assertEquals(reason, newCashChanged.getReason());
        assertEquals(origin, newCashChanged.getOrigin());
        assertEquals(transactionId, newCashChanged.getTransactionId());
        assertEquals(new BigDecimal("10.1").setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), newCashChanged.getBalance()); //use String constructor for BigDecimal as adviced in JDK docs
        assertEquals(dateTime, newCashChanged.getDateCreated());

        //generate new cashUpdate object based on existing cashUpdate object
        CashUpdate newCashUpdate = CashBuilder.withCashChanged(originalCashChanged).buildCashUpdate();
        assertEquals(null, newCashUpdate.getBrokerId());
        assertEquals(new BigDecimal(".1").setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), newCashUpdate.getMoneyChange()); //use String constructor for BigDecimal as adviced in JDK docs
        assertEquals(reason, newCashUpdate.getReason());
        assertEquals(origin, newCashUpdate.getOrigin());
    }

    @Test
    public void testWithCashUpdate() throws Exception {
        Broker bob = null;
        Double moneyChange = .1; //specifically use .1 as this cannot represented as a finite double number during conversion into BigDecimal
        String reason = "No reason";
        String origin = "No origin";
        Long transactionId = 1l;
        Double balance = 10.1;
        LocalDateTime dateTime = new LocalDateTime();

        CashUpdate originalCashUpdate = new CashUpdate(null, moneyChange, reason, origin);

        //generate new CashUpdate object based on existing originalCashUpdate object
        CashUpdate newCashUpdate = CashBuilder.withCashUpdate(originalCashUpdate).buildCashUpdate();
        assertNotSame(originalCashUpdate, newCashUpdate);
        assertEquals(null, newCashUpdate.getBrokerId());
        assertEquals(new BigDecimal(".1").setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), newCashUpdate.getMoneyChange()); //use String constructor for BigDecimal as adviced in JDK docs
        assertEquals(reason, newCashUpdate.getReason());
        assertEquals(origin, newCashUpdate.getOrigin());

        //generate new CashChanged object based on existing originalCashUpdate object
        CashChanged newCashChanged = CashBuilder.withCashUpdate(originalCashUpdate).buildCashChanged();
        assertEquals(null, newCashChanged.getBrokerId());
        assertEquals(new BigDecimal(".1").setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), newCashChanged.getMoneyChange()); //use String constructor for BigDecimal as adviced in JDK docs
        assertEquals(reason, newCashChanged.getReason());
        assertEquals(origin, newCashChanged.getOrigin());
        assertNull(newCashChanged.getTransactionId());
        assertNull(newCashChanged.getBalance());
        assertNull(newCashChanged.getDateCreated());
    }

    @Test
    public void testSetBroker() throws Exception {
        assertNull(CashBuilder.withEmpty().setBrokerId(null).buildCashChanged().getBrokerId());
        assertNull(CashBuilder.withEmpty().setBrokerId(null).buildCashUpdate().getBrokerId());
        assertEquals((Long) 1l, CashBuilder.withEmpty().setBrokerId(1l).buildCashChanged().getBrokerId());
        assertEquals((Long) 1l, CashBuilder.withEmpty().setBrokerId(1l).buildCashUpdate().getBrokerId());
    }

    @Test
    public void testSetMoneyChange() throws Exception {

        assertNull(CashBuilder.withEmpty().setMoneyChange((Double) null).buildCashChanged().getMoneyChange());
        assertNull(CashBuilder.withEmpty().setMoneyChange((Double) null).buildCashUpdate().getMoneyChange());
        assertNull(CashBuilder.withEmpty().setMoneyChange((BigDecimal) null).buildCashChanged().getMoneyChange());
        assertNull(CashBuilder.withEmpty().setMoneyChange((BigDecimal) null).buildCashUpdate().getMoneyChange());

        assertEquals(new BigDecimal(".1").setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), CashBuilder.withEmpty().setMoneyChange(0.1).buildCashChanged().getMoneyChange());

        assertEquals(new BigDecimal(".1").setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), CashBuilder.withEmpty().setMoneyChange(0.1).buildCashUpdate().getMoneyChange());

        assertEquals(new BigDecimal(".1").setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), CashBuilder.withEmpty().setMoneyChange(new BigDecimal(".1")).buildCashChanged().getMoneyChange());

        assertEquals(new BigDecimal(".1").setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), CashBuilder.withEmpty().setMoneyChange(new BigDecimal(".1")).buildCashUpdate().getMoneyChange());
    }

    @Test
    public void testSetReason() throws Exception {
        assertNull(CashBuilder.withEmpty().setReason(null).buildCashChanged().getReason());
        assertNull(CashBuilder.withEmpty().setReason(null).buildCashUpdate().getReason());

        assertEquals("test", CashBuilder.withEmpty().setReason("test").buildCashChanged().getReason());
        assertEquals("test", CashBuilder.withEmpty().setReason("test").buildCashUpdate().getReason());
    }

    @Test
    public void testSetOrigin() throws Exception {
        assertNull(CashBuilder.withEmpty().setOrigin(null).buildCashChanged().getOrigin());
        assertNull(CashBuilder.withEmpty().setOrigin(null).buildCashUpdate().getOrigin());

        assertEquals("test", CashBuilder.withEmpty().setOrigin("test").buildCashUpdate().getOrigin());
        assertEquals("test", CashBuilder.withEmpty().setOrigin("test").buildCashChanged().getOrigin());
    }

    @Test
    public void testSetTransactionId() throws Exception {
        assertNull(CashBuilder.withEmpty().setTransactionId(null).buildCashChanged().getTransactionId());
        assertEquals((Long) 1l, CashBuilder.withEmpty().setTransactionId(1l).buildCashChanged().getTransactionId());
    }

    @Test
    public void testSetBalance() throws Exception {
        assertNull(CashBuilder.withEmpty().setBalance((Double)null).buildCashChanged().getBalance());
        assertNull(CashBuilder.withEmpty().setBalance((BigDecimal)null).buildCashChanged().getBalance());
        assertEquals(new BigDecimal(".1").setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), CashBuilder.withEmpty().setBalance(0.1).buildCashChanged().getBalance());

        assertEquals(new BigDecimal(".1").setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), CashBuilder.withEmpty().setBalance(new BigDecimal("0.1")).buildCashChanged().getBalance());
    }

    @Test
    public void testSetDateCreated() throws Exception {
        LocalDateTime dateTime = new LocalDateTime();
        assertEquals(dateTime, CashBuilder.withEmpty().setDateCreated(dateTime).buildCashChanged().getDateCreated());
        assertNull(CashBuilder.withEmpty().setDateCreated(null).buildCashChanged().getDateCreated());
    }

    @Test
    public void testBuildCashUpdate() throws Exception {
        assertNotNull(CashBuilder.withEmpty().buildCashUpdate());
    }

    @Test
    public void testBuildCashChanged() throws Exception {
        assertNotNull(CashBuilder.withEmpty().buildCashChanged());
    }
}
