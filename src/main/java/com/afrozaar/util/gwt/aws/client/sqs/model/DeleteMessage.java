package com.afrozaar.util.gwt.aws.client.sqs.model;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsProperty;

public class DeleteMessage {

    public static class Request {
        public Request() {
        }

        public Request(String qeueUrl, String receiptHandle) {
            setQueueUrl(qeueUrl);
            setReceiptHandle(receiptHandle);
        }

        @JsProperty(name = "QueueUrl")
        public native void setQueueUrl(String queueUrl);

        @JsProperty(name = "ReceiptHandle")
        public native void setReceiptHandle(String receiptUrl);
    }

    @JsFunction
    public interface Function {

        public void result(Object error, Result data);
    }

}
