package com.afrozaar.util.gwt.aws.client.sqs;

import com.afrozaar.util.gwt.aws.client.sqs.model.CreateQueueRequest;
import com.afrozaar.util.gwt.aws.client.sqs.model.DeleteMessageRequest;
import com.afrozaar.util.gwt.aws.client.sqs.model.DeleteQueueRequest;
import com.afrozaar.util.gwt.aws.client.sqs.model.GetQueueUrlRequest;
import com.afrozaar.util.gwt.aws.client.sqs.model.GetQueueUrlResponse;
import com.afrozaar.util.gwt.aws.client.sqs.model.Params;
import com.afrozaar.util.gwt.aws.client.sqs.model.Response;
import com.afrozaar.util.gwt.aws.client.sqs.model.Result;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "SQS")
public class SQS {

    @JsMethod
    public native void getQueueAttributes(Params params, Response<Result> result);

    @SuppressWarnings("unusable-by-js")
    @JsMethod
    public native void deleteMessage(DeleteMessageRequest request, Response<Result> result);

    @SuppressWarnings("unusable-by-js")
    @JsMethod
    public native void createQueue(CreateQueueRequest request, Response<Result> result);

    @SuppressWarnings("unusable-by-js")
    @JsMethod
    public native void deleteQueue(DeleteQueueRequest request, Response<Result> result);

    @JsMethod
    public native void getQueueUrl(GetQueueUrlRequest request, Response<GetQueueUrlResponse> result);

}