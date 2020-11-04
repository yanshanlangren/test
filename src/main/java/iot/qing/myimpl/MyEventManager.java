package iot.qing.myimpl;

import iot.qing.beans.EventBase;
import iot.qing.interfaces.EventManagerBase;
import iot.qing.utils.LogUtils;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyEventManager implements EventManagerBase {

    Queue<EventBase> eventQueue = new LinkedBlockingQueue<EventBase>();

    public MyEventManager(){
        super();
        listen();
    }

    @Override
    public void push(EventBase event) {
        eventQueue.add(event);
    }

    @Override
    public EventBase pull() {
        if(eventQueue.isEmpty())
            return null;
        return eventQueue.poll();
    }


    @Override
    public void listen() {
        new Thread(){
            @Override
            public void run(){
                LogUtils.log("MyThingModel started listening...");
                while(true) {
                    EventBase event = pull();
                    if (event != null) {
                        LogUtils.log(event.toString());
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public void registerEvent(EventBase event) {
        //TODO do sth
    }
}
