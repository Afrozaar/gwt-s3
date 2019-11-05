package com.afrozaar.util.gwt.aws.client.sqs.model;

import jsinterop.annotations.JsProperty;

public class DeleteQueueRequest {

    @JsProperty(name = "QueueUrl")
    public native void setQueueUrl(String queueUrl);

    public DeleteQueueRequest(String queueUrl) {
        setQueueUrl(queueUrl);
    }
}
