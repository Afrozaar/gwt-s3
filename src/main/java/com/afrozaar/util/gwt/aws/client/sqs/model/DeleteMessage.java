package com.afrozaar.util.gwt.aws.client.sqs.model;

import jsinterop.annotations.JsProperty;

public class DeleteMessage {

    public static class Request {
        @JsProperty(name = "QueueUrl")
        public native void setQueueUrl(String queueUrl);

        @JsProperty(name = "ReceiptHandle")
        public native void setReceiptHandle(String receiptUrl);
    }

}
