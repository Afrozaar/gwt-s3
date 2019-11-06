package com.afrozaar.util.gwt.aws.client;

import com.afrozaar.util.gwt.aws.client.s3.S3;
import com.afrozaar.util.gwt.aws.client.sqs.SQS;

import com.google.gwt.core.client.ScriptInjector;

import com.google.inject.Inject;

public class AWSFactory {

    @Inject
    public AWSFactory(Resources resources) {
        ScriptInjector.fromString(resources.awsJs().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
    }

    public static native AWS getAws() /*-{
		console.log('aws = ', $wnd.AWS);
		return $wnd.AWS;
    }-*/;

    public native S3 createS3(AWS aws) /*-{
		return new aws.S3();
    }-*/;
    
    public native SQS createSqs(AWS aws) /*-{
        sqs = new aws.SQS(aws.config);
        console.log('sqs = ', sqs);
    return sqs;
}-*/;

    public native S3 createS3() /*-{
		return new $wnd.AWS.S3();
    }-*/;

}
