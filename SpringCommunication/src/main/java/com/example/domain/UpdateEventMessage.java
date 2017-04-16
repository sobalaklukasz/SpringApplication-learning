package com.example.domain;

import com.example.model.User;
import org.springframework.context.ApplicationEvent;

/**
 * Created by Lukasz Sobalak on <lukasz.sobalak@mitron.com.
 */
public class UpdateEventMessage extends ApplicationEvent
{
    private User oldUser;
    private User newUser;

    public UpdateEventMessage(Object source, User oldUser, User newUser)
    {
        super(source);
        this.oldUser = oldUser;
        this.newUser = newUser;
    }

    public User getOldUser()
    {
        return oldUser;
    }

    public User getNewUser()
    {
        return newUser;
    }


    @Override
    public String toString()
    {
        return "UpdateEventMessage{" +
                "oldUser=" + oldUser +
                ", newUser=" + newUser +
                '}';
    }
}
