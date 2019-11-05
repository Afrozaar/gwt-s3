package com.afrozaar.util.gwt.aws.client.sqs.model;

import jsinterop.annotations.JsFunction;

@JsFunction
@FunctionalInterface
public interface Response<T> {

    public void result(Object error, T data);
}
