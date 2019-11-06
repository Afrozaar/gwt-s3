package com.afrozaar.util.gwt.aws.client.sqs.model;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsProperty;

public class GetQueueUrl {

    public static class Request {
        @JsProperty(name = "QueueName")
        public native void setQueueName(String queueName);

        @JsProperty(name = "QueueOwnerAWSAccountId")
        public native void setQueueOwnerAccountId(String ownerAccountId);

        public Request() {
        }

        public Request(String queueName) {
            this.setQueueName(queueName);
        }

    }

    @JsFunction
    @FunctionalInterface
    public interface Function {

        public void result(Object error, GetQueueUrl.Response data);
    }

    public static class Response {
        @JsProperty(name = "QueueUrl")
        public native String getQueueUrl();
    }

}
