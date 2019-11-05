package com.afrozaar.util.gwt.aws.client.sqs.model;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsProperty;

public abstract class GetQueueUrlResponse {

    @JsProperty(name = "QueueUrl")
    public native String getQueueUrl();

}
