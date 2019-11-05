package com.afrozaar.util.gwt.aws.client.s3.model;

import jsinterop.annotations.JsFunction;

@JsFunction
@FunctionalInterface
public interface IListObjectsResponse {

    public void respond(String error, ObjectListing data);
}
