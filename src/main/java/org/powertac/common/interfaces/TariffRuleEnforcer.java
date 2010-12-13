package org.powertac.common.interfaces;

import org.powertac.common.commands.TariffReply;

public interface TariffRuleEnforcer  {

    /**
     * Evaluates a given tariff
     * @param tariffReply
     * @return whether tariffReply is accepted or not
     */
  public boolean accept(TariffReply tariffReply);

}
