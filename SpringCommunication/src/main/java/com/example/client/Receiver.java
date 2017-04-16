package com.example.client;

import com.example.dao.StorageHandler;
import com.example.domain.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lukasz Sobalak on <lukasz.sobalak@mitron.com.
 */

@Service
public class Receiver
{
    private Logger logger = Logger.getLogger(Receiver.class);

    @Autowired
    private StorageHandler storageHandler;

    @EventListener
    void handleCreateEventMessage(CreateEventMessage createEventMessage) throws DatabaseQueryException
    {
        storageHandler.Create(createEventMessage.getUser());
        logger.debug("User created");
    }

    @EventListener
    void handleReadEventMessage(ReadEventMessage readEventMessage) throws DatabaseQueryException
    {
        List users = storageHandler.Read();
        logger.debug(String.format("Got following users: %s", users));
    }

    @EventListener
    void handleUpdateEventMessage(UpdateEventMessage updateEventMessage) throws DatabaseQueryException
    {
       storageHandler.Update(updateEventMessage.getOldUser(), updateEventMessage.getNewUser());
       logger.debug("User updated");
    }

    @EventListener
    void handleDeleteEventMessage(DeleteEventMessage deleteEventMessage) throws DatabaseQueryException
    {
        storageHandler.Delete(deleteEventMessage.getUser());
        logger.debug("User deleted");
    }

}