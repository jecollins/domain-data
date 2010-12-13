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

import org.powertac.common.commands.TimeslotChanged;
import org.powertac.common.commands.WeatherForecastData;
import org.powertac.common.commands.WeatherRealData;

import java.util.List;

/**
 * @author David Dauer
 * @version 0.0.1
 */
public interface PhysicalEnvironment {
    /**
     * Generates and returns the real weather data for a given timeslot
     * for customers, brokers, distribution utility
     *
     * Make sure that the timeslotChanged parameter is referenced within the WeatherReadData command
     * so that customers/brokers know which timeslot the data is for
     *
     * @param timeslotChanged the changed (deactivated) timeslot
     * @return The actual weather data for the given timeslotChanged parameter
     */
    WeatherRealData generateRealWeatherData(TimeslotChanged timeslotChanged);

    /**
     * Generates and returns weather forecasts for every enabled timeslot
     *
     * @param currentTimeslot the changed timeslot
     * @return a list of weather forecast objects
     */
    List<WeatherForecastData> generateForecastWeatherData(TimeslotChanged currentTimeslot);
}
