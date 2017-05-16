/*
 * Copyright 2010-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

import java.io.Serializable;
import java.util.Date;

import jsinterop.annotations.JsProperty;

/**
 * Contains the summary of an object stored in an Amazon S3 bucket. This object
 * doesn't contain contain the
 * object's full metadata or any of its contents.
 * 
 * @see S3Object
 */
public class S3ObjectSummary implements Serializable {

    /** Hex encoded MD5 hash of this object's contents, as computed by Amazon S3 */
    @JsProperty(name = "ETag")
    public String eTag;

    /** The size of this object, in bytes */
    @JsProperty(name = "Size")
    public long size;

    /** The date, according to Amazon S3, when this object was last modified */
    @JsProperty(name = "LastModified")
    public Date lastModified;

    /** The class of storage used by Amazon S3 to store this object */
    @JsProperty(name = "StorageClass")
    public String storageClass;

    @JsProperty(name = "Key")
    public native String getKey();

}
