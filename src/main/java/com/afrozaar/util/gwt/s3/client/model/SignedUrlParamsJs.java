package com.afrozaar.util.gwt.s3.client.model;

import com.google.gwt.core.client.JavaScriptObject;

public class SignedUrlParamsJs extends JavaScriptObject {

    protected SignedUrlParamsJs() {

    }

    public static native SignedUrlParamsJs create(String bucket, String key, int expires) /*-{
		return {
			Key : key,
			Bucket : bucket,
			Expires : expires
		};
    }-*/;

}
