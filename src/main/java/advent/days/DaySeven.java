package advent.days;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

import advent.base.*;

@Solve
public class DaySeven implements Base {

	public static Integer AMOUNT_OF_WORKERS = 5;
	public static Integer BASE_JOB_TIME = 60;

	public static void main(String[] args) throws IOException {

		List<String> data = Files.readAllLines(Paths.get("src/main/resources/day-seven-data.txt"));
		DaySeven daySeven = new DaySeven(data);
		System.out.println(daySeven.getAnswerPartTwo());
	}

	private List<String> data;
	private Map<Character, List<Character>> map = new TreeMap<>();

	public DaySeven(List<String> data) {

		this.data = data;
	}

	@Override
	public Object getAnswerPartOne() {

		StringBuilder stringBuilder = new StringBuilder();
		fillMap();

		while (!map.isEmpty()) {
			Map.Entry<Character, List<Character>> entry = map.entrySet().stream().filter(e -> e.getValue().isEmpty()).findFirst().get();

			Character key = entry.getKey();
			map.forEach((k, v) -> v.remove(key));
			map.remove(key);
			stringBuilder.append(key);
		}
		return stringBuilder.toString();

	}

	private void fillMap() {

		this.data.forEach(s -> {
			Character key = s.charAt(36);
			Character value = s.charAt(5);
			map.merge(key, new ArrayList<>(Collections.singletonList(value)), (a, b) -> {
				a.addAll(b);
				return a;
			});
			map.computeIfAbsent(value, k -> new ArrayList<>());

		});
	}

	@Override
	public Integer getAnswerPartTwo() {

		fillMap();
		StringBuilder stringBuilder = new StringBuilder();

		Map<Character, Integer> progressByChar = new TreeMap<>();
		int seconds = 0;
		boolean checkForNewJobs = true;
		while (!map.isEmpty()) {
			if (checkForNewJobs) {
				List<Character> availableJobs = map.entrySet().stream().filter(e -> !progressByChar.containsKey(e.getKey()) && e.getValue().isEmpty()).map(Map.Entry::getKey).sorted(Character::compareTo).collect(Collectors.toList());
				availableJobs.subList(0, Math.min(availableJobs.size(), AMOUNT_OF_WORKERS - progressByChar.size())).forEach(e -> progressByChar.put(e, e - 64 + BASE_JOB_TIME));
			}
			System.out.print(seconds + ", ");
			progressByChar.replaceAll((k, v) -> --v);
			checkForNewJobs = progressByChar.entrySet().removeIf((e) -> {
				Character job = e.getKey();
				Integer remainingProgress = e.getValue();
				System.out.print(job + " " + remainingProgress + ", ");
				if (remainingProgress == 0) {
					map.forEach((k, v) -> v.remove(job));
					map.remove(job);
					stringBuilder.append(job);
				}
				return remainingProgress == 0;
			});
			seconds++;
			System.out.print(stringBuilder.toString() + "\n");

		}

		return seconds;
	}
}