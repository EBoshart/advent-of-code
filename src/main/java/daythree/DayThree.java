package daythree;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class DayThree {

	public static class Square {

		int x;
		int y;
		int height;
		int width;
		String id;

		public static Square fromString(String s) {

			String[] split = s.split("[@,:x]");
			Square square = new Square();
			square.id = split[0].trim();
			square.x = Integer.valueOf(split[1].trim());
			square.y = Integer.valueOf(split[2].trim());
			square.height = Integer.valueOf(split[4].trim());
			square.width = Integer.valueOf(split[3].trim());

			return square;
		}

		public static Square fromValues(int x, int y, int width, int height, String id) {

			Square square = new Square();
			square.x = x;
			square.y = y;
			square.height = height;
			square.width = width;
			square.id = id;

			return square;
		}

		@Override
		public boolean equals(Object o) {

			if (o == this)
				return true;
			if (!(o instanceof Square)) {
				return false;
			}
			Square square = (Square) o;
			return x == square.x && y == square.y && height == square.height && width == square.width;
		}

		@Override
		public int hashCode() {

			return Objects.hash(x, y, width, height);
		}
	}

	private List<Square> squares;

	public DayThree(List<String> squares) {

		this.squares = squares.stream().map(Square::fromString).collect(Collectors.toList());
	}

	public long calculateOverlappingSquares() {

		return getFilledMap().values().stream().filter(v -> v.size() > 1).count();
	}

	private Map<Square, List<String>> getFilledMap() {

		Map<Square, List<String>> countsOfFilledPoints = new HashMap<>();
		squares.forEach(square -> {
			for (int i = square.y; i < square.y + square.height; i++) {
				for (int j = square.x; j < square.x + square.width; j++) {
					countsOfFilledPoints.merge(Square.fromValues(i, j, 1, 1, null), new ArrayList<>(Collections.singletonList(square.id)), (oldValue, newValue) -> {
						oldValue.add(square.id);
						return oldValue;
					});
				}
			}
		});

		return countsOfFilledPoints;
	}

	public String getUniqueSquareId() {

		List<String> ids = squares.stream().map(square ->  square.id).collect(Collectors.toList());
		getFilledMap().values().forEach(entry -> {
			if(entry.size() > 1) {
				ids.removeAll(entry);
			}
		});
		return ids.get(0);
	}

	public static void main(String[] args) throws IOException {

		DayThree dayThree = new DayThree(Files.readAllLines(Paths.get("src/main/resources/day-three-squares.txt")));
		System.out.println(dayThree.calculateOverlappingSquares());
		System.out.println(dayThree.getUniqueSquareId());

	}
}
