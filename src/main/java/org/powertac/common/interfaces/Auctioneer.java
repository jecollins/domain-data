package org.powertac.common.interfaces;

import org.powertac.common.commands.ShoutChangedCommand;
import org.powertac.common.commands.ShoutCreateCommand;
import org.powertac.common.commands.ShoutDeleteCommand;
import org.powertac.common.commands.ShoutUpdateCommand;

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
   * As a CDA market auctioneer this is the method to match the <code>shoutCreateCommand</shout>
   * against existing shouts in order to execute it immediately. As a call (PDA) market auctioner
   * this method could be used to store the new shout and to wait for a <code>ClearMarketCommand</code>
   * in order to start the matching and execution process.
   * <p/>
   * In both cases orderbook updates, quote updates, shout status updates etc may be created and
   * returned in a list so that other components (e.g. <code>AccountingService</code>) can further
   * process these objects futher downstream in the channel.
   *
   * @param shoutCreateCommand new incoming shout from a broker
   * @return List of objects, which might include <code>DepotUpdateCommand</code>, <code>CashUpdate</code>, <code>OrderbookChangedCommand</code>,<code>QuoteChangedCommand</code>,<code>TradeOccurredCommand</code>,<code>ShoutChangedCommand</code>
   * @see org.powertac.common.commands.DepotUpdateCommand, CashUpdate, OrderbookChangedCommand, QuoteChangedCommand, TradeOccurredCommand, ShoutChangedCommand
   */
  List processShoutCreate(ShoutCreateCommand shoutCreateCommand);

  /**
   *
   * @param shoutDeleteCommand command object that contains the shoutId that should be deleted
   * @return ShoutChangedCommand object that contains the new status of the deleted shout
   */
  ShoutChangedCommand processShoutDelete(ShoutDeleteCommand shoutDeleteCommand);

  ShoutChangedCommand processShoutUpdate(ShoutUpdateCommand shoutUpdateCommand);

}
