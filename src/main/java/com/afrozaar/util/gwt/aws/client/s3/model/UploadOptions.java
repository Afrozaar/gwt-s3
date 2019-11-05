package com.afrozaar.util.gwt.aws.client.s3.model;

import jsinterop.annotations.JsProperty;

/**
 * var options = {partSize: 10 * 1024 * 1024, queueSize: 1};
 * @author michael
 *
 */
public class UploadOptions {

    @JsProperty(name = "partSize")
    public native void setPartSize(int partSize);

    @JsProperty(name = "queueSize")
    public native void setQueueSize(int queueSize);

    public UploadOptions(int partSize, int queueSize) {
        super();
        setPartSize(partSize);
        setQueueSize(queueSize);
    }
}
