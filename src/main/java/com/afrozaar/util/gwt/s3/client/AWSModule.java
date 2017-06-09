package com.afrozaar.util.gwt.s3.client;

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
    S3 getS3(Resources resources, AWSFactory s3Factory, AWS aws) {
        return s3Factory.createS3(aws);
    }

    @Provides
    @Singleton
    AWS getAWS(Resources resources, AWSFactory s3Factory) {
        return s3Factory.getAws();
    }

}
