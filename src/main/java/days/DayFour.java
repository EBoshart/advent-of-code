package days;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

import base.*;

public class DayFour extends Base {

	private List<String> data;

	public DayFour(List<String> data) {
		Collections.sort(data);
		this.data = data;
	}

	public static class GuardData {
		Integer totalMinutesSlept;
		Map<Integer, Integer> numberOfTimesSleptAtMinute = new HashMap<>();
	}

	public Integer getAnswerPartOne() {
		Map<Integer, GuardData> sleepTimeByGuardId = getGuardsWithMinutesAsleepMap();
		Map.Entry<Integer, GuardData> maxEntry =sleepTimeByGuardId.entrySet().stream().max(Comparator.comparing(a -> a.getValue().totalMinutesSlept)).get();
		int guard = maxEntry.getKey();
		Map.Entry<Integer, Integer> minute = maxEntry.getValue().numberOfTimesSleptAtMinute.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get();
		return guard * minute.getKey();
	}

	public Integer getAnswerPartTwo() {
		Map<Integer, GuardData> sleepTimeByGuardId = getGuardsWithMinutesAsleepMap();
		Map.Entry<Integer, GuardData> maxEntry =sleepTimeByGuardId.entrySet().stream().max(Comparator.comparing(a -> a.getValue().numberOfTimesSleptAtMinute.values().stream().max(Integer::compareTo).get())).get();
		int guard = maxEntry.getKey();
		Map.Entry<Integer, Integer> minute = maxEntry.getValue().numberOfTimesSleptAtMinute.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get();
		return guard * minute.getKey();

	}

	private Map<Integer, GuardData> getGuardsWithMinutesAsleepMap() {
		Map<Integer, GuardData> sleepTimeByGuardId = new HashMap<>();
		Integer currentGuard = null;
		int fallsAsleepAtMinute = 0;
		int secondsIndex = this.data.get(0).indexOf(":");
		for (String s : this.data) {
			int currentMinutes = Integer.valueOf(s.substring(secondsIndex+1, secondsIndex+3));
			int guardIndex = s.indexOf("#");
			if(guardIndex != -1) {
				currentGuard = Integer.valueOf(s.substring(guardIndex + 1, s.indexOf(" ", guardIndex)));
			}
			if(s.contains("asleep"))
				fallsAsleepAtMinute = currentMinutes;
			if(s.contains("wakes up")) {
				GuardData guardData = new GuardData();
				guardData.totalMinutesSlept = Math.abs(currentMinutes - fallsAsleepAtMinute);
				IntStream.range(fallsAsleepAtMinute, currentMinutes).forEach(i -> guardData.numberOfTimesSleptAtMinute.put(i, 1));

				sleepTimeByGuardId.merge(currentGuard, guardData, (oldValue, newValue) -> {
					oldValue.totalMinutesSlept += guardData.totalMinutesSlept;
					guardData.numberOfTimesSleptAtMinute.forEach((key, value) -> oldValue.numberOfTimesSleptAtMinute.merge(key, value, (o, n) -> ++o));
					return oldValue;
				});
			}
		}
		return sleepTimeByGuardId;
	}

	public static void main(String[] args) throws IOException {
		DayFour dayFour = new DayFour(Files.readAllLines(Paths.get("src/main/resources/day-four-data.txt")));

		System.out.println(dayFour.getAnswerPartOne());
		System.out.println(dayFour.getAnswerPartTwo());
	}

}
