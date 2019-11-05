package com.afrozaar.util.gwt.aws.client.s3;

import com.afrozaar.util.gwt.aws.client.s3.model.IListObjectsResponse;
import com.afrozaar.util.gwt.aws.client.s3.model.ListObjectsRequest;
import com.afrozaar.util.gwt.aws.client.s3.model.ManagedUpload;
import com.afrozaar.util.gwt.aws.client.s3.model.SignedUrlParamsJs;
import com.afrozaar.util.gwt.aws.client.s3.model.UploadComplete;
import com.afrozaar.util.gwt.aws.client.s3.model.UploadOptions;
import com.afrozaar.util.gwt.aws.client.s3.model.UploadRequest;

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
    
    @JsMethod
    public native ManagedUpload upload(UploadRequest uploadRequest, UploadOptions options);

    /**
     * var params = {Bucket: 'bucket', Key: 'key', Expires: 60};
    var url = s3.getSignedUrl('getObject', params);
    console.log('The URL is', url); // expires in 60 seconds
     * @return
     */
    @JsMethod
    public native String getSignedUrl(String operation, SignedUrlParamsJs params);

    
}
