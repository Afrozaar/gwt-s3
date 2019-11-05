package com.afrozaar.util.gwt.aws.client.s3.model;

import java.util.Date;

import elemental.html.File;
import jsinterop.annotations.JsProperty;

public class UploadRequest {

    @JsProperty(name = "ACL")
    public native void setAcl(String acl);

    @JsProperty(name = "Bucket")
    public native void setBucket(String bucket);

    @JsProperty(name = "Key")
    public native void setKey(String key);

    @JsProperty(name = "Body")
    public native void setFile(File file);

    @JsProperty(name = "CacheControl")
    public native void setCacheControl(String cacheControl);

    @JsProperty(name = "ContentDisposition")
    public native void setContentDisposition(String contentDisposition);

    @JsProperty(name = "ContentEncoding")
    public native void setContentEncoding(String contentEncoding);

    @JsProperty(name = "ContentLanguage")
    public native void setContentLanguage(String contentLanguage);

    @JsProperty(name = "ContentLength")
    public native void setContentLength(int contentLength);

    @JsProperty(name = "ContentMD5")
    public native void setContentMD5(String contentMD5);

    @JsProperty(name = "ContentType")
    public native void setContentType(String contentType);

    @JsProperty(name = "Expires")
    public native void setExpires(Date expires);

    @JsProperty(name = "GrantFullControl")
    public native void setGrantFullControl(String grantFullControl);

    @JsProperty(name = "GrantRead")
    public native void setGrantRead(String grantRead);

    @JsProperty(name = "GrantReadACP")
    public native void setGrantReadACP(String grantReadACP);

    @JsProperty(name = "GrantWriteACP")
    public native void setGrantWriteACP(String grantWriteACP);

    public UploadRequest(String bucket, String key, File object) {
        super();
        setBucket(bucket);
        setKey(key);
        setFile(object);
    }

}
