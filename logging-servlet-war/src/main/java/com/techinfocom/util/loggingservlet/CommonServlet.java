package com.techinfocom.util.loggingservlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techinfocom.common.SessionIDGenerator;
import com.techinfocom.common.TicSessionID;
import com.techinfocom.common.log.Logger;
import com.techinfocom.common.log.LoggerFactory;
import com.techinfocom.common.log.MethodLogger;

@WebServlet(name = "logging_url", urlPatterns = {"/logging_url"})
public class CommonServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonServlet.class);
    
    @Override
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) {
        final TicSessionID sessionID = new TicSessionID(SessionIDGenerator.getNewSessionID());
        final MethodLogger logger = LOGGER.entering(sessionID, "doGet");
        
        logger.info("qualified name of the client or the last proxy that sent the request: host={}; port={}; host name and port of the server to which the request was sent: host={}; port={};", request.getRemoteAddr(), request.getRemotePort(), request.getServerName(), request.getServerPort());
    }
}
