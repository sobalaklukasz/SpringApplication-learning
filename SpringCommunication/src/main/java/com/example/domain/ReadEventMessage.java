package com.example.domain;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Lukasz Sobalak on <lukasz.sobalak@mitron.com.
 */
public class ReadEventMessage extends ApplicationEvent
{
    @Override
    public String toString()
    {
        return "ReadEventMessage{}";
    }

    public ReadEventMessage(Object source)
    {
        super(source);
    }
}
