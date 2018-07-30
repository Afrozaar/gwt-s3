package com.afrozaar.util.gwt.s3.client;

import jsinterop.annotations.JsProperty;

public class Options {

    @JsProperty
    public String accessKeyId;
    @JsProperty
    public String secretAccessKey;
    @JsProperty
    public String region;
    @JsProperty
    public Boolean useAccelerateEndpoint;

    public Options(String accessKeyId, String secretAccessKey, String region) {
        super();
        this.accessKeyId = accessKeyId;
        this.secretAccessKey = secretAccessKey;
        this.region = region;
    }

    public void setUseAccelerateEndpoint(Boolean useAccelerateEndpoint) {
        this.useAccelerateEndpoint = useAccelerateEndpoint;
    }

}
