package org.powertac.common.builders;

import org.joda.time.LocalDateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powertac.common.commands.TariffPublish;
import org.powertac.common.commands.TariffReply;
import org.powertac.common.enumerations.TariffState;

import static org.junit.Assert.assertEquals;

/**
 * Tests for TariffBuilder class
 *
 * @author Carsten Block
 * @version 1.0, Date: 07.12.10
 * @see TariffBuilder
 */
public class TariffBuilderTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFromTariff() throws Exception {
       TariffReply TariffReply = new TariffReply(TariffState.Finished, 1l, 1.0, 1.0, new Double[]{1.0, 1.0}, new Double[]{0.1, 0.1}, new LocalDateTime(), new LocalDateTime(), 1, 1, 1.0, 1.0, 1.0, 1.0);
       TariffPublish tpc = TariffBuilder.fromTariff(TariffReply).setAuthToken("test").buildTariffPublish();
       assertEquals("test", tpc.getAuthToken());
       assertEquals((Long) 1l, tpc.getTariffId());
    }

    @Test
    public void testSetTariffState() throws Exception {

    }

    @Test
    public void testSetPermittedCustomerTypes() throws Exception {

    }

    @Test
    public void testSetAuthToken() throws Exception {

    }

    @Test
    public void testBuildTariffReply() throws Exception {

    }

    @Test
    public void testBuildTariffPublish() throws Exception {

    }
}
