package mailpack;

import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;

/**
 * @author tiago
 *
 */
public class MailApp {
	
	public MailApp () {
		//SimpleJavaMail é para enviar emails através de SMTP
		MailerBuilder
		  .withSMTPServer("smtp.gmail.com", 465, "es1.2018.ic1.25@gmail.com", "ES1_g25_det")
		  .withTransportStrategy(TransportStrategy.SMTPS);
		
		// configure your mailer
		//Mailer inhouseMailer = new Mailer("server", 25, "es1.2018.ic1.25@gmail.com", "ES1_g25_det");

		// perform connection test
	//	inhouseMailer.testConnection(); // no error means success
		
		//inhouseMailer.sendMail("es1-2018-ic1-25@gmail.com");
		
	}
	
	//
	
}