import java.util.Scanner;

public class EmailApplication {
    private static ListOfEmails Inbox = new ListOfEmails();
    private static ListOfEmails Archive = new ListOfEmails();
    private static ListOfEmails Trash = new ListOfEmails();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";

        /*
        
            // I used these for testing my program, you can use them aswell!

            
        */

        
        Email test1 = new Email();
        test1.setSubject("Sub1AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        test1.setId(123);
        test1.setMessage("ReadAAAAAAAAAAAAAAAAAAAAAAAAABBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        test1.setTime(456);
        test1.setRead(true);

        Inbox.add(test1);

        Email test2 = new Email();
        test2.setSubject("Sub2");
        test2.setId(111);
        test2.setMessage("UnreadBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
        test2.setTime(456);
        test2.setRead(false);

        Inbox.add(test2);

        while (input.toUpperCase() != "Q") {
            input = sc.nextLine();

            String command = input.substring(0, 1);
            String[] inputArgs = input.split(" ");

            switch (command) {
                case "N":
                    String newSubject = sc.nextLine();
                    
                    int newId = sc.nextInt();
                    sc.nextLine();
                    
                    String newMessage = sc.nextLine();
                    
                    int newTime = sc.nextInt();
                    sc.nextLine();

                    Email newEmail = new Email();
                    newEmail.setSubject(newSubject);
                    newEmail.setId(newId);
                    newEmail.setMessage(newMessage);
                    newEmail.setTime(newTime);

                    Inbox.add(newEmail);
                    System.out.println("Successfully added email");
                    break;
                    
                case "R":
                    if (inputArgs.length < 2) {
                        System.out.println("Please enter an id");
                        break;
                    };
                    
                    int readId = Integer.parseInt(inputArgs[1]);
                    Inbox.read(readId);
                    break;
                    
                case "A":
                    if (inputArgs.length < 2) {
                        System.out.println("Please enter an id");
                        break;
                    };
                    
                    int archiveId = Integer.parseInt(inputArgs[1]);
                    if (!Inbox.find(archiveId)) {
                        System.out.println("No such email");
                        break;
                    };

                    Email archivedEmail = Inbox.delete(archiveId);
                    Archive.add(archivedEmail);

                    System.out.println("Email" + archiveId + " successfully archived");
                    break;
                
                case "D":
                    if (inputArgs.length < 2) {
                        System.out.println("Please enter an id");
                        break;
                    };
                    
                    int deleteId = Integer.parseInt(inputArgs[1]);
                    if (!Inbox.find(deleteId)) {
                        System.out.println("No such email");
                        break;
                    };

                    Email deletedEmail = Inbox.delete(deleteId);
                    Trash.add(deletedEmail);

                    System.out.println("Email successfully deleted");
                    break;

                case "S":
                    if (inputArgs.length < 2) {
                        System.out.println("Please enter a folder");
                        break;
                    };
                    
                    String showType = inputArgs[1];
                    if (showType.toUpperCase().equals("I") || showType.equals("Inbox")) {
                        Inbox.showAll(true);
                    } else if (showType.toUpperCase().equals("A") || showType.equals("Archive")) {
                        Archive.showAll(true);
                    } else if (showType.toUpperCase().equals("T") || showType.equals("Trash")) {
                        Trash.showAll(true);
                    } else {
                        System.out.println("Invalid folder");
                        break;
                    };

                    break;
                case "U":
                    if (inputArgs.length < 2) {
                        System.out.println("Please enter a folder");
                        break;
                    };

                    String showUnreadType = inputArgs[1];
                    if (showUnreadType.toUpperCase().equals("I") || showUnreadType.equals("Inbox")) {
                        Inbox.showAll(false);
                    } else if (showUnreadType.toUpperCase().equals("T") || showUnreadType.equals("Trash")) {
                        Trash.showAll(false);
                    } else if (showUnreadType.toUpperCase().equals("A") || showUnreadType.equals("Archive")) {
                        Archive.showAll(false);
                    } else {
                        System.out.println("Invalid folder");
                        break;
                    };

                    break;
                
                case "C":
                    if (inputArgs.length < 2) {
                        System.out.println("Please enter a folder");
                        break;
                    };
                    
                    String clearType = inputArgs[1];
                    if (clearType.equals("I")) {
                        Inbox.moveAll(Trash);
                        System.out.println("Inbox cleared!");
                    } else if (clearType.equals("T")) {
                        Trash.clear();
                        System.out.println("Trash cleared!");
                    } else if (clearType.equals("A")) {
                        Archive.moveAll(Trash);
                        System.out.println("Archive cleared!");
                    } else {
                        System.out.println("Invalid type");
                        break;
                    };

                    break;

                case "Q":
                    input = "Q";
                    System.out.println("Quitting..");
                    break;

                default:
                    break;
            }
        };

        sc.close();
    };
}
