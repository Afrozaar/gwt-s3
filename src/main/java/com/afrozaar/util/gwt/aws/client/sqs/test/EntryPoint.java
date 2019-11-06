package com.afrozaar.util.gwt.aws.client.sqs.test;

import com.afrozaar.util.gwt.aws.client.AWS;
import com.afrozaar.util.gwt.aws.client.Options;
import com.afrozaar.util.gwt.aws.client.sqs.SQS;
import com.afrozaar.util.gwt.aws.client.sqs.model.CreateQueue;
import com.afrozaar.util.gwt.aws.client.sqs.model.DeleteMessage;
import com.afrozaar.util.gwt.aws.client.sqs.model.DeleteQueue;
import com.afrozaar.util.gwt.aws.client.sqs.model.GetQueueAttributes;
import com.afrozaar.util.gwt.aws.client.sqs.model.GetQueueUrl;
import com.afrozaar.util.gwt.aws.client.sqs.model.ReceiveMessage;
import com.afrozaar.util.gwt.aws.client.sqs.model.ReceiveMessage.Message;
import com.afrozaar.util.gwt.aws.client.sqs.model.Result;
import com.afrozaar.util.gwt.aws.client.sqs.model.SendMessage;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;

import java.util.HashMap;
import java.util.Map;

import elemental2.core.JsArray;

public class EntryPoint implements com.google.gwt.core.client.EntryPoint {

    private String accessKey = "AKIAJ42HWPLJBS75XNWQ";
    private String secret = "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";
    private String region = "eu-west-1";
    private SQS sqs;

    @Override
    public void onModuleLoad() {
        GWT.log("startup changed");
        final Options options = new Options(accessKey, secret, region);
        AWS aws = Injector.INSTANCE.getAWS();
        aws.config.update(options);

        sqs = Injector.INSTANCE.getSqs();
        GWT.log(sqs + "");

        Object eval = eval("{\"x\":20}");
        GWT.log("evaluated " + eval.toString());
        log(eval);
        Callback<String, Object> callback = new Callback<String, Object>() {

            @Override
            public void onFailure(Object reason) {
                log(reason);
            }

            @Override
            public void onSuccess(String queueUrl) {
                listenOnQueue(queueUrl);

                addToQueue(queueUrl);

                Timer t = new Timer() {

                    @Override
                    public void run() {
                        deleteQueue(queueUrl);
                    }
                };
                //t.schedule(5000);
            }
        };
        createQueue(callback);

    }

    private native Object eval(String string) /*-{
		return JSON.parse(string);
    }-*/;

    private void deleteQueue(String queueUrl) {
        sqs.deleteQueue(new DeleteQueue.Request(queueUrl), new DeleteQueue.Function() {

            @Override
            public void result(Object error, Result data) {
                if (error == null) {
                    GWT.log("queue deleted " + data.toString());
                }

            }
        });

    }

    private void addToQueue(String queueUrl) {
        sqs.sendMessage(new SendMessage.Request(queueUrl, "this is a queue element"), (error, data) -> GWT.log("message sent with id "
                + data.getMessageId()));

    }

    private void listenOnQueue(String queueUrl) {
        Timer[] trray = new Timer[] {};
        Timer t = new Timer() {

            @Override
            public void run() {
                GWT.log("receiving messages");
                sqs.receiveMessage(new ReceiveMessage.Request(queueUrl), new ReceiveMessage.Function() {

                    @Override
                    public void result(Object error, ReceiveMessage.Response response) {
                        if (error != null) {
                            GWT.log("error reading from queue " + error.toString());
                            log(error);
                            return;
                        }
                        JsArray<Message> messages = response.getMessages();
                        if (messages.length > 0) {
                            Message o = messages.getAt(0);
                            log(o);
                            GWT.log("hello message receioved = " + o.getBody());
                            
                            String receiptHandle = o.getReceiptHandle();
                            GWT.log("receitp handle = "+receiptHandle);
                            
                            
                            sqs.deleteMessage(new DeleteMessage.
                                    Request(queueUrl, 
                                            receiptHandle), 
                                    new DeleteMessage.Function() {
                                
                                @Override
                                public void result(Object err, Result data) {
                                    if (err == null) {
                                        GWT.log("deleted message " + o.getReceiptHandle());
                                    }
                                }
                            });
                        } else {
                            GWT.log("received 0 messages");
                        }

                        trray[0].schedule(0);
                    }
                });
            }
        };
        trray[0] = t;
        t.schedule(0);
    }

