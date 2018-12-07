package mailpack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import utlity.Lista;


public class ReadEmail {
	
	static List<Lista> lx = new ArrayList<>();
		
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
         System.out.println("messages.length---" + messages.length);
         Message message;
         String h ="";
         String content ="";
         Date d;
         for (int i = 0; i < messages.length; i++) {
            message = messages[i];
           // System.out.println("---------------------------------");
            h = writeHeader(message);
            content = writeContent(message);
            d = writeDate(message);
            lx.add(new Lista("Mail" + h,content,d));
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
    public static String writeContent(Message message) throws Exception {
    	  String content="";
 	      if (message.isMimeType("text/plain"))
	         content = content + (String) message.getContent();
	      else if (message.isMimeType("multipart/*"))
	      {
	         Multipart mp = (Multipart) message.getContent();
	         int count = mp.getCount();
	         for (int i = 0; i < count; i++)
	           if(mp.getBodyPart(i).isMimeType("text/plain"))
	        	   content = content + mp.getBodyPart(i).getContent();
	      }
 	      return content;
	   }
   
   public static String writeHeader(Message message) throws Exception {
      Address[] a;
      String h ="";
 
      if ((a = message.getFrom()) != null)
      {  
         for (int j = 0; j < a.length; j++)
        	 h= h + "FROM: " + a[j].toString();
      }
      if ((a = message.getRecipients(Message.RecipientType.TO)) != null)
      {
         for (int j = 0; j < a.length; j++)
        	 h= h + "\n TO: " + a[j].toString();
      }
      if (message.getSubject() != null)
         h= h + "\n SUBJECT: " + message.getSubject();
      
      return h;
     
   }
  
   public static Date writeDate(Message message) throws MessagingException {
	   return message.getReceivedDate();
   }
   
   /**
	 * @return list of strings with the twitter posts
	 */
	public ArrayList<Lista> getLx() {
		return (ArrayList<Lista>) lx;
	}
}