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
			Class<?> clazz = info.load();

			if (clazz.isAnnotationPresent(Solve.class)) {
				String day = clazz.getSimpleName().substring(3).toLowerCase();
				Path path = Paths.get("src/main/resources/day-" + day + "-data.txt");

				Object object;
				Constructor<?> cons;

				if (Files.exists(path)) {
					cons = clazz.getConstructor(List.class);
					List<String> data = Files.readAllLines(path);
					object = cons.newInstance(data);
				} else {
					cons = clazz.getConstructor();
					object = cons.newInstance();
				}

				System.out.println(clazz.getSimpleName() + "\n" + "answer1: " + clazz.getDeclaredMethod("getAnswerPartOne").invoke(object) + "\n" + "answer2: " + clazz.getDeclaredMethod("getAnswerPartTwo").invoke(object) + "\n");
			}

		}
	}

}
