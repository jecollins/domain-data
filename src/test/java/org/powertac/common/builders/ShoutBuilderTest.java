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
import org.junit.Before;
import org.junit.Test;
import org.powertac.common.Constants;
import org.powertac.common.commands.ShoutChanged;
import org.powertac.common.commands.ShoutCreate;
import org.powertac.common.commands.ShoutDelete;
import org.powertac.common.commands.ShoutUpdate;
import org.powertac.common.enumerations.BuySellIndicator;
import org.powertac.common.enumerations.ModReasonCode;
import org.powertac.common.enumerations.OrderType;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Unit tests for ShoutBuilder
 *
 * @author Carsten Block
 * @version 1.0, Date: 14.12.10
 */
public class ShoutBuilderTest {

  Long shoutChangedShoutId;
  Long shoutChangedTransactionId;
  Long shoutChangedProductId;
  Long shoutChangedTimeslotId;
  BuySellIndicator shoutChangedBuySellIndicator;
  Double shoutChangedQuantity;
  Double shoutChangedLimitPrice;
  OrderType shoutChangedOrderType;
  Double shoutChangedRemainingQuantity;
  Double shoutChangedExecutionQuantity;
  Double shoutChangedExecutionPrice;
  LocalDateTime shoutChangedDateCreated;
  LocalDateTime shoutChangedLastUpdated;
  ModReasonCode shoutChangedModReasonCode;
  ShoutChanged originalShoutChanged;

  String shoutCreateAuthToken;
  Long shoutCreateProductId;
  Long shoutCreateTimeslotId;
  BuySellIndicator shoutCreateBuySellIndicator;
  Double shoutCreateQuantity;
  Double shoutCreateLimitPrice;
  OrderType shoutCreateOrderType;
  ShoutCreate originalShoutCreate;

  String shoutDeleteAuthToken;
  Long shoutDeleteShoutId;
  ShoutDelete originalShoutDelete;

  @Before
  public void setUp() throws Exception {
    shoutChangedShoutId = 1l;
    shoutChangedTransactionId = 2l;
    shoutChangedProductId = 3l;
    shoutChangedTimeslotId = 4l;
    shoutChangedBuySellIndicator = BuySellIndicator.BUY;
    shoutChangedQuantity = 0.1;
    shoutChangedLimitPrice = 0.2;
    shoutChangedOrderType = OrderType.LIMIT;
    shoutChangedRemainingQuantity = 0.3;
    shoutChangedExecutionQuantity = 0.4;
    shoutChangedExecutionPrice = 0.5;
    shoutChangedDateCreated = new LocalDateTime();
    shoutChangedLastUpdated = new LocalDateTime();
    shoutChangedModReasonCode = ModReasonCode.INSERT;
    originalShoutChanged = new ShoutChanged(shoutChangedShoutId, shoutChangedTransactionId, shoutChangedProductId, shoutChangedTimeslotId, shoutChangedBuySellIndicator, shoutChangedQuantity, shoutChangedLimitPrice, shoutChangedOrderType, shoutChangedRemainingQuantity, shoutChangedExecutionQuantity, shoutChangedExecutionPrice, shoutChangedDateCreated, shoutChangedLastUpdated, shoutChangedModReasonCode);


    shoutCreateAuthToken = "test";
    shoutCreateProductId = 3l;
    shoutCreateTimeslotId = 4l;
    shoutCreateBuySellIndicator = BuySellIndicator.BUY;
    shoutCreateQuantity = 0.1;
    shoutCreateLimitPrice = 0.2;
    shoutCreateOrderType = OrderType.LIMIT;
    originalShoutCreate = new ShoutCreate(shoutCreateAuthToken, shoutCreateTimeslotId, shoutCreateProductId, shoutCreateBuySellIndicator, shoutCreateQuantity, shoutCreateLimitPrice, shoutCreateOrderType);

    shoutDeleteAuthToken = "testDelete";
    shoutDeleteShoutId = 111l;
    originalShoutDelete = new ShoutDelete(shoutDeleteAuthToken, shoutDeleteShoutId);
  }

