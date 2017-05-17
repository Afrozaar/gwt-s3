package com.afrozaar.util.gwt.s3.client;

import com.afrozaar.util.gwt.s3.client.model.IProgressListener;
import com.afrozaar.util.gwt.s3.client.model.ManagedUpload;
import com.afrozaar.util.gwt.s3.client.model.UploadComplete;
import com.afrozaar.util.gwt.s3.client.model.UploadRequest;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.inject.Inject;

import elemental.html.File;
import elemental.html.InputElement;

public class S3Upload {

    private S3 s3;

    @Inject
    public S3Upload(S3 s3) {
        this.s3 = s3;
    }

    public void upload(FileUpload fileUpload, String bucket, String key, IProgressListener progressListener, UploadComplete response) {
        InputElement element = (InputElement) fileUpload.getElement();
        //GWT.log("type = " + element.getFiles().item(0).getType());
        File item = element.getFiles().item(0);
        UploadRequest uploadRequest = new UploadRequest(bucket, key, item);
        uploadRequest.setContentType(item.getType());
        ManagedUpload upload = s3.upload(uploadRequest);
        upload.on("httpUploadProgress", progressListener);
        upload.send(response);
    }

    private native Object getFile(Element fu2) /*-{
		console.log('file element = ', fu2);
		return fu2.files;
    }-*/;

}
