package patientcheckout.aws.lambda;
import com.amazonaws.services.lambda.runtime.events.S3Event;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PatientCheckoutLambda {
    private final AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
    private final AmazonSNS sns = AmazonSNSClientBuilder.defaultClient();
    ObjectMapper objectMapper = new ObjectMapper();
    public void handleRequest(S3Event event){

        event.getRecords().forEach(record ->
        {
            S3ObjectInputStream s3inputSteam= s3Client.
                    getObject(record.getS3().getBucket().getName(),record.getS3().getObject().getKey())
                    .getObjectContent();
            try {
                List<PatientEvent> patientEvents = Arrays.asList(objectMapper.readValue(s3inputSteam, PatientEvent[].class));
                System.out.println(patientEvents);
                patientEvents.forEach((patientEvent)->{
                    try {
                        sns.publish(System.getenv("PATEIENT_CHECKOUT_TOPIC"),objectMapper.writeValueAsString(patientEvent));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        });


    }
}
