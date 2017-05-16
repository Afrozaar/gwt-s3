package com.afrozaar.util.gwt.s3.client;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;

public class AWSModule extends AbstractGinModule {

    @Override
    protected void configure() {

        bind(Resources.class).asEagerSingleton();
        bind(AWSFactory.class).asEagerSingleton();
        bind(S3Upload.class);

    }

    @Provides
    S3 getS3(Resources resources, AWSFactory s3Factory, AWS aws) {
        return s3Factory.createS3(aws);
    }

    @Provides
    AWS getAWS(Resources resources, AWSFactory s3Factory) {
        return s3Factory.getAws();
    }

}
