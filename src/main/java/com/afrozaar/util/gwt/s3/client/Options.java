package com.afrozaar.util.gwt.s3.client;

import jsinterop.annotations.JsProperty;

public class Options {

    @JsProperty
    public String accessKeyId;
    @JsProperty
    public String secretAccessKey;

    public Options(String accessKeyId, String secretAccessKey) {
        super();
        this.accessKeyId = accessKeyId;
        this.secretAccessKey = secretAccessKey;
    }

}
