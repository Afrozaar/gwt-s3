package com.afrozaar.util.gwt.s3.client.test;

import com.afrozaar.util.gwt.aws.client.AWS;
import com.afrozaar.util.gwt.aws.client.AWSS3Module;
import com.afrozaar.util.gwt.aws.client.s3.S3;
import com.afrozaar.util.gwt.aws.client.s3.S3Upload;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(AWSS3Module.class)
public interface Injector extends Ginjector {
    public static final Injector INSTANCE = GWT.create(Injector.class);

    public S3 getS3();

    public AWS getAWS();

    public S3Upload getS3Upload();

}