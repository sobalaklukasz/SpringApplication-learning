package com.example.producer;

import com.example.domain.CreateEventMessage;
import com.example.domain.DeleteEventMessage;
import com.example.domain.ReadEventMessage;
import com.example.domain.UpdateEventMessage;
import com.example.model.User;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Created by Lukasz Sobalak on <lukasz.sobalak@mitron.com.
 */

@Component("producer")
public class Publisher implements ApplicationEventPublisherAware
{
    private static Logger logger = Logger.getLogger(Publisher.class);
    private ApplicationEventPublisher applicationEventPublisher;

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher)
    {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void createRequest(User user)
    {
        logger.debug("Published create message...");
        CreateEventMessage createEventMessage = new CreateEventMessage(this, user);
        publish(createEventMessage);
    }

    public void updateRequest(User oldUser, User newUser)
    {
        logger.debug("Published update message...");
        UpdateEventMessage updateEventMessage= new UpdateEventMessage(this, oldUser, newUser);
        publish(updateEventMessage);
    }

    public void readRequest()
    {
        logger.debug("Published read message...");
        ReadEventMessage readEventMessage = new ReadEventMessage(this);
        publish(readEventMessage);
    }

    public void deleteRequest(User user)
    {
        logger.debug("Published delete message...");
        DeleteEventMessage deleteEventMessage = new DeleteEventMessage(this, user);
        publish(deleteEventMessage);
    }

    private void publish(ApplicationEvent applicationEvent)
    {
        applicationEventPublisher.publishEvent(applicationEvent);
    }

}
