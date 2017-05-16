package com.afrozaar.util.gwt.s3.client;

import com.afrozaar.util.gwt.s3.client.model.UploadComplete;
import com.afrozaar.util.gwt.s3.client.model.IProgressListener;
import com.afrozaar.util.gwt.s3.client.model.ManagedUpload;
import com.afrozaar.util.gwt.s3.client.model.UploadRequest;
import com.afrozaar.util.gwt.s3.client.test.Injector;
import com.afrozaar.util.gwt.s3.client.test.UploadManual;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import elemental.html.InputElement;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class EntryPoint implements com.google.gwt.core.client.EntryPoint {

    /**
     * Create a remote service proxy to talk to the server-side Greeting service.
     */

    private FileUpload fu;
    private Injector injector;

    /**
     * This is the entry point method.
     */
    @Override
    public void onModuleLoad() {
        UploadManual create = GWT.create(UploadManual.class);
        create.startupAndTest();

    }
}