  @Test
  public void testWithEmpty() throws Exception {
    ShoutChanged shoutChanged = ShoutBuilder.withEmpty().buildShoutChanged();
    assertNotNull(shoutChanged);
    assertNull(shoutChanged.getShoutId());
    assertNull(shoutChanged.getTransactionId());
    assertNull(shoutChanged.getProductId());
    assertNull(shoutChanged.getTimeslotId());
    assertNull(shoutChanged.getBuySellIndicator());
    assertNull(shoutChanged.getQuantity());
    assertNull(shoutChanged.getLimitPrice());
    assertNull(shoutChanged.getOrderType());
    assertNull(shoutChanged.getRemainingQuantity());
    assertNull(shoutChanged.getExecutionQuantity());
    assertNull(shoutChanged.getExecutionPrice());
    assertNull(shoutChanged.getDateCreated());
    assertNull(shoutChanged.getLastUpdated());
    assertNull(shoutChanged.getModReasonCode());

    ShoutCreate shoutCreate = ShoutBuilder.withEmpty().buildShoutCreate();
    assertNotNull(shoutCreate);
    assertNull(shoutCreate.getAuthToken());
    assertNull(shoutCreate.getTimeslotId());
    assertNull(shoutCreate.getProductId());
    assertNull(shoutCreate.getBuySellIndicator());
    assertNull(shoutCreate.getQuantity());
    assertNull(shoutCreate.getLimitPrice());
    assertNull(shoutCreate.getOrderType());

    ShoutDelete shoutDelete = ShoutBuilder.withEmpty().buildShoutDelete();
    assertNotNull(shoutDelete);
    assertNull(shoutDelete.getAuthToken());
    assertNull(shoutDelete.getShoutId());

    ShoutUpdate shoutUpdate = ShoutBuilder.withEmpty().buildShoutUpdate();
    assertNotNull(shoutUpdate);
    assertNull(shoutUpdate.getAuthToken());
    assertNull(shoutUpdate.getShoutId());
    assertNull(shoutUpdate.getQuantity());
    assertNull(shoutUpdate.getLimitPrice());
  }

