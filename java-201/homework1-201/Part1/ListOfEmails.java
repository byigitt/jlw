import java.util.LinkedList;

public class ListOfEmails {
    LinkedList<Email> emails = new LinkedList<Email>();

    public void add(Email E) {
        emails.add(E);
    }

    public void read(int id) {
        for (Email e : emails) {
            if (e.getId() == id) {
                System.out.println("Email id: " + e.getId());
                System.out.println("Subject: " + e.getSubject());
                System.out.println("Body: " + e.getMessage());
                System.out.println("Time: " + e.getTime());
                System.out.format("Status: %s", e.getRead() ? "Read\n" : "Unread\n");

                e.setRead(true);
                return;
            }
        }
        
        System.out.println("No such email.");
    }

    public boolean find(int id) {
        for (Email e : emails) {
            if (e.getId() == id) {
                return true;
            }
        }
        
        return false;
    }

    public Email delete(int id) {
        for (Email e : emails) 
            if (e.getId() == id) {
                emails.remove(e);
                return e;
            }
        
        return null;
    }

    public void clear() {
        emails.clear();
    }

    public void showAll(boolean flag) {
        System.out.printf("%-10s %-28s %-43s %-10s %-10s\n", "Email", "Subject", "Body", "Time", "Read");
        for (Email e : emails) {
            if (flag) 
                System.out.format("%-10s %-28s %-43s %-10s %-10s\n", e.getId(), e.truncate(e.getSubject(), "subject"), e.truncate(e.getMessage(), "body"), e.getTime(), e.getRead() ? "Yes" : "No");
            else 
                if (!e.getRead())
                    System.out.format("%-10s %-28s %-43s %-10s %-10s\n", e.getId(), e.truncate(e.getSubject(), "subject"), e.truncate(e.getMessage(), "body"), e.getTime(), e.getRead() ? "Yes" : "No");
        }
    }

    public void moveAll(ListOfEmails destination) {
        for (Email e : emails) {
            destination.add(e);
            emails.remove(e);
            return;
        }
    }
}
