package com.afrozaar.util.gwt.aws.client.s3.model;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsProperty;

@JsFunction
@FunctionalInterface
public interface IProgressListener {

    public static class ProgressEvent {

        @JsProperty(name = "loaded")
        public native int getLoaded();

        @JsProperty(name = "total")
        public native int getTotal();

        @JsProperty(name = "key")
        public native String getKey();

    }

    public void progress(ProgressEvent event);
}
