package com.example.domain;

import com.example.model.User;
import org.springframework.context.ApplicationEvent;

/**
 * Created by Lukasz Sobalak on <lukasz.sobalak@mitron.com.
 */
public class CreateEventMessage extends ApplicationEvent
{
    private User user;

    public CreateEventMessage(Object source, User user)
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
        return "CreateEventMessage{" +
                "user=" + user +
                '}';
    }
}
