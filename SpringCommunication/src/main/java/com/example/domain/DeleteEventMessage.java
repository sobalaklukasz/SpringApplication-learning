package com.example.domain;

import com.example.model.User;
import org.springframework.context.ApplicationEvent;

/**
 * Created by Lukasz Sobalak on <lukasz.sobalak@mitron.com.
 */
public class DeleteEventMessage extends ApplicationEvent
{
    private User user;

    public DeleteEventMessage(Object source, User user)
    {
        super(source);
        this.user = user;
    }

    public User getUser()
    {
        return user;
    }

    @Override
    public String toString()
    {
        return "DeleteEventMessage{" +
                "user=" + user +
                '}';
    }
}