  @Test
  public void testWithShoutChanged() throws Exception {

    //Generate new ShoutChanged Command from existing ShoutChanged Command
    ShoutChanged newShoutChanged = ShoutBuilder.withShoutChanged(originalShoutChanged).buildShoutChanged();
    assertNotSame(originalShoutChanged, newShoutChanged);
    assertEquals(shoutChangedShoutId, newShoutChanged.getShoutId());
    assertEquals(shoutChangedTransactionId, newShoutChanged.getTransactionId());
    assertEquals(shoutChangedProductId, newShoutChanged.getProductId());
    assertEquals(shoutChangedTimeslotId, newShoutChanged.getTimeslotId());
    assertEquals(shoutChangedBuySellIndicator, newShoutChanged.getBuySellIndicator());
    assertEquals(new BigDecimal(shoutChangedQuantity).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), newShoutChanged.getQuantity());
    assertEquals(new BigDecimal(shoutChangedLimitPrice).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), newShoutChanged.getLimitPrice());
    assertEquals(shoutChangedOrderType, newShoutChanged.getOrderType());
    assertEquals(new BigDecimal(shoutChangedRemainingQuantity).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), newShoutChanged.getRemainingQuantity());
    assertEquals(new BigDecimal(shoutChangedExecutionQuantity).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), newShoutChanged.getExecutionQuantity());
    assertEquals(new BigDecimal(shoutChangedExecutionPrice).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), newShoutChanged.getExecutionPrice());
    assertEquals(shoutChangedDateCreated, newShoutChanged.getDateCreated());
    assertEquals(shoutChangedLastUpdated, newShoutChanged.getLastUpdated());
    assertEquals(shoutChangedModReasonCode, newShoutChanged.getModReasonCode());

    //Generate ShoutCreate command from existing ShoutChanged command
    ShoutCreate newShoutCreate = ShoutBuilder.withShoutChanged(originalShoutChanged).buildShoutCreate();
    assertNull(newShoutCreate.getAuthToken());
    assertEquals(shoutChangedProductId, newShoutCreate.getProductId());
    assertEquals(shoutChangedTimeslotId, newShoutCreate.getTimeslotId());
    assertEquals(shoutChangedBuySellIndicator, newShoutCreate.getBuySellIndicator());
    assertEquals(new BigDecimal(shoutChangedQuantity).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), newShoutCreate.getQuantity());
    assertEquals(new BigDecimal(shoutChangedLimitPrice).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), newShoutCreate.getLimitPrice());
    assertEquals(shoutChangedOrderType, newShoutCreate.getOrderType());
  }

  @Test
  public void testWithShoutCreate() throws Exception {
    ShoutCreate newShoutCreate = ShoutBuilder.withShoutCreate(originalShoutCreate).buildShoutCreate();
    assertNotSame(originalShoutCreate, newShoutCreate);
    assertEquals(shoutCreateAuthToken, newShoutCreate.getAuthToken());
    assertEquals(shoutCreateProductId, newShoutCreate.getProductId());
    assertEquals(shoutCreateTimeslotId, newShoutCreate.getTimeslotId());
    assertEquals(shoutCreateBuySellIndicator, newShoutCreate.getBuySellIndicator());
    assertEquals(new BigDecimal(shoutCreateQuantity).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), newShoutCreate.getQuantity());
    assertEquals(new BigDecimal(shoutCreateLimitPrice).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), newShoutCreate.getLimitPrice());
    assertEquals(shoutCreateOrderType, newShoutCreate.getOrderType());
  }

  @Test
  public void testWithShoutDelete() throws Exception {
    ShoutDelete newShoutDelete = ShoutBuilder.withShoutDelete(originalShoutDelete).buildShoutDelete();
    assertNotSame(originalShoutDelete, newShoutDelete);
    assertEquals(shoutDeleteAuthToken, newShoutDelete.getAuthToken());
    assertEquals(shoutDeleteShoutId, newShoutDelete.getShoutId());
  }

  @Test
  public void testWithShoutUpdate() throws Exception {
    String authToken = "test";
    Long shoutId = 3l;
    Double quantity = 0.1;
    Double limitPrice = 0.2;

    ShoutUpdate originalShoutUpdate = new ShoutUpdate(authToken, shoutId, quantity, limitPrice);

    ShoutUpdate newShoutUpdate = ShoutBuilder.withShoutUpdate(originalShoutUpdate).buildShoutUpdate();
    assertNotSame(originalShoutUpdate, newShoutUpdate);
    assertEquals(authToken, newShoutUpdate.getAuthToken());
    assertEquals(shoutId, newShoutUpdate.getShoutId());
    assertEquals(new BigDecimal(quantity).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), newShoutUpdate.getQuantity());
    assertEquals(new BigDecimal(limitPrice).setScale(Constants.DECIMALS, Constants.ROUNDING_MODE), newShoutUpdate.getLimitPrice());
  }

  @Test
  public void testSetAuthToken() throws Exception {
    assertNull(ShoutBuilder.withEmpty().setAuthToken(null).buildShoutCreate().getAuthToken());
    assertNull(ShoutBuilder.withEmpty().setAuthToken(null).buildShoutDelete().getAuthToken());
    assertNull(ShoutBuilder.withEmpty().setAuthToken(null).buildShoutUpdate().getAuthToken());
  }

  @Test
  public void testSetTimeslotId() throws Exception {

  }

  @Test
  public void testSetProductId() throws Exception {

  }

  @Test
  public void testSetShoutId() throws Exception {

  }

  @Test
  public void testSetTransactionId() throws Exception {

  }

  @Test
  public void testSetBuySellIndicator() throws Exception {

  }

  @Test
  public void testSetQuantity() throws Exception {

  }

  @Test
  public void testSetLimitPrice() throws Exception {

  }

  @Test
  public void testSetOrderType() throws Exception {

  }

  @Test
  public void testSetRemainingQuantity() throws Exception {

  }

  @Test
  public void testSetExecutionQuantity() throws Exception {

  }

  @Test
  public void testSetExecutionPrice() throws Exception {

  }

  @Test
  public void testSetDateCreated() throws Exception {

  }

  @Test
  public void testSetLastUpdated() throws Exception {

  }

  @Test
  public void testSetModReasonCode() throws Exception {

  }

  @Test
  public void testBuildShoutChanged() throws Exception {

  }

  @Test
  public void testBuildShoutCreate() throws Exception {

  }

  @Test
  public void testBuildShoutDelete() throws Exception {

  }
}
