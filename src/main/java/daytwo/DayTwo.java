package daytwo;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class DayTwo {

	private List<String> data;
	private int twoCount;
	private int threeCount;

	public DayTwo(List<String> data ) {
		this.data =data;
	}

	public Integer getCheckSum() {
		data.forEach(this::checkString);
		return twoCount*threeCount;
	}

	private void checkString(String s) {
		Map<Integer, Long> map = s.chars().boxed().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		if(map.values().contains(2L))
			twoCount++;
		if(map.values().contains(3L))
			threeCount++;
	}


	public static void main(String[] args) throws IOException {
		DayTwo dayTwo = new DayTwo(Files.readAllLines(Paths.get("src/main/resources/data.text")));
		System.out.println(dayTwo.getCheckSum());
	}
}
