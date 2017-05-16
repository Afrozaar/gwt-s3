package com.afrozaar.util.gwt.s3.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface Resources extends ClientBundle {

    @Source("aws-sdk-2.51.0.min.js")
    TextResource s3Js();

}
