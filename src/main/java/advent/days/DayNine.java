package advent.days;

import java.util.*;
import java.util.stream.*;

import advent.base.*;

@Solve
public class DayNine implements Base {

	private int turns = 71920;
	private int amountOfPlayers = 403;

	public DayNine() {

	}

	public DayNine(int turns, int amountOfPlayers) {

		this.turns = turns;
		this.amountOfPlayers = amountOfPlayers;
	}

	@Override
	public Long getAnswerPartOne() {

		int currentPlayer = 1;
		Map<Integer, Long> scoreByPlayers = IntStream.rangeClosed(1, amountOfPlayers).boxed().collect(Collectors.toMap(i -> i, i -> 0L));

		List<Integer> numbers = new LinkedList<>();

		ListIterator<Integer> iterator = numbers.listIterator();
		iterator.add(0);
		iterator.add(1);
		int nextSpecial = 23;
		for (int i = 2; i <= turns; i++) {
			if (i != nextSpecial) {
				if (!iterator.hasNext()) {
					iterator = numbers.listIterator();
				}
				iterator.next();
				iterator.add(i);

			} else {
				for (int j = 0; j < 7; j++) {
					if (!iterator.hasPrevious())
						iterator = numbers.listIterator(numbers.size());
					iterator.previous();
				}
				int valueRemoved = iterator.previous();
				iterator.remove();

				int scoreplus = valueRemoved + i;
				scoreByPlayers.merge(currentPlayer, 0L, (prev, added) -> prev + scoreplus);
				iterator.next();
				nextSpecial += 23;

			}
			currentPlayer = currentPlayer != amountOfPlayers ? currentPlayer + 1 : 1;
		}

		return scoreByPlayers.values().stream().mapToLong(i -> i).max().getAsLong();
	}

	@Override
	public Long getAnswerPartTwo() {

		turns = 71920 * 100;
		Long answer = getAnswerPartOne();
		turns = 71920;
		return answer;
	}
}
