/*
 * Copyright 2010-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.afrozaar.util.gwt.s3.client.model;

import jsinterop.annotations.JsProperty;

/**
 * Contains the results of listing the objects in an Amazon S3 bucket.
 * This includes
 * a list of {@link S3ObjectSummary} objects describing the objects stored in
 * the bucket, a list of common prefixes if a delimiter was specified in the
 * request, information describing if this is a complete or partial
 * listing, and the original request parameters.
 * 
 * @see AmazonS3#listObjects(String, String)
 * @see AmazonS3#listObjects(ListObjectsRequest)
 * @see AmazonS3#listNextBatchOfObjects(ObjectListing)
 */
public class ObjectListing {

    /**
     * A list of the common prefixes included in this object listing - common
     * prefixes will only be populated for requests that specified a delimiter
     */
    @JsProperty(name = "CommonPrefixes")
    public String[] commonPrefixes;

    /** The name of the Amazon S3 bucket containing the listed objects */
    @JsProperty(name = "Bucket")
    public String bucketName;

    /**
     * The marker to use in order to request the next page of results - only
     * populated if the isTruncated member indicates that this object listing is
     * truncated
     */
    @JsProperty(name = "NextMarker")
    public String nextMarker;

    /**
     * Indicates if this is a complete listing, or if the caller needs to make
     * additional requests to Amazon S3 to see the full object listing for an S3
     * bucket
     */
    @JsProperty(name = "IsTruncated")
    public boolean isTruncated;

    /* Original Request Parameters */

    /**
     * The prefix parameter originally specified by the caller when this object
     * listing was returned
     */
    @JsProperty(name = "Prefix")
    public String prefix;

    /**
     * The marker parameter originally specified by the caller when this object
     * listing was returned
     */
    @JsProperty(name = "Marker")
    public String marker;

    /**
     * The maxKeys parameter originally specified by the caller when this object
     * listing was returned
     */
    @JsProperty(name = "MaxKeys")
    public int maxKeys;

    /**
     * The delimiter parameter originally specified by the caller when this
     * object listing was returned
     */
    @JsProperty(name = "Delimiter")
    public String delimiter;

    /**
     * The encodingType parameter originally specified by the caller when this
     * object listing was returned.
     */
    @JsProperty(name = "EncodingType")
    public String encodingType;

    @JsProperty(name = "Contents")
    public S3ObjectSummary[] contents;

}
