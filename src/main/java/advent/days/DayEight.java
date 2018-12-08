package advent.days;

import java.util.*;

import advent.base.*;

public class DayEight extends Base {

	private List<Integer> numbers = new ArrayList<>();

	public DayEight(List<String> data) {

		String[] split = data.get(0).split(" ");
		for (String s : split) {
			numbers.add(Integer.valueOf(s));
		}
	}

	@Override
	public Integer getAnswerPartOne() {

		return getMetaDataSum(numbers).sum;
	}

	public static class SumIndexPair {

		public int length;
		public int sum;

		public SumIndexPair(int length, int sum) {

			this.length = length;
			this.sum = sum;
		}
	}

	private SumIndexPair getValueRootNode(List<Integer> integers) {

		int childNodes = integers.get(0);
		int metaEntries = integers.get(1);
		if (childNodes == 0) {
			int sum = integers.subList(2, 2 + metaEntries).stream().mapToInt(e -> e).sum();
			return new SumIndexPair(2 + metaEntries, sum);
		}

		int index = 0;
		List<SumIndexPair> pairs = new ArrayList<>();
		for (int i = 0; i < childNodes; i++) {
			SumIndexPair pair = getValueRootNode(integers.subList(2 + index, integers.size()));
			pairs.add(pair);
			index += pair.length;
		}

		List<Integer> test = integers.subList(2 + index, 2 + index + metaEntries);
		int sum = test.stream().mapToInt(p -> pairs.size() >= p && pairs.get(p - 1) != null ? pairs.get(p - 1).sum : 0).sum();
		index = 2 + index + metaEntries;

		return new SumIndexPair(index, sum);

	}

	private SumIndexPair getMetaDataSum(List<Integer> integers) {

		int childNodes = integers.get(0);
		int metaEntries = integers.get(1);
		if (childNodes == 0) {
			int sum = integers.subList(2, 2 + metaEntries).stream().mapToInt(e -> e).sum();
			return new SumIndexPair(2 + metaEntries, sum);
		}

		int index = 0;
		int sum = 0;
		for (int i = 0; i < childNodes; i++) {
			SumIndexPair pair = getMetaDataSum(integers.subList(2 + index, integers.size()));
			index += pair.length;
			sum += pair.sum;
		}
		int addition = integers.subList(2 + index, 2 + index + metaEntries).stream().mapToInt(i -> i).sum();

		sum += addition;
		index = 2 + index + metaEntries;

		return new SumIndexPair(index, sum);

	}

	@Override
	public Integer getAnswerPartTwo() {

		return getValueRootNode(numbers).sum;
	}
}