package threads.blockingqueue;

public class Message {
    private String message;

    public Message(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return  message;
    }
}
