package com.afrozaar.util.gwt.aws.client.s3.model;

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
