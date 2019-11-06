package com.afrozaar.util.gwt.aws.client.sqs.model;

import com.google.gwt.core.client.GWT;

import com.github.nmorel.gwtjackson.client.ObjectMapper;

import java.util.Map;

import elemental.json.Json;
import elemental.json.JsonObject;
import elemental2.core.JsMap;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsProperty;

public class CreateQueue {

    public static interface Mapper extends ObjectMapper<Map<String, Object>> {
    }

    public static Mapper mapper = GWT.create(Mapper.class);

    public static class Request {

        public Request(String queueName, Map<String, Object> object) {
            setQueueName(queueName);
            String write = mapper.write(object);
            GWT.log("json = " + write);

            JsonObject parse = Json.parse(write);
            /*JsMap<String, Object> jsMap = new JsMap<>();
            object.forEach((k, v) -> {
                if (v instanceof Number) {
                    jsMap.set(k, ((Number) v).intValue());
                } else {
                    jsMap.set(k, v);
                }
            });*/
            setQueueAttributes(parse);
            log(parse);
        }

        public native void log(Object object) /*-{
			console.log(object);
        }-*/;

        @JsProperty(name = "QueueName")
        public native void setQueueName(String queueUrl);

        @SuppressWarnings("unusable-by-js")
        @JsProperty(name = "Attributes")
        public native void setQueueAttributes(JsonObject attributes);

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
