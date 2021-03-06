package org.powertac.common;

import java.math.RoundingMode;

/**
 * This class contains constant definitions used throughout
 * the project.
 *
 * @author Carsten Block
 * @version 1.0, Date: 13.12.10
 */
public class Constants {
    /**
     * DECIMALS constant is used to set the common decimal scaling in
     * BigDecimal numbers; for powertac this is set to 2 decimal digits
     */
    public static final int DECIMALS = 4;
    public static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
}
