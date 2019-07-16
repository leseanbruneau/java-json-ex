package com.leseanbruneau;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MainJsonToCsvApp {

	public static void main(String[] args) throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		InputStream fileInputStream = new FileInputStream("/home/oak/temp/JSONInputFile.json");
		RaceResultBean[] raceResultsList = mapper.readValue(fileInputStream, RaceResultBean[].class);
		fileInputStream.close();
		
		OutputStream fileOutputStream = new FileOutputStream("/home/oak/temp/CSVOutputFile.csv");
		
		for(RaceResultBean raceResult : raceResultsList) {
			
			String raceLine = raceResult.getRaceDate() + "," + raceResult.getsDay() + "," + raceResult.getRaceNum() + 
					"," + raceResult.getType() + "," + raceResult.getSurface() + "," + raceResult.getDistLen() +  
					"," + raceResult.getDistMea() + "," + raceResult.getPurse() + "," + raceResult.getNumHorses() + 
					"," + raceResult.getFin1() + "," + raceResult.getPrgNum1() + "," + raceResult.getPpNum1() + 
					"," + raceResult.getfOdds1() + "," + raceResult.getpTFav1() + 
					"," + raceResult.getFin2() + "," + raceResult.getPrgNum2() + "," + raceResult.getPpNum2() + 
					"," + raceResult.getfOdds2() + "," + raceResult.getpTFav2() + 
					"," + raceResult.getFin3() + "," + raceResult.getPrgNum3() + "," + raceResult.getPpNum3() + 
					"," + raceResult.getfOdds3() + "," + raceResult.getpTFav3() + 
					"," + raceResult.getFin4() + "," + raceResult.getPrgNum4() + "," + raceResult.getPpNum4() + 
					"," + raceResult.getfOdds4() + "," + raceResult.getpTFav4() + "\n";
			
			fileOutputStream.write(raceLine.getBytes());
		}
		
		fileOutputStream.close();
		
		System.out.println("CSV Output File Generated");
		

	}

}
