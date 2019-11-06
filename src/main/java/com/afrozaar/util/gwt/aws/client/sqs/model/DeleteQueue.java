package com.afrozaar.util.gwt.aws.client.sqs.model;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsProperty;

public class DeleteQueue {
    public static class Request {
        @JsProperty(name = "QueueUrl")
        public native void setQueueUrl(String queueUrl);

        public Request(String queueUrl) {
            setQueueUrl(queueUrl);

        }
    }

    @JsFunction
    public interface Function {

        public void result(Object error, Result data);
    }

}
