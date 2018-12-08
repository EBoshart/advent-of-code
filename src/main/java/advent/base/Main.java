package advent.base;

import java.io.*;
import java.lang.reflect.*;
import java.nio.file.*;
import java.util.*;

import com.google.common.reflect.*;

public class Main {

	public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {

		final ClassLoader loader = Thread.currentThread().getContextClassLoader();
		for (final ClassPath.ClassInfo info : ClassPath.from(loader).getTopLevelClassesRecursive("advent")) {
			Class<?> test = info.load();
			if (test.isAnnotationPresent(Solve.class)) {

				Constructor<?> cons = test.getConstructor(List.class);
				String day = test.getSimpleName().substring(3).toLowerCase();

				List<String> data = Files.readAllLines(Paths.get("src/main/resources/day-" + day + "-data.txt"));

				System.out.println(test.getSimpleName() + "\n" + "answer1: " + test.getDeclaredMethod("getAnswerPartOne").invoke(cons.newInstance(data)) + "\n" + "answer2: " + test.getDeclaredMethod("getAnswerPartTwo").invoke(cons.newInstance(data)) + "\n");

			}
			}

		}

}
