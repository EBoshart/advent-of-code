package dayone;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class DayOne {

	private final List<String> data;

	public DayOne(List<String> data) {
		this.data = data;
	}

	public int getSum() {
		return this.data.stream().mapToInt(Integer::parseInt).sum();
	}

	public int getFirstRepeatedFrequency() {
		Set<Integer> frequencies = new HashSet<>();
		frequencies.add(0);
		int index = 0;
		Integer oldFrequency = 0;
		while(true) {
			int newFrequency = oldFrequency + Integer.parseInt(data.get(index));
			if(frequencies.contains(newFrequency))
				return newFrequency;
			frequencies.add(newFrequency);
			index++;
			oldFrequency = newFrequency;
			if(index == data.size())
				index = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		DayOne dayOne = new DayOne(Files.readAllLines(Paths.get("src/main/resources/day-one-data.txt")));
		System.out.println(dayOne.getSum());
		System.out.println(dayOne.getFirstRepeatedFrequency());
	}
}
