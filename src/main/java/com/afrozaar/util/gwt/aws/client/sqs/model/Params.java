package com.afrozaar.util.gwt.aws.client.sqs.model;

import com.google.gwt.core.client.JsArrayString;

import jsinterop.annotations.JsProperty;

public class Params {

    @JsProperty(name = "ReceiptHandle")
    public native void setReceiptHandle(String receiptUrl);
    

}
