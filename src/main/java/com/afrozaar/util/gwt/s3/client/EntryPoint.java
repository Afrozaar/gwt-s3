package com.afrozaar.util.gwt.s3.client;

import com.afrozaar.util.gwt.s3.client.test.UploadManual;

import com.google.gwt.core.shared.GWT;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class EntryPoint implements com.google.gwt.core.client.EntryPoint {

    /**
     * This is the entry point method.
     */
    @Override
    public void onModuleLoad() {
        UploadManual create = GWT.create(UploadManual.class);
        create.startupAndTest();

    }
}
