package nl.casperlambers.serverbase.chat.types;

public class Mail {
    public static String[] parseMail(String rawMail) {
        return rawMail.split(":", 3);
    }
}
