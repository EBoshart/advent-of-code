package advent.days;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

import advent.base.*;

@Solve
public class DaySix extends Base {

	public static Integer MAX_TOTAL_NEIGHBOUR_DISTANCE = 10000;

	public static void main(String[] args) {

		try {
			List<String> data = Files.readAllLines(Paths.get("src/main/resources/day-" + "six" + "-data.txt"));
			DaySix daySix = new DaySix(data);
			System.out.println(daySix.getAnswerPartTwo());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	private List<Coordinate> coordinates = new ArrayList<>();
	private String[][] grid;

	public DaySix(List<String> data) {

		int id = 1;
		for (String s : data) {

			String[] split = s.split(",");

			coordinates.add(new Coordinate(id, Integer.valueOf(split[0]), Integer.valueOf(split[1].trim())));
			id++;
		}
		grid = computeInitialGrid();
		System.out.println(this.getClass().getName());

	}

	private String[][] computeInitialGrid() {

		int minX = coordinates.stream().min(Comparator.comparingInt(a -> a.x)).get().x;
		int maxX = coordinates.stream().max(Comparator.comparingInt(a -> a.x)).get().x;
		int minY = coordinates.stream().min(Comparator.comparingInt(a -> a.y)).get().y;
		int maxY = coordinates.stream().max(Comparator.comparingInt(a -> a.y)).get().y;
		coordinates.forEach(coordinate -> {
			coordinate.x -= minX;
			coordinate.y -= minY;
		});
		return new String[maxX - minX + 1][maxY - minY + 1];
	}

	@Override
	public Integer getAnswerPartOne() {

		int rows = grid.length;
		int columns = grid[0].length;
		Set<Coordinate> coordinatesToExclude = new HashSet<>();
		Map<Coordinate, Integer> map = new HashMap<>();
		coordinates.forEach(coordinate -> grid[coordinate.x][coordinate.y] = String.valueOf(coordinate.id).toUpperCase());
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (grid[row][column] != null)
					continue;
				List<Coordinate> neighbours = calcClosestNeighbours(new Coordinate('0', row, column));
				if (neighbours.size() > 1)
					grid[row][column] = ".";
				else {
					Coordinate neighbour = neighbours.get(0);
					grid[row][column] = String.valueOf(neighbour.id);
					if (neighbour.x != 0 && neighbour.x != rows - 1 && neighbour.y != 0 && neighbour.y != columns - 1)
						map.merge(neighbours.get(0), 1, (a, b) -> ++a);
					if (row == 0 || row == rows - 1 || column == 0 || column == columns - 1) {
						coordinatesToExclude.add(neighbour);
					}
				}
			}
		}
		return map.entrySet().stream().filter(e -> !coordinatesToExclude.contains(e.getKey())).max(Comparator.comparing(Map.Entry::getValue)).get().getValue() + 1;
	}

	private List<Coordinate> calcClosestNeighbours(Coordinate coordinate) {

		Map<Integer, List<Coordinate>> map = coordinates.stream().collect(Collectors.toMap(e -> getManhattenDistance(e, coordinate), e -> new ArrayList<>(Collections.singletonList(e)), (a, b) -> {
			a.add(b.get(0));
			return a;

		}));

		int key = map.keySet().stream().min(Integer::compareTo).get();
		return map.get(key);
	}

	private int getManhattenDistance(Coordinate A, Coordinate B) {

		return Math.abs(A.x - B.x) + Math.abs(A.y - B.y);
	}

	@Override
	public Integer getAnswerPartTwo() {

		int rows = grid.length;
		int columns = grid[0].length;
		int validPoints = 0;
		coordinates.forEach(coordinate -> grid[coordinate.x][coordinate.y] = String.valueOf(coordinate.id).toUpperCase());
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				int totalNeighbourDistance = calcTotalNeighbourDistance(new Coordinate('0', row, column));
				if (totalNeighbourDistance >= MAX_TOTAL_NEIGHBOUR_DISTANCE)
					grid[row][column] = ".";
				else {
					grid[row][column] = "#";

					validPoints++;
				}
			}
		}

		return validPoints;
	}

	private int calcTotalNeighbourDistance(Coordinate coordinate) {

		int sum = 0;
		for (Coordinate c : coordinates) {
			sum += getManhattenDistance(coordinate, c);
		}

		return sum;
	}

	public void printGrid() {

		for (int row = 0; row < grid.length; row++) {
			System.out.println();
			for (int column = 0; column < grid[0].length; column++) {
				System.out.print(grid[row][column] + " ");
			}
		}
	}

	public static class Coordinate {

		int x;
		int y;
		int id;

		public Coordinate(int id, int x, int y) {

			this.x = x;
			this.y = y;
			this.id = id;
		}
	}
}
