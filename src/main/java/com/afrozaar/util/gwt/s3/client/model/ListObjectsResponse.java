package com.afrozaar.util.gwt.s3.client.model;

import com.google.gwt.core.shared.GWT;

public final class ListObjectsResponse implements IListObjectsResponse {

    @Override
    public void respond(String error, ObjectListing data) {
        GWT.log(error);
        GWT.log(String.valueOf(data.maxKeys));
        //GWT.log(data.toString());
    }

}
