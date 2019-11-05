package com.afrozaar.util.gwt.aws.client.sqs.test;

import com.afrozaar.util.gwt.aws.client.AWS;
import com.afrozaar.util.gwt.aws.client.AWSModule;
import com.afrozaar.util.gwt.aws.client.s3.S3;
import com.afrozaar.util.gwt.aws.client.s3.S3Upload;
import com.afrozaar.util.gwt.aws.client.sqs.SQS;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(AWSModule.class)
public interface Injector extends Ginjector {
    public static final Injector INSTANCE = GWT.create(Injector.class);

    public S3 getS3();

    public SQS getSqs();

    public AWS getAWS();

    public S3Upload getS3Upload();

}