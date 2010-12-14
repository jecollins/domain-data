package org.powertac.common.commands;

/**
 * Command object that can be used by
 * a broker to require the server to delete
 * as specific shout;
 *
 * Once created this object is immutable.
 *
 * Note: Use ShoutBuilder to create new or convert between Shout objects
 *
 * @author Carsten Block
 * @version 1.0, Date: 01.12.10
 * @see org.powertac.common.builders.ShoutBuilder
 */
public class ShoutDelete {
    private String authToken;
    private Long shoutId;

    public ShoutDelete(String authToken, Long shoutId) {
        this.authToken = authToken;
        this.shoutId = shoutId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public Long getShoutId() {
        return shoutId;
    }
}
