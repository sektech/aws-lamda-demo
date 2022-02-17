package patientcheckout.aws.lambda;

import java.io.IOException;

import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BillManagementLambda {
	private  ObjectMapper objectmapper = new ObjectMapper();
	
	public void handleRequest(SNSEvent event) {
		event.getRecords().forEach(snsRecord->{
			try {
				PatientEvent readValue = objectmapper.readValue(snsRecord.getSNS().getMessage(), PatientEvent.class);
				System.out.println(readValue);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

}
