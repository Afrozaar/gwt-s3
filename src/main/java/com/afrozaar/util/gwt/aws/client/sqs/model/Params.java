package com.afrozaar.util.gwt.aws.client.sqs.model;

import com.google.gwt.core.client.JsArrayString;

import jsinterop.annotations.JsProperty;

public class Params {

    @JsProperty(name = "QueueUrl")
    public native void setQueueUrl(String queueUrl);

    @JsProperty(name = "ReceiptHandle")
    public native void setReceiptHandle(String receiptUrl);
    
    @JsProperty(name = "AttributeNames")
    public native void setAttributeNames0(JsArrayString names);

    public void setAttributeNames(String[] input) {
        setAttributeNames0(toJsArray(input));
    }

    public static JsArrayString toJsArray(String[] input) {
        JsArrayString jsArrayString = JsArrayString.createArray().cast();
        for (String s : input) {
            jsArrayString.push(s);
        }
        return jsArrayString;
    }

}
