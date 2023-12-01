public class Email {
    String message;
    String subject;
    Boolean read = false;
    int time;
    int id;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Boolean getRead() {
        return read;
    }
    
    public void setRead(Boolean read) {
        this.read = read;
    }

    public String truncate(Object o, String type) {
        if (o instanceof String) {
            if (type == "subject") {
                String s = (String) o;
                if (s.length() > 25) {
                    String str = "";
                    str = s.substring(0, 22) + "...";
                    
                    return str;
                };
            } else if (type == "body") {
                String s = (String) o;
                if (s.length() > 40) {
                    String str = "";
                    str = s.substring(0, 37) + "...";
                    
                    return str;
                };
            }

            return (String) o;
        };

        return null;
    }
};