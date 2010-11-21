package br.com.haxor.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.haxor.service.RemoveLinkService;
import br.com.haxor.service.RemoveLinkServiceImpl;

public class RemoveLinkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RemoveLinkService linkService= new RemoveLinkServiceImpl();
	
	/**
	 * Ate agora soh existem esses casos.
	 * http://clubedodownload.info/link/?url=http://www.megaupload.com/?d=G6ZFTBJW
	 * http://fire.tiozao.net/?url=Sjh56Jm/elif/moc.evreselif.www//:ptth
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("link");
		
		String brokenUrl = "";
		
		try{
			brokenUrl = this.linkService.breakUrl(url);
			
			if (brokenUrl == null){
				brokenUrl = "";
			}
		}catch (Exception e) { 
			e.getStackTrace();
			request.setAttribute("erro", e.getMessage());
		}
		
		request.setAttribute("link", brokenUrl);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/link.jsp");
		dispatcher.forward(request, response);
	}

}
