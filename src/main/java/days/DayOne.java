package days;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import base.*;

public class DayOne extends Base {

	private final List<String> data;

	public DayOne(List<String> data) {
		this.data = data;
	}

	@Override
	public Integer getAnswerPartOne() {
		return this.data.stream().mapToInt(Integer::parseInt).sum();
	}

	@Override
	public Integer getAnswerPartTwo() {
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
		System.out.println(dayOne.getAnswerPartOne());
		System.out.println(dayOne.getAnswerPartTwo());
	}
}
