package com.afrozaar.util.gwt.aws.client.sqs.model;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

import java.util.Collection;

import elemental2.core.JsArray;
import elemental2.core.JsMap;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * var params = {
  QueueUrl: 'STRING_VALUE', (required)
  AttributeNames: [
    All | Policy | VisibilityTimeout | MaximumMessageSize | MessageRetentionPeriod | ApproximateNumberOfMessages | ApproximateNumberOfMessagesNotVisible | CreatedTimestamp | LastModifiedTimestamp | QueueArn | ApproximateNumberOfMessagesDelayed | DelaySeconds | ReceiveMessageWaitTimeSeconds | RedrivePolicy | FifoQueue | ContentBasedDeduplication | KmsMasterKeyId | KmsDataKeyReusePeriodSeconds,
    ( more items )
  ],
  MaxNumberOfMessages: 'NUMBER_VALUE',
  MessageAttributeNames: [
    'STRING_VALUE',
    ( more items )
  ],
  ReceiveRequestAttemptId: 'STRING_VALUE',
  VisibilityTimeout: 'NUMBER_VALUE',
  WaitTimeSeconds: 'NUMBER_VALUE'
};
sqs.receiveMessage(params, function(err, data) {
  if (err) console.log(err, err.stack); // an error occurred
  else     console.log(data);           // successful response
});
 * @author michael
 *
 */

public class ReceiveMessage {

    public static class Request {
        public Request(String queueUrl) {
            setQueueUrl(queueUrl);
        }

        @JsProperty(name = "AttributeNames")
        public native void setAttributeNames0(JsArrayString names);

        @JsProperty(name = "QueueUrl")
        public native void setQueueUrl(String queueUrl);

        @JsProperty(name = "MaxNumberOfMessages")
        public native void setMaxNumberOfMessages(int messageNumber);

        @JsProperty(name = "MessageAttributeNames")
        public native void setMessageAttributeNames0(JsArrayString messageAttributeNames);

        public void setMessageAttributeNames(Collection<String> names) {
            setMessageAttributeNames0(toJsArray(names.toArray(new String[] {})));
        }

        @JsProperty(name = "ReceiveRequestAttemptId")
        public native void setReceiveRequestAttemptId(String requestId);

        @JsProperty(name = "VisibilityTimeout")
        public native void setVisibilityTimeout(int timeout);

        @JsProperty(name = "WaitTimeSeconds")
        public native void setWaitTimeSeconds(int seconds);

        public void setAttributeNames(String[] input) {
            setAttributeNames0(toJsArray(input));
        }

        public static JsArrayString toJsArray(String[] input) {
            JsArrayString jsArrayString = JsArrayString.createArray().cast();
            for (String s : input) {
                jsArrayString.push(s);
            }
            return jsArrayString;
        }
    }

    public static class Response {
        @JsProperty(name = "Messages")
        public native JsArray<Message> getMessages();
    }

    @JsFunction
    public interface Function {
        public void result(Object error, Response response);
    }

    @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
    public static final class Message {
        protected Message() {
        }

        @JsProperty(name = "MessageId")
        public native String getMessageId();

        @JsProperty(name = "ReceiptHandle")
        public native String getReceiptHandle();

        @JsProperty(name = "MD5OfBody")
        public native String getMD5OfBody();

        @JsProperty(name = "Body")
        public native String getBody();

        @JsProperty(name = "Attributes")
        public native JsMap<String, String> getAttributes();

        @JsProperty(name = "MD5OfMessageAttributes")
        public native String getMD5OfMessageAttributes();

        @JsProperty(name = "MessageAttributes")
        public native JsMap<String, String> getMessageAttributes();
    }
}
