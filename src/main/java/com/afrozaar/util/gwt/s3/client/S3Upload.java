package com.afrozaar.util.gwt.s3.client;

import com.afrozaar.util.gwt.s3.client.model.IProgressListener;
import com.afrozaar.util.gwt.s3.client.model.ManagedUpload;
import com.afrozaar.util.gwt.s3.client.model.UploadComplete;
import com.afrozaar.util.gwt.s3.client.model.UploadOptions;
import com.afrozaar.util.gwt.s3.client.model.UploadRequest;

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
        File file = element.getFiles().item(0);
        upload(file, bucket, key, progressListener, response);
    }

    public void upload(File file, String bucket, String key, IProgressListener progressListener, UploadComplete response) {
        upload(file, bucket, key, progressListener, response, null);
    }

    public void upload(File file, String bucket, String key, IProgressListener progressListener, UploadComplete response, UploadOptions uploadOptions) {
        UploadRequest uploadRequest = new UploadRequest(bucket, key, file);
        uploadRequest.setContentType(file.getType());
        ManagedUpload upload;
        if (uploadOptions != null) {
            upload = s3.upload(uploadRequest, uploadOptions);
        } else {
            upload = s3.upload(uploadRequest);
        }
        upload.on("httpUploadProgress", progressListener);
        upload.send(response);
    }

    private UploadOptions getUploadOptions(File file) {
        return new UploadOptions(5 * 1024, 4);
    }

    private native Object getFile(Element fu2) /*-{
                                               console.log('file element = ', fu2);
                                               return fu2.files;
                                               }-*/;

}
