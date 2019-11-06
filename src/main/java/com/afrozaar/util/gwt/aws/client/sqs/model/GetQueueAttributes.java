package com.afrozaar.util.gwt.aws.client.sqs.model;

import com.google.gwt.core.client.JsArrayString;

import elemental2.core.JsMap;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsProperty;

public class GetQueueAttributes {

    public static class Request {

        @JsProperty(name = "AttributeNames")
        public native void setAttributeNames0(JsArrayString names);

        @JsProperty(name = "QueueUrl")
        public native void setQueueUrl(String queueUrl);

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

    public static class Response {

        @JsProperty(name = "ResponseMetadata")
        public native final JsMap<String, String> getResponseMetaData();

        @JsProperty(name = "Attributes")
        public native final JsMap<String, String> getAttributes();

    }

    @JsFunction
    @FunctionalInterface
    public interface Function {
        public void response(Object error, Response response);
    }
}
