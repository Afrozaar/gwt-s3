package com.afrozaar.util.gwt.s3.client.model;

import elemental.html.File;
import jsinterop.annotations.JsProperty;

public class UploadRequest {

    @JsProperty(name = "Bucket")
    private String bucket;

    @JsProperty(name = "Key")
    private String key;

    @JsProperty(name = "Body")
    private File object;

    public UploadRequest(String bucket, String key, File object) {
        super();
        this.bucket = bucket;
        this.key = key;
        this.object = object;
    }

}
