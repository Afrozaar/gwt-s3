package com.afrozaar.util.gwt.aws.client;

import com.afrozaar.util.gwt.aws.client.s3.S3;
import com.afrozaar.util.gwt.aws.client.s3.S3Upload;
import com.afrozaar.util.gwt.aws.client.sqs.SQS;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.AbstractGinModule;

import com.google.inject.Provides;
import com.google.inject.Singleton;

public class AWSModule extends AbstractGinModule {

    @Override
    protected void configure() {

        bind(Resources.class).asEagerSingleton();
        bind(AWSFactory.class).asEagerSingleton();
        bind(S3Upload.class);

    }

    @Provides
    S3 getS3(Resources resources, AWSFactory factory, AWS aws) {
        return factory.createS3(aws);
    }
    
    @Provides
    SQS getSQS(Resources resources, AWSFactory factory, AWS aws) {
        GWT.log("creating sqs with "+aws.config);
        return factory.createSqs(aws);
    }

    @Provides
    @Singleton
    AWS getAWS(Resources resources, AWSFactory s3Factory) {
        return AWSFactory.getAws();
    }

}
