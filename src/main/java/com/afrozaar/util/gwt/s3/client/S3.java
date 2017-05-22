package com.afrozaar.util.gwt.s3.client;

import com.afrozaar.util.gwt.s3.client.model.IListObjectsResponse;
import com.afrozaar.util.gwt.s3.client.model.ListObjectsRequest;
import com.afrozaar.util.gwt.s3.client.model.ManagedUpload;
import com.afrozaar.util.gwt.s3.client.model.SignedUrlParams;
import com.afrozaar.util.gwt.s3.client.model.UploadComplete;
import com.afrozaar.util.gwt.s3.client.model.UploadRequest;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "S3")
public class S3 {

    @JsMethod
    public native void listBuckets(IListBucketsResponse response);

    @JsMethod
    public native void listObjects(ListObjectsRequest request, IListObjectsResponse response);

    @JsMethod
    public native ManagedUpload upload(UploadRequest request, UploadComplete response);

    @JsMethod
    public native ManagedUpload upload(UploadRequest uploadRequest);

    /**
     * var params = {Bucket: 'bucket', Key: 'key', Expires: 60};
    var url = s3.getSignedUrl('getObject', params);
    console.log('The URL is', url); // expires in 60 seconds
     * @return
     */
    @JsMethod
    public native String getSignedUrl(String operation, SignedUrlParams params);

}
