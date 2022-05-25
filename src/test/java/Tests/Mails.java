package Tests;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;

public class Mails {

    public static void  main(String[] args) throws MessagingException, IOException {
        String userEmail = "";
        String password = "";
        Properties properties = new Properties();
        properties.put("mail.imaps.ssl.enable", "true");
        properties.put("mail.imap.ssl.enable", "true");
        properties.put("mail.debug", "true");
        properties.put("mail.debug.auth", "true");
        properties.put("mail.imaps.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(properties, null);
        Store store = session.getStore("imaps");
        store.connect("outlook.office365.com", 993, userEmail, password);

        //Open the inbox folder in read/write mode
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_WRITE);

        // retrieve the messages from the folder in an array and print it
        Message[] messages = inbox.getMessages();
        System.out.println("messages.length---" + messages.length);

        for (int i = 0, n = messages.length; i < n; i++) {
            Message message = messages[i];
            System.out.println("---------------------------------");
            System.out.println("Email Number " + (i + 1));
            System.out.println("Subject: " + message.getSubject());
            System.out.println("From: " + message.getFrom()[0]);
            System.out.println("Text: " + message.getContent().toString());
        }
    }
}
