package com.afrozaar.util.gwt.aws.client.s3.model;

import jsinterop.annotations.JsProperty;

public class ListObjectsRequest {

    //Bucket: 'STRING_VALUE', /* required */
    @JsProperty(name = "Bucket")
    private String bucket;

    //ContinuationToken: 'STRING_VALUE',
    @JsProperty(name = "ContinuatonToken")
    private String continuationToken;

    //Delimiter: 'STRING_VALUE',
    @JsProperty(name = "Delimiter")
    private String delimiter;

    //EncodingType: url,
    @JsProperty(name = "EncodingType")
    private String encodingType;

    //FetchOwner: true || false,
    @JsProperty(name = "FetchOwner")
    private boolean fetchOwner;

    //MaxKeys: 0,
    @JsProperty(name = "MaxKeys")
    private int maxKeys = 10;

    //Prefix: 'STRING_VALUE',
    @JsProperty(name = "Prefix")
    private String prefix;

    //Marker: 'STRING_VALUE',
    @JsProperty(name = "Marker")
    private String marker;

    //RequestPayer: requester,
    //StartAfter: 'STRING_VALUE'

    @JsProperty(name = "StartAfter")
    private String startAfter;

    public ListObjectsRequest(String bucket) {
        super();
        this.bucket = bucket;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getContinuationToken() {
        return continuationToken;
    }

    public void setContinuationToken(String continuationToken) {
        this.continuationToken = continuationToken;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getEncodingType() {
        return encodingType;
    }

    public void setEncodingType(String encodingType) {
        this.encodingType = encodingType;
    }

    public boolean isFetchOwner() {
        return fetchOwner;
    }

    public void setFetchOwner(boolean fetchOwner) {
        this.fetchOwner = fetchOwner;
    }

    public int getMaxKeys() {
        return maxKeys;
    }

    public void setMaxKeys(int maxKeys) {
        this.maxKeys = maxKeys;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public String getStartAfter() {
        return startAfter;
    }

    public void setStartAfter(String startAfter) {
        this.startAfter = startAfter;
    }

}
