package br.com.desprotetorlink.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author rodrigoramalho
 *
 */
public class SendMail {

	private String mailSMTPServer;
	private String mailSMTPServerPort;
	private String username = "removelinkguard@gmail.com";
	private String password = "***";

	// Default gmail.
	public SendMail() { 
		mailSMTPServer = "smtp.gmail.com";
		mailSMTPServerPort = "465";
	}

	public SendMail(String mailSMTPServer, String mailSMTPServerPort) {
		this.mailSMTPServer = mailSMTPServer;
		this.mailSMTPServerPort = mailSMTPServerPort;
	}

	public void sendMail(String from, String to, String subject, String message) {

		Properties props = new Properties();

		// para SERVIDOR PROXY descomente essa parte e atribua as propriedades
		/*
                props.setProperty("proxySet","true");
                props.setProperty("socksProxyHost","192.168.155.1"); // IP do Servidor Proxy
                props.setProperty("socksProxyPort","1080");  // Porta do servidor Proxy
		 */

		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.starttls.enable","true"); 
		props.put("mail.smtp.host", mailSMTPServer);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.user", from);
		props.put("mail.debug", "false");
		props.put("mail.smtp.port", mailSMTPServerPort); //porta
		props.put("mail.smtp.socketFactory.port", mailSMTPServerPort); //mesma porta para o socket
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		SimpleAuth auth = null;
		auth = new SimpleAuth (username,password);

		Session session = Session.getDefaultInstance(props, auth);
//		session.setDebug(true); //Habilita o LOG das ações executadas durante o envio do email

		Message msg = new MimeMessage(session);

		try {
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setFrom(new InternetAddress(from));
			msg.setSubject(subject);
			message += "\n\n Enviado por: "+from;
			msg.setContent(message,"text/plain");
		} catch (Exception e) {
			System.out.println(">> Erro: Completar Mensagem");
			e.printStackTrace();
		}

		Transport tr;
		try {
			tr = session.getTransport("smtp"); //define smtp para transporte
			tr.connect(mailSMTPServer, username, password);
			msg.saveChanges(); // don't forget this
			//envio da mensagem
			tr.sendMessage(msg, msg.getAllRecipients());
			tr.close();
		} catch (Exception e) {
			System.out.println(">> Erro: "+e.getMessage());
			e.printStackTrace();
		}

	}
}
