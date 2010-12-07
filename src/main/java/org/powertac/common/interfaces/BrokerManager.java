/*
 * Copyright 2002-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.powertac.common.interfaces;

import java.util.List;

/**
 * Broker Manager Interface
 * This interface should be implemented by a module that is responsible for the communication
 * between brokers and the server. The module basically handles (un)marshalling of incoming/outgoing
 * messages
 *
 * @author David Dauer
 * @version 0.0.1
 */
public interface BrokerManager {

    /**
     * Broadcast a single command object's xml representation to all brokers
     * @param commandObject a command
     */
    void broadcastCommand(Object commandObject);

    /**
     * Broadcast a list of command objects to all brokers
     * This is just a convenience method which should call broadcastCommand() for every list entry
     * @param commandList a list of command objects
     */
    void broadcastCommands(List commandList);

    /**
     * Send a single command object to a broker which must exist and be accessible though the object's getBroker()
     * accessor.
     * @param command a command
     */
    /* TODO: Ideally, every command should implement a "BrokerRelation" or "BrokerContainer" interface */
    void sendCommand(Object command);

}
