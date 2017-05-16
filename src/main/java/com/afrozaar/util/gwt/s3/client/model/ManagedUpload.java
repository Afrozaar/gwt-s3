package com.afrozaar.util.gwt.s3.client.model;

import jsinterop.annotations.JsMethod;

public class ManagedUpload {

    @JsMethod
    public native void abort();

    @JsMethod
    public native void on(String event, IProgressListener progress);

    @JsMethod
    public native void send(UploadComplete response);

}
