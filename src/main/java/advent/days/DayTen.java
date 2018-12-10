package advent.days;

import java.util.*;

import advent.base.*;

@Solve
public class DayTen implements Base {

	private List<Point> points = new ArrayList<>();

	private static class Point {

		int x;
		int y;
		int vX;
		int vY;

		public Point(int x, int y, int vX, int vY) {

			this.x = x;
			this.y = y;
			this.vX = vX;
			this.vY = vY;
		}

		@Override
		public boolean equals(Object o) {

			if (o == null)
				return false;
			if (!(o instanceof Point))
				return false;
			return ((Point) o).x == x && ((Point) o).y == y;
		}
	}

	public DayTen(List<String> data) {

		data.forEach(s -> {
			String[] split = s.split("position=<|> velocity=<");
			int x = Integer.parseInt(split[1].trim().split(",")[0].trim());
			int y = Integer.parseInt(split[1].trim().split(",")[1].trim());
			int vX = Integer.parseInt(split[2].trim().split(",")[0].trim());
			int vY = Integer.parseInt(split[2].trim().split(",")[1].trim().replace(">", ""));
			points.add(new Point(x, y, vX, vY));

		});
	}

	@Override
	public Integer getAnswerPartOne() {

		int iterations = 0;
		long prevDiff = Long.MAX_VALUE;
		long currentDiff = prevDiff - 1;
		
		while (prevDiff > currentDiff) {
			points.forEach(p -> {
				p.x += p.vX;
				p.y += p.vY;
			});
			int minX = points.stream().mapToInt(p -> p.x).min().getAsInt();
			int maxX = points.stream().mapToInt(p -> p.x).max().getAsInt();
			int minY = points.stream().mapToInt(p -> p.y).min().getAsInt();
			int maxY = points.stream().mapToInt(p -> p.y).max().getAsInt();
			long diffX = maxX - minX;
			long diffY = maxY - minY;
			prevDiff = currentDiff;
			currentDiff = diffX + diffY;
			iterations++;
		}

		iterations--;
		points.forEach(p -> {
			p.x -= p.vX;
			p.y -= p.vY;
		});

		int minX = points.stream().mapToInt(p -> p.x).min().getAsInt();
		int maxX = points.stream().mapToInt(p -> p.x).max().getAsInt();
		int minY = points.stream().mapToInt(p -> p.y).min().getAsInt();
		int maxY = points.stream().mapToInt(p -> p.y).max().getAsInt();

		for (int j = minY; j <= maxY; j++) {
			System.out.println();
			for (int i = minX; i <= maxX; i++) {
				System.out.print(points.contains(new Point(i,j,0,0)) ? "# " : ". ");
			}
		}

		return iterations;
	}

	@Override
	public Integer getAnswerPartTwo() {

		return null;
	}
}
