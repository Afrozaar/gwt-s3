package com.afrozaar.util.gwt.aws.client.sqs.model;

import jsinterop.annotations.JsProperty;

public class ResponseMetadata {
    
    @JsProperty(name = "RequestId")
    public native String getRequestId();
}
