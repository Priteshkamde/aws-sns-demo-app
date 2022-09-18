package com.awsprojects.snsdemo.controller;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmazonSNSController {

    @Autowired
    private AmazonSNSClient amazonSNSClient;

    private String TOPIC_ARN = "arn:aws:sns:us-east-1:545526566629:my-sns-topic";

    @GetMapping("/subscribe/{emailId}")
    private String subscribeToSNSTopic(
            @PathVariable("emailId")
            String emailId) {

        SubscribeRequest subscribeRequestForTopic = new SubscribeRequest(TOPIC_ARN,"email",emailId);
        amazonSNSClient.subscribe(subscribeRequestForTopic);

        return "check your mail box ✉";
    }

    @GetMapping("/publish/{messageToPublish}")
    public String publishToSNSTopic(
            @PathVariable("messageToPublish")
        String messageToPublish) {

        PublishRequest publishRequestToSNS = new PublishRequest(TOPIC_ARN, messageToPublish, "Welcome To SNS");
        amazonSNSClient.publish(publishRequestToSNS);

        return "message published";
    }


}
