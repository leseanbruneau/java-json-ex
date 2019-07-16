package com.leseanbruneau;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class MainCsvToJsonApp {

	public static void main(String[] args) throws IOException {
		
		String line = "";
		String[] raceData = new String[29];
		RaceResultBean horseRace = new RaceResultBean();
		List<RaceResultBean> horseRaces = new ArrayList<RaceResultBean>();
		
		File inFile = new File("/home/sar/temp/CSVInputFile.csv");
		File outJSONFile = new File("/home/sar/temp/JSONOutputFile.json");
		
		BufferedReader brRaceResultsList = new BufferedReader(new FileReader(inFile));
		
		line = brRaceResultsList.readLine();
		
		while(line != null) {
			horseRace = new RaceResultBean();
			
			raceData = line.split(",");
			
			if(raceData.length < 29) {
				line = brRaceResultsList.readLine();
				continue;
			}
			
			horseRace.setRaceDate(raceData[0]);
			horseRace.setsDay(raceData[1]);
			horseRace.setRaceNum(raceData[2]);
			horseRace.setType(raceData[3]);
			horseRace.setSurface(raceData[4]);
			horseRace.setDistLen(raceData[5]);
			horseRace.setDistMea(raceData[6]);
			horseRace.setPurse(raceData[7]);
			horseRace.setNumHorses(raceData[8]);
			horseRace.setFin1(raceData[9]);
			horseRace.setPrgNum1(raceData[10]);
			horseRace.setPpNum1(raceData[11]);
			horseRace.setfOdds1(raceData[12]);
			horseRace.setpTFav1(raceData[13]);
			horseRace.setFin2(raceData[14]);
			horseRace.setPrgNum2(raceData[15]);
			horseRace.setPpNum2(raceData[16]);
			horseRace.setfOdds2(raceData[17]);
			horseRace.setpTFav2(raceData[18]);
			horseRace.setFin3(raceData[19]);
			horseRace.setPrgNum3(raceData[20]);
			horseRace.setPpNum3(raceData[21]);
			horseRace.setfOdds3(raceData[22]);
			horseRace.setpTFav3(raceData[23]);
			horseRace.setFin4(raceData[24]);
			horseRace.setPrgNum4(raceData[25]);
			horseRace.setPpNum4(raceData[26]);
			horseRace.setfOdds4(raceData[27]);
			horseRace.setpTFav4(raceData[28]);
			
			horseRaces.add(horseRace);
			
			line = brRaceResultsList.readLine();

		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		//configure Object Mapper for pretty print
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		objectMapper.writeValue(outJSONFile, horseRaces);
		
		brRaceResultsList.close();
		
		System.out.println("JSON File Generated");


	}

}
