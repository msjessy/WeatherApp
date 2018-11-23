package de.fh.albsig.matrikel_84788;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import de.fh.albsig.matrikel_84788.servlets.WeatherServlet;

public class WeatherServletTest extends Mockito {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private StringWriter stringWriter;
	private PrintWriter writer;
	
	@BeforeEach
	public void init() {
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		stringWriter = new StringWriter();
		writer = new PrintWriter(stringWriter);
	}

    @Test
    public void testReturnTextHtml() throws ServletException, IOException {

        when(request.getParameter("location")).thenReturn("Stuttgart");
        when(request.getParameter("country")).thenReturn("de");
        when(response.getWriter()).thenReturn(writer);

        new WeatherServlet().doGet(request, response);

        assertNotNull(stringWriter);
        assertTrue(!stringWriter.toString().equals(""));
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

        assertNotNull(stringWriter);
        assertTrue(!stringWriter.toString().equals(""));
    }
    
    @AfterEach
	public void end() {
		writer.flush();
	}
}