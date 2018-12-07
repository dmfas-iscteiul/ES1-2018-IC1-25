package mailpack;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class ReadEmail {
	
	public static void main(String[] args) {

		String host = "imap.gmail.com";
		String username = "es1.2018.ic1.25@gmail.com";
		String password = "ES1_g25_det";

		fetch(host, username, password);

	}

   public static void fetch(String Host, String user, String password) {
      try {
         Properties properties = new Properties();
         properties.put("mail.store.protocol", "imaps");
         Session emailSession = Session.getDefaultInstance(properties);
         Store store = emailSession.getStore("imaps");
         store.connect(Host, user, password);

         Folder emailFolder = store.getFolder("INBOX");
         emailFolder.open(Folder.READ_WRITE);

         Message[] messages = emailFolder.getMessages();
         //System.out.println("messages.length---" + messages.length);
         Message message;
         for (int i = 0; i < messages.length; i++) {
            message = messages[i];
            System.out.println("---------------------------------");
            writeContent(message);
         }

         emailFolder.close(false);
         store.close();

      } catch (NoSuchProviderException e) {
         e.printStackTrace();
      } catch (MessagingException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }


   public static void writeContent(Message message) throws Exception {
	         writeHeader(message);

	      if (message.isMimeType("text/plain"))
	         System.out.println((String) message.getContent());
	      else if (message.isMimeType("multipart/*"))
	      {
	         Multipart mp = (Multipart) message.getContent();
	         int count = mp.getCount();
	         for (int i = 0; i < count; i++)
	           if(mp.getBodyPart(i).isMimeType("text/plain"))
	        	   System.out.println(mp.getBodyPart(i).getContent());
	      }
	   }
   
   public static void writeHeader(Message message) throws Exception {
      Address[] a;

      if ((a = message.getFrom()) != null)
      {
         for (int j = 0; j < a.length; j++)
        	 System.out.println("FROM: " + a[j].toString());
      }

      if ((a = message.getRecipients(Message.RecipientType.TO)) != null)
      {
         for (int j = 0; j < a.length; j++)
        	 System.out.println("TO: " + a[j].toString());
      }

      if (message.getSubject() != null)
         System.out.println("SUBJECT: " + message.getSubject());
   }

}