    private void createQueue(Callback<String, Object> callback) {
        int nextInt = Random.nextInt();
        Map<String, Object> map = new HashMap<>();
        map.put("ReceiveMessageWaitTimeSeconds", "20");
        sqs.createQueue(new CreateQueue.Request("js-java-gwt-sdk-test-" + nextInt, map), (error, response) -> {
            if (error == null) {
                callback.onSuccess(response.getQueueUrl());
            } else {
                callback.onFailure(error);
            }
        });
    }

    private void getQueueAttributes(SQS sqs) {
        GetQueueAttributes.Request request = new GetQueueAttributes.Request();
        request.setAttributeNames(new String[] { "All" });
        request.setQueueUrl("https://sqs.eu-west-1.amazonaws.com/358035155708/-environment-ashes-deploy-web-publish-slot-retry.fifo");

        sqs.getQueueAttributes(request, new GetQueueAttributes.Function() {

            @Override
            public void response(Object error, GetQueueAttributes.Response data) {
                GWT.log("erorr on get queue attributes");
                log(error);
                GWT.log("data on get queue attributes");
                log(data.getAttributes());

            }
        });
    }

    private void deleteQueue(SQS sqs) {
        GetQueueUrl.Request r = new GetQueueUrl.Request("queue-test-from-js-2");
        //r.setQueueName();
        sqs.getQueueUrl(r, new GetQueueUrl.Function() {

            @Override
            public void result(Object error, GetQueueUrl.Response data) {
                log(error);
                log(data);
                GWT.log("queue url = " + data.getQueueUrl());
                if (error == null) {
                    /*sqs.deleteQueue(data.getQueueUrl(), new Response<Result>() {
                    
                        @Override
                        public void result(Object error, Result data) {
                            log(error);
                            log(data);
                            if (error == null) {
                                GWT.log("queue deleted");
                                log(data);
                            }
                    
                        }
                    });
                    */
                }
            }
        });
    }

    private void getQueueUrl(SQS sqs) {
        GWT.log("get Queue url");
        sqs.getQueueUrl(new GetQueueUrl.Request("queue-test-from-js-2"), (error, data) -> {
            log(error);
            log(data);
            GWT.log("queu eurl = " + data.getQueueUrl());
        });

    }

    /*    private void createQueue(SQS sqs) {
        Map<String, String> map = new HashMap<>();
    
        map.put("MessageRetentionPeriod", "120");
        map.put("ReceiveMessageWaitTimeSeconds", "20");
    
        sqs.createQueue(new CreateQueueRequest("queue-test-from-js-2", map), new Response() {
    
            @Override
            public <T> void result(Object error, T t) {
                log(error);
                log(t);
                Result data = (Result) t;
                GWT.log("queue url = " + data.getQueueUrl());
                JsMap<String, String> responseMetaData = data.getResponseMetaData();
    
                JsIteratorIterable<EntriesJsIteratorIterableTypeParameterArrayUnionType<String, String>[]> entries = responseMetaData
                        .entries();
    
                JsIIterableResult<EntriesJsIteratorIterableTypeParameterArrayUnionType<String, String>[]> next;
                do {
                    next = entries.next();
                    if (!next.isDone()) {
                        EntriesJsIteratorIterableTypeParameterArrayUnionType<String, String>[] value = next.getValue();
                        GWT.log(value[0] + " = " + value[1]);
                    }
                } while (!next.isDone());
    
                GWT.log("response meta Data = " + responseMetaData);
    
            }
        });
    }
    
    private void createQueue(SQS sqs, Map<String, String> map) {
        map.put("ReceiveMessageWaitTimeSeconds", "20");
    
        sqs.createQueue(new CreateQueueRequest("queue-test-from-js-2", map), new Response() {
    
            @Override
            public <T> void result(Object error, T t) {
                log(error);
                Result data = (Result) t;
                log(data);
                GWT.log("queue url = " + data.getQueueUrl());
                JsMap<String, String> responseMetaData = data.getResponseMetaData();
    
                JsIteratorIterable<EntriesJsIteratorIterableTypeParameterArrayUnionType<String, String>[]> entries = responseMetaData
                        .entries();
    
                JsIIterableResult<EntriesJsIteratorIterableTypeParameterArrayUnionType<String, String>[]> next;
                do {
                    next = entries.next();
                    if (!next.isDone()) {
                        EntriesJsIteratorIterableTypeParameterArrayUnionType<String, String>[] value = next.getValue();
                        GWT.log(value[0] + " = " + value[1]);
                    }
                } while (!next.isDone());
    
                GWT.log("response meta Data = " + responseMetaData);
    
            }
        });
    }
    */
    public native void log(Object object) /*-{
		console.log(object);
    }-*/;

}
