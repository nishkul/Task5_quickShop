package com.android.task.model;

/**
 * Created by Manish on 20/4/17.
 */
public class ChatModel {
    private String title;
    private String time;
    private String message;
    private int chatCount;
    private boolean isDone;

    /**
     * Instantiates a new Chat model.
     *
     * @param chatCount the chat count
     * @param title     the title
     * @param time      the time
     * @param message   the message
     * @param isDone    the is done
     */
    public ChatModel(int chatCount, String title, String time, String message, boolean isDone) {
        this.chatCount = chatCount;
        this.title = title;
        this.time = time;
        this.message = message;
        this.isDone = isDone;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Gets chat count.
     *
     * @return the chat count
     */
    public int getChatCount() {
        return chatCount;
    }

    /**
     * Sets chat count.
     *
     * @param chatCount the chat count
     */
    public void setChatCount(int chatCount) {
        this.chatCount = chatCount;
    }

    /**
     * Is done boolean.
     *
     * @return the boolean
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Sets done.
     *
     * @param done the done
     */
    public void setDone(boolean done) {
        isDone = done;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
