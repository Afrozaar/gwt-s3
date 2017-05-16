package com.afrozaar.util.gwt.s3.client;

import com.google.gwt.core.shared.GWT;

import jsinterop.annotations.JsFunction;

@JsFunction
public interface IListBucketsResponse {

    public void respond(String error, String data);
}

final class ListBucketResponse implements IListBucketsResponse {

    @Override
    public void respond(String error, String data) {
        GWT.log(error);
        GWT.log(data);
    }

}
