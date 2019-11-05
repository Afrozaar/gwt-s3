package com.afrozaar.util.gwt.aws.client.sqs.test;

import com.afrozaar.util.gwt.aws.client.AWSModule;

import com.google.gwt.inject.client.AbstractGinModule;

public class ClientModule extends AbstractGinModule {
    protected void configure() {
        install(new AWSModule());
    }
}