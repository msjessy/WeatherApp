package de.fh.albsig.matrikel_84788;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import de.fh.albsig.matrikel_84788.service.WeatherService;

/**
 * The Class WeatherServiceTest.
 */
public class WeatherServiceTest {

    /** The log. */
    Logger log = Logger.getLogger(WeatherServiceTest.class.getName());

    /**
     * Test weather service.
     */
    @Test
    public void testWeatherService() {
        WeatherService ws = new WeatherService();
        try {
            assertTrue(ws.retrieveForecast("Stuttgart") != null);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
    }
}
