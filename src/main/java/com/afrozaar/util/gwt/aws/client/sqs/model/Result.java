package com.afrozaar.util.gwt.aws.client.sqs.model;

import com.google.gwt.core.client.JavaScriptObject;

import elemental2.core.JsMap;
import jsinterop.annotations.JsProperty;

public final class Result {

    @JsProperty(name = "ResponseMetadata")
    public native final JsMap<String, String> getResponseMetaData();

}
