package com.afrozaar.util.gwt.aws.client.sqs.model;

import jsinterop.annotations.JsProperty;

public class DeleteQueue {
    public static class Request {
        @JsProperty(name = "QueueUrl")
        public native void setQueueUrl(String queueUrl);

        public Request(String queueUrl) {
            setQueueUrl(queueUrl);

        }
    }
}
