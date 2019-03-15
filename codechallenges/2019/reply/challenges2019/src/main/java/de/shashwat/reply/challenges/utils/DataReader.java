package de.shashwat.reply.challenges.utils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.shashwat.reply.challenges.model.CustomerH;
import de.shashwat.reply.challenges.model.ReplyMap;

public class DataReader {
	public DataReader() {
	}
	
	public void readFromFile(final String fileStr) {
		try {
			final File tupleFile = new File(fileStr);
			if (tupleFile.exists()) {
				final Stream<String> lines = Files.lines(Paths.get(fileStr), StandardCharsets.UTF_8);
				List<String> lineContent = lines.collect(Collectors.toList());
				lines.close();
				String mapDetailStr = lineContent.get(0);
				String[] mapDetail = mapDetailStr.split(" ");
				ReplyMap replyMap = new ReplyMap(Integer.valueOf(mapDetail[0]), Integer.valueOf(mapDetail[1]), Integer.valueOf(mapDetail[2]), Integer.valueOf(mapDetail[3]));
				List<CustomerH> customerHsList = new ArrayList<>();
				for (int index = 1; index <= replyMap.getC(); index++) {
					String customerHStr = lineContent.get(index);
					String[] customerHArr = customerHStr.split(" ");
					customerHsList.add(new CustomerH(Integer.valueOf(customerHArr[0]), Integer.valueOf(customerHArr[1]), Integer.valueOf(customerHArr[2])));
				}
				char[][] terrainCells = new char[replyMap.getN()][replyMap.getM()];
				for (int i = 0; i < replyMap.getN(); i++) {
					String terrainLine = lineContent.get(replyMap.getC() + 1 + i); 
					for (int j = 0; j < replyMap.getM(); j++) {
						terrainCells[i][j] = terrainLine.toCharArray()[j];
					}
				}
				CalculatePath calculatePath = new CalculatePath(replyMap, customerHsList, terrainCells)
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
