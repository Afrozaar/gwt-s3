package com.afrozaar.util.gwt.aws.client.sqs.model;

import jsinterop.annotations.JsProperty;

public class DeleteMessageRequest {

    @JsProperty(name = "QueueUrl")
    public native void setQueueUrl(String queueUrl);

    @JsProperty(name = "ReceiptHandle")
    public native void setReceiptHandle(String receiptUrl);

}
