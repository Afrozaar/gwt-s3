package com.afrozaar.util.gwt.aws.client.sqs.model;

import jsinterop.annotations.JsProperty;

public class GetQueueUrlRequest {

    @JsProperty(name = "QueueName")
    public native void setQueueName(String queueUrl);

    @JsProperty(name = "QueueOwnerAWSAccountId")
    public native void setQueueOwnerAccountId(String ownerAccountId);

    public GetQueueUrlRequest(String queueName) {
        setQueueName(queueName);
    }
}
