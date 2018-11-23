package de.fh.albsig.matrikel_84788.service;

import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

/**
 * The Class WeatherService.
 */
public class WeatherService {

    /** Logger. */
    private static Logger log = Logger
            .getLogger(WeatherService.class.getName());

    /**
     * Retrieve forecast.
     *
     * @param city
     *            from user
     * @return xml string from yahoo weather api
     * @throws Exception
     *             if retrieving fails
     */
    public final String retrieveForecast(final String city) throws Exception {
        log.info("get weather");
        URL url = new URL(
                "https://query.yahooapis.com/" + "v1/public/yql?q=select%20*%20"
                        + "from%20weather.forecast%20where%20"
                        + "woeid%20in%20(select%20woeid%20"
                        + "from%20geo.places(1)%20where%20" + "text%3D%22"
                        + city + "%22)and" + "%20u%3D%22c%22");
        URLConnection urlc = url.openConnection();
        return IOUtils.toString(urlc.getInputStream(), StandardCharsets.UTF_8);
    }
}
