package de.fh.albsig.matrikel_84788;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import de.fh.albsig.matrikel_84788.servlets.WeatherServlet;

public class WeatherServletTest extends Mockito {

    @Test
    public void testReturnTextHtml() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("location")).thenReturn("Stuttgart");
        when(request.getParameter("country")).thenReturn("de");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new WeatherServlet().doGet(request, response);

        assertTrue(stringWriter != null);
        assertFalse(stringWriter.toString().equals(""));
    }

    @Test
    public void testReturnErrorCode() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("city")).thenReturn("Stuttgart");
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new WeatherServlet().doGet(request, response);

        assertTrue(stringWriter != null);
        assertFalse(stringWriter.toString().equals(""));
    }
}