package cool.utils;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

	public static <T, K> List<K> castList(final List<T> list, final Class<K> clazz) {
		for (final var elem : list)
			if (!clazz.isInstance(elem))
				throw new ClassCastException("Cannot cast " + elem.getClass().getName() + " to " + clazz.getName());

		return list.stream().map(clazz::cast).collect(Collectors.toList());
	}

	public static final String OBJECT = "Object";
	public static final String IO = "IO";
	public static final String STRING = "String";
	public static final String INT = "Int";
	public static final String BOOL = "Bool";

	public static final String SELF = "self";
	public static final String SELF_TYPE = "SELF_TYPE";

	public static final String MAIN = "Main";
	public static final String MAIN_METHOD = "main";
}
