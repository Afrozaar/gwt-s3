package com.afrozaar.util.gwt.aws.client.sqs.model;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsProperty;

public class SendMessage {

    /**
     * 
     * var params = {
    MessageBody: 'STRING_VALUE', ( required )
    QueueUrl: 'STRING_VALUE', ( required )
    DelaySeconds: 'NUMBER_VALUE',
    MessageAttributes: {
    '<String>': {
      DataType: 'STRING_VALUE', ( required )
      BinaryListValues: [
        Buffer.from('...') || 'STRING_VALUE' ( Strings will be Base-64 encoded on your behalf ),
        ( more items )
      ],
      BinaryValue: Buffer.from('...') || 'STRING_VALUE' ( Strings will be Base-64 encoded on your behalf ),
      StringListValues: [
        'STRING_VALUE',
        ( more items )
      ],
      StringValue: 'STRING_VALUE'
    },
    ( '<String>': ... )
    },
    MessageDeduplicationId: 'STRING_VALUE',
    MessageGroupId: 'STRING_VALUE',
    MessageSystemAttributes: {
    '<MessageSystemAttributeNameForSends>': {
      DataType: 'STRING_VALUE', ( required )
      BinaryListValues: [
        Buffer.from('...') || 'STRING_VALUE' ( Strings will be Base-64 encoded on your behalf ),
        ( more items )
      ],
      BinaryValue: Buffer.from('...') || 'STRING_VALUE' ( Strings will be Base-64 encoded on your behalf ),
      StringListValues: [
        'STRING_VALUE',
        ( more items )
      ],
      StringValue: 'STRING_VALUE'
    },
    ( '<MessageSystemAttributeNameForSends>': ... )
    }
    };
    sqs.sendMessage(params, function(err, data) {
    if (err) console.log(err, err.stack); // an error occurred
    else     console.log(data);           // successful response
    });
     * @author michael
     *
     */
    public static class Request {

        @JsProperty(name = "MessageBody")
        public native void setBody(String body);

        @JsProperty(name = "QueueUrl")
        public native void setQueueUrl(String queueUrl);

        @JsProperty(name = "DelaySeconds")
        public native void setDelaySeconds(int delaySeconds);

        public Request(String queueUrl, String body) {
            setQueueUrl(queueUrl);
            setBody(body);
        }

        /*
        * MessageAttributes, MessageDeduplicationId,MessageGroupId,MessageSystemAttributes all ommitted as I did not need them 
        */

    }

    public static class Response {
        @JsProperty(name = "MD5OfMessageBody")
        public native String getMD5OfMessageBody();

        @JsProperty(name = "MD5OfMessageAttributes")
        public native String getMD5OfMessageAttributes();

        @JsProperty(name = "MD5OfMessageSystemAttributes")
        public native String getMD5OfMessageSystemAttributes();

        @JsProperty(name = "MessageId")
        public native String getMessageId();

        @JsProperty(name = "SequenceNumber")
        public native String getSequenceNumber();

    }

    @JsFunction
    public interface Function {
        public void result(Object error, Response data);
    }
}
