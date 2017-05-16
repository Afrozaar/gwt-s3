package com.afrozaar.util.gwt.s3.client;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

@JsType(isNative = true)
public class Config {

    @JsMethod
    public native void update(Options options);
}
