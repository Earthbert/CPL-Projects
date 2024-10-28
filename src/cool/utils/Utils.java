package cool.utils;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

	public static <T, K> List<K> castList(List<T> list, Class<K> clazz) {
		for (var elem : list)
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

	public static final String NEG_OP = "~";
	public static final String NOT_OP = "not";
	public static final String ISVOID_OP = "isvoid";
}
