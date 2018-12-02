package daytwo;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class DayTwoB {
	private List<String> data;

	public DayTwoB(List<String> data) {
		Collections.sort(data);
		this.data = data;
	}

	public String getCommonCharacters() {
		for(int i=0; i<data.size()-1; i++) {
			for(int j=i+1; j<data.size(); j++) {
				String result = checkStrings(data.get(i), data.get(j));
				if(result != null) {
					return result;
				}
			}
		}
		return null;
	}

	private String checkStrings(String a, String b) {

		int index = 0;
		int indexOfDifferentChar = 0;
		while (index < a.length()) {
			if (a.charAt(index) == b.charAt(index)) {
				index++;
				continue;
			}
			if (indexOfDifferentChar != 0)
				return null;
			indexOfDifferentChar = index;
			index++;

		}

		return a.substring(0, indexOfDifferentChar) + a.substring(indexOfDifferentChar + 1);
	}

	public static void main(String[] args) throws IOException {
		DayTwoB dayTwoB = new DayTwoB(Files.readAllLines(Paths.get("src/main/resources/data.text")));
		System.out.println(dayTwoB.getCommonCharacters());
	}
}
