package helloworld;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;

public class DataTypesDemo {
	public Integer getNumber(float number) {
		return (int) number;
	}
	
	public boolean checkEvenNumber(int number) {
		return (number%2==0);
	}
	
	public List<Integer> getScores(List<String> names){
		HashMap<String, Integer> students = new HashMap<>();
		students.put("Alex", 87);
		students.put("Steve", 77);
		students.put("Sam", 97);
		
		List<Integer> result = new ArrayList<Integer>();
		names.forEach(a-> {
			result.add(students.get(a));
		});
		return result;
	}
	
	public void getStream(InputStream input,OutputStream output,Context context) throws IOException {
		int data;
		while((data=input.read()) != -1) {
			output.write(Character.toLowerCase(data));
		}
	}

}
