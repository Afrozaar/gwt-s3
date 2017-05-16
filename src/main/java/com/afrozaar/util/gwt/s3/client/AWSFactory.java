package com.afrozaar.util.gwt.s3.client;

import com.google.gwt.core.client.ScriptInjector;
import com.google.inject.Inject;

public class AWSFactory {

    @Inject
    public AWSFactory(Resources resources) {
        ScriptInjector.fromString(resources.s3Js().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
    }

    public static native AWS getAws() /*-{
		console.log('aws = ', $wnd.AWS);
		return $wnd.AWS;
    }-*/;

    public native S3 createS3(AWS aws) /*-{
		return new aws.S3();
    }-*/;

    public native S3 createS3() /*-{
		return new $wnd.AWS.S3();
    }-*/;

}
