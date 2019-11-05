package com.afrozaar.util.gwt.aws.client.s3.model;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsProperty;

@JsFunction
@FunctionalInterface
public interface UploadComplete {

    public void response(String error, UploadResult data);

    public static class UploadResult {

        @JsProperty(name = "Bucket")
        public native String getBucket();

        @JsProperty(name = "ETag")
        public native String getETag();

        @JsProperty(name = "Key")
        public native String getKey();

        @JsProperty(name = "Location")
        public native String getLocation();

    }
}
