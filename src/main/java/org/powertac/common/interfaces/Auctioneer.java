package org.powertac.common.interfaces;

import org.powertac.common.commands.ShoutChanged;
import org.powertac.common.commands.ShoutCreate;
import org.powertac.common.commands.ShoutDelete;
import org.powertac.common.commands.ShoutUpdate;

import java.util.List;

/**
 * Interface that defines the publicly accessible methods
 * a Power TAC auctioneer has to implement.
 *
 * @author Carsten Block
 * @version 1.0, Date: 01.12.10
 */
public interface Auctioneer {

  /**
   * Process an incoming shout, e.g. by matching it against existing shouts
   * As a CDA market auctioneer this is the method to match the <code>shoutCreate</shout>
   * against existing shouts in order to execute it immediately. As a call (PDA) market auctioner
   * this method could be used to store the new shout and to wait for a <code>ClearMarketCommand</code>
   * in order to start the matching and execution process.
   * <p/>
   * In both cases orderbook updates, quote updates, shout status updates etc may be created and
   * returned in a list so that other components (e.g. <code>AccountingService</code>) can further
   * process these objects futher downstream in the channel.
   *
   * @param shoutCreate new incoming shout from a broker
   * @return List of objects, which might include <code>DepotUpdate</code>, <code>CashUpdate</code>, <code>OrderbookChanged</code>,<code>QuoteChanged</code>,<code>TradeOccurred</code>,<code>ShoutChanged</code>
   * @see org.powertac.common.commands.DepotUpdate , CashUpdate, OrderbookChanged, QuoteChanged, TradeOccurred, ShoutChanged
   */
  List processShoutCreate(ShoutCreate shoutCreate);

  /**
   *
   * @param shoutDelete command object that contains the shoutId that should be deleted
   * @return ShoutChangedCommand object that contains the new status of the deleted shout
   */
  ShoutChanged processShoutDelete(ShoutDelete shoutDelete);

  ShoutChanged processShoutUpdate(ShoutUpdate shoutUpdate);

}
