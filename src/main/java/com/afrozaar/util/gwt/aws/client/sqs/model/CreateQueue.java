package com.afrozaar.util.gwt.aws.client.sqs.model;

import java.util.Map;

import elemental2.core.JsMap;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsProperty;

public class CreateQueue {

    public static class Request {

        public Request(String queueName, Map<String, String> object) {
            setQueueName(queueName);
            JsMap<String, String> jsMap = new JsMap<String, String>();
            object.forEach((k, v) -> jsMap.set(k, v));
            setQueueAttributes(jsMap);
        }

        @JsProperty(name = "QueueName")
        public native void setQueueName(String queueUrl);

        @JsProperty(name = "Attributes")
        public native void setQueueAttributes(JsMap<String, String> attributes);

    }

    @JsFunction
    public interface Function {
        public void result(Object terror, Response response);
    }

    public static class Response {

        @JsProperty(name = "QueueUrl")
        public native final String getQueueUrl();

    }

}
