package cool.utils;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {
	public static <T, K> List<K> castList(List<T> list, Class<K> clazz) {
		if (!list.stream().allMatch(clazz::isInstance)) {
			throw new IllegalArgumentException("Elements in list must be instances of " + clazz.getName());
		}
		return list.stream().map(clazz::cast).collect(Collectors.toList());
	}
}
