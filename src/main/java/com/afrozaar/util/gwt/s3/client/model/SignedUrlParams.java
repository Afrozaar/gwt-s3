package com.afrozaar.util.gwt.s3.client.model;

import jsinterop.annotations.JsProperty;

public class SignedUrlParams {

    @JsProperty(name = "Expires")
    private String expires;

    public SignedUrlParams(String expires) {
        super();
        this.expires = expires;
    }

}
