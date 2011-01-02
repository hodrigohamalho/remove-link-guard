package br.com.jspace.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jspace.mail.SendMail;

public class SuggestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter("suggestion");
		String from = "removelinkguard@gmail.com";
		String to = "removelinkguard@gmail.com";
		String subject = "Sugestao remove link guard.";
		
		SendMail sm = new SendMail("smtp.gmail.com","465");
		sm.sendMail(from, to, subject, message);
	}
}
