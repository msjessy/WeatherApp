package de.fh.albsig.matrikel_84788.servlets;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fh.albsig.matrikel_84788.errorhandler.ErrorHandler;
import de.fh.albsig.matrikel_84788.service.WeatherService;

/**
 * Class WeatherServlet.
 */
public class WeatherServlet extends HttpServlet implements Serializable {

    private static final long serialVersionUID = -6004602445517820628L;
    /** The log. */
    private static Logger log = Logger
            .getLogger(WeatherServlet.class.getName());

    /**
     * Handles the get request and returns weatherdata as xml.
     *
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response).
     * @param request
     *            the users request
     * @param response
     *            the servers response
     * @throws ServletException
     *             if something goes wrong in the servlet
     * @throws IOException
     *             if doGet fails on IO handling
     */
    @Override
    public final void doGet(final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException {
        ErrorHandler eh = null;
        WeatherService weatherService = new WeatherService();
        String city = request.getParameter("city");
        log.info("Check if city is null or empty");
        if (city == null || "".equals(city)) {
            log.warn("city is null or empty");
            eh = new ErrorHandler("City is missing",
                    "Please add a city as parameter in the url");
            response.getWriter().append(eh.throwErrorXML());
        }
        if (eh == null) {
            log.info("City: " + city);
            try {
                response.getWriter()
                        .append(weatherService.retrieveForecast(city));
            } catch (Exception e) {
                eh = new ErrorHandler(e.toString(), e.getMessage());
                response.getWriter().append(eh.throwErrorXML());
            }
        }
    }

    /**
     * Handles the get request and call doGet with params from itself.
     *
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response).
     * @param request
     *            the users request
     * @param response
     *            the servers response
     * @throws ServletException
     *             if something goes wrong in the servlet
     * @throws IOException
     *             if doPost fails on IO handling
     */
    @Override
    protected final void doPost(final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
