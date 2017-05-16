package com.afrozaar.util.gwt.s3.client.model;

import jsinterop.annotations.JsFunction;

@JsFunction
@FunctionalInterface
public interface IListObjectsResponse {

    public void respond(String error, ObjectListing data);
}
