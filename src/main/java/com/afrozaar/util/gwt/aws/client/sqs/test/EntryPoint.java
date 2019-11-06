package com.afrozaar.util.gwt.aws.client.sqs.test;

import com.afrozaar.util.gwt.aws.client.AWS;
import com.afrozaar.util.gwt.aws.client.Options;
import com.afrozaar.util.gwt.aws.client.sqs.SQS;
import com.afrozaar.util.gwt.aws.client.sqs.model.GetQueueAttributes;
import com.afrozaar.util.gwt.aws.client.sqs.model.GetQueueUrl;
import com.afrozaar.util.gwt.aws.client.sqs.model.GetQueueUrlRequest;

import com.google.gwt.core.client.GWT;

public class EntryPoint implements com.google.gwt.core.client.EntryPoint {

    private String accessKey = "AKIAJ42HWPLJBS75XNWQ";
    private String secret = "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";
    private String region = "eu-west-1";

    @Override
    public void onModuleLoad() {
        GWT.log("startup changed");
        final Options options = new Options(accessKey, secret, region);
        AWS aws = Injector.INSTANCE.getAWS();
        aws.config.update(options);

        SQS sqs = Injector.INSTANCE.getSqs();
        GWT.log(sqs + "");

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
        sqs.getQueueUrl(new GetQueueUrlRequest("queue-test-from-js-2"), (error, data) -> {
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
