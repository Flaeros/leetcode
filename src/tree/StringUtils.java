package tree;

import java.util.Arrays;
import java.util.List;

public class StringUtils {

    public static <T> String printDim(List<List<T>> list) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(Arrays.toString(list.get(i).toArray()));
            builder.append("\n");
        }
        return builder.toString();
    }
}
