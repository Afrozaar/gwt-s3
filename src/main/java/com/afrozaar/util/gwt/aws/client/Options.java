package com.afrozaar.util.gwt.aws.client;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

public class Options {

    @JsProperty
    public String accessKeyId;
    @JsProperty
    public String secretAccessKey;
    @JsProperty
    public String region;
    @JsProperty
    public Boolean useAccelerateEndpoint;
    @JsProperty
    public Boolean correctClockSkew;

    public Options(String accessKeyId, String secretAccessKey, String region) {
        super();
        this.accessKeyId = accessKeyId;
        this.secretAccessKey = secretAccessKey;
        this.region = region;
        this.correctClockSkew = true;
    }

    public void setUseAccelerateEndpoint(Boolean useAccelerateEndpoint) {
        this.useAccelerateEndpoint = useAccelerateEndpoint;
    }


}
