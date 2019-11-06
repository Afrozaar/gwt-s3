package com.afrozaar.util.gwt.aws.client.sqs;

import com.afrozaar.util.gwt.aws.client.sqs.model.CreateQueue;
import com.afrozaar.util.gwt.aws.client.sqs.model.DeleteMessage;
import com.afrozaar.util.gwt.aws.client.sqs.model.DeleteQueue;
import com.afrozaar.util.gwt.aws.client.sqs.model.GetQueueAttributes;
import com.afrozaar.util.gwt.aws.client.sqs.model.GetQueueUrl;
import com.afrozaar.util.gwt.aws.client.sqs.model.ReceiveMessage;
import com.afrozaar.util.gwt.aws.client.sqs.model.Response;
import com.afrozaar.util.gwt.aws.client.sqs.model.SendMessage;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "SQS")
public class SQS {

    @JsMethod
    public native void getQueueAttributes(GetQueueAttributes.Request request, GetQueueAttributes.Function result);

    @JsMethod
    public native void deleteMessage(DeleteMessage.Request request, DeleteMessage.Function result);

    @JsMethod
    public native void createQueue(CreateQueue.Request request, CreateQueue.Function result);

    @JsMethod
    public native void deleteQueue(DeleteQueue.Request request, DeleteQueue.Function result);

    @JsMethod
    public native void getQueueUrl(GetQueueUrl.Request request, GetQueueUrl.Function result);

    @JsMethod
    public native void receiveMessage(ReceiveMessage.Request request, ReceiveMessage.Function response);

    @JsMethod
    public native void sendMessage(SendMessage.Request request, SendMessage.Function response);

}