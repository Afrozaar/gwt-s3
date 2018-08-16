package com.afrozaar.util.gwt.s3.client.test;

import com.afrozaar.util.gwt.s3.client.AWS;
import com.afrozaar.util.gwt.s3.client.Options;
import com.afrozaar.util.gwt.s3.client.S3Upload;
import com.afrozaar.util.gwt.s3.client.model.IProgressListener;
import com.afrozaar.util.gwt.s3.client.model.UploadComplete;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class UploadManual {

    private FileUpload fu;
    private Injector injector;

    public void startupAndTest() {
        injector = Injector.INSTANCE;
        GWT.log(injector.toString());

        final Options options = new Options("<PUT ACCESS KEY HERE>", "<PUT SECRET KEY HERE>", "eu-west-1");

        final AWS aws = injector.getAWS();
        aws.config.update(options);

        createUi();
    }

    private void sendClicked(ClickEvent event) {
        final IProgressListener progressListener = progress -> GWT.log(progress.getLoaded() + " : " + progress.getTotal());
        final UploadComplete response = (error, data) -> {
            GWT.log(error);
            GWT.log(data.getBucket() + ", " + data.getETag() + ", " + data.getKey() + ", " + data.getLocation());
        };
        final String key = "data.blob";
        final String bucket = "mike-baobab-eu-west-2";

        GWT.log("Send clicked");

        final S3Upload s3Upload = injector.getS3Upload();
        s3Upload.upload(fu, bucket, key, progressListener, response, false);

    }

    private void createUi() {
        final Button sendButton = new Button("Send");
        sendButton.addClickHandler(this::sendClicked);
        fu = new FileUpload();

        fu.getElement().setAttribute("accept", "image/*, video/*, audio/*");
        final VerticalPanel panel = new VerticalPanel();
        panel.add(sendButton);
        panel.add(fu);

        RootPanel.get().add(panel);

    }

}
