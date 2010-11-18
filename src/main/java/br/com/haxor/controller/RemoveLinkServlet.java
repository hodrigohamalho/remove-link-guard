package br.com.haxor.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author rodrigoramalho
 * 		   hodrigohamalho@gmail.com
 *
 */
public class RemoveLinkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Ate agora soh existem esses casos.
	 * http://clubedodownload.info/link/?url=http://www.megaupload.com/?d=G6ZFTBJW
	 * http://fire.tiozao.net/?url=Sjh56Jm/elif/moc.evreselif.www//:ptth
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("link");
		
		request.setAttribute("link", url);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/link.jsp");
		dispatcher.forward(request, response);
	}

}
