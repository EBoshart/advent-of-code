package advent.days;

import advent.base.*;

public class DayEleven implements Base {

	public static int serialNumber = 18;
	public static int size = 3;
	private int[][] grid = new int[300][300];


	@Override
	public String getAnswerPartOne() {

		int maxValue = 0;
		String coordinatesMaxValue = "";

		for (int row = 1; row <= grid.length; row++) {
			System.out.println(row);
			for (int col = 1; col <= grid[0].length; col++) {
				int rackId = col + 10;
				int powerLevel = (rackId * row + serialNumber) * rackId;
				grid[col - 1][row - 1] = powerLevel < 100 ? -5 : (powerLevel / 100) % 10 - 5;

				if (row >= size && row < grid.length - size && col >= size && col < grid.length - size) {
					int value = value(grid, size, col, row);
					if (value > maxValue) {
						maxValue = value;
						coordinatesMaxValue = (col - size + 1) + "," + (row - size + 1);
					}
				}

			}
		}

		return coordinatesMaxValue;
	}

	private int value(int[][] grid, int subGridSize, int col, int row) {

		int sum = 0;
		for (int i = 1; i <= subGridSize; i++) {
			for (int j = 1; j <= subGridSize; j++) {
				sum += grid[col - i][row - j];
			}
		}
		return sum;
	}

	@Override
	public Object getAnswerPartTwo() {

		int maxValue = 0;
		String coordinatesMaxValue = "";
		int optGridSize = 0;

		for (int row = 1; row <= grid.length; row++) {
			for (int col = 1; col <= grid[0].length; col++) {
				int rackId = col + 10;
				int powerLevel = (rackId * row + serialNumber) * rackId;
				grid[col - 1][row - 1] = powerLevel < 100 ? -5 : (powerLevel / 100) % 10 - 5;

				int subGridSize = Math.min(col, row);
				for (int size = 1; size <= subGridSize; size++) {
					int value = value(grid, size, col, row);
					if (value > maxValue) {
						maxValue = value;
						coordinatesMaxValue = (col - size + 1) + "," + (row - size + 1);
						optGridSize = size;
					}
				}

			}
		}

		return coordinatesMaxValue+optGridSize;
	}

	public static void main(String[] args) {

		DayEleven dayEleven = new DayEleven();
		System.out.println(dayEleven.getAnswerPartOne());
	}
}
