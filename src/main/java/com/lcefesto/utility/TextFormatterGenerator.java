package com.lcefesto.utility;

import javafx.scene.control.TextFormatter;
import javafx.util.Pair;
import javafx.util.StringConverter;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**Original class for creation of custom TextFormatters.
 * @author Pietro Carrucciu*/
public class TextFormatterGenerator {

    public static final String INT_REGEX = "-?\\d+";
    public static final String DOUBLE_REGEX = "-?(([1-9][0-9]*)|0)?(\\.[0-9]*)?([Ee][+-]?[0-9]+)?";
    public static final String MULTI_REGEX = "[-\\d.,\\s]+";

    /**Creates a custom TextFormatter object starting from a Method's list of parameter types.
     * @param method the selected Method
     * @return a new TextFormatter< T > object
     * @see TextFormatter
     * @see Method
     * */
    public static <T> TextFormatter<T> createTextFormatter(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        Pair<String, Object> filters = createRegex(parameterTypes);
        Pattern validEditingState = Pattern.compile("^" + filters.getKey() + "$");

        //Should implement with Optional
        StringConverter<T> converter = new StringConverter<>() {
            @Override
            public T fromString(String s) {
                if (s.isEmpty()) {
                    return null;
                } else {
                    if (parameterTypes.length == 1) {
                        if (parameterTypes[0] == int.class) {
                            return (T) Integer.valueOf(s);
                        } else if (parameterTypes[0] == double.class) {
                            return (T) Double.valueOf(s);
                        }
                    } else {
                        String[] parts = s.split("[,\\s]+");
                        Object[] values = new Object[parameterTypes.length];
                        for (int i = 0; i < parameterTypes.length; i++) {
                            Class<?> type = parameterTypes[i];
                            if (type == int.class) {
                                values[i] = Integer.parseInt(parts[i]);
                            } else if (type == double.class) {
                                values[i] = Double.parseDouble(parts[i]);
                            }
                        }
                        return (T) values;
                    }
                }
                return null;
            }

            @Override
            public String toString(T t) {
                if (t == null ) {
                    return "";
                } else {
                    if (parameterTypes.length == 1) {
                        return t.toString();
                    } else {
                        Object[] values = (Object[]) t;
                        if(Arrays.stream(values).allMatch(Objects::isNull)){
                            return "";
                        }else{
                            return Arrays.stream(values).map(Object::toString).collect(Collectors.joining(", "));
                        }
                    }
                }
            }
        };

        UnaryOperator<TextFormatter.Change> filter = c -> {
            String text = c.getControlNewText();
            if (validEditingState.matcher(text).matches()) {
                return c;
            } else {
                return null;
            }
        };

        try{
            return new TextFormatter<>(converter, (T) filters.getValue(), filter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //I know, terrible implementation. But for performance's and readability's sake I went with this solution

    /**Creates a custom regex depending on the number of parameters and parameter type.
     * @param parameterTypes Class[] containing the Method's parameter types
     * @return a new Pair containing the regex and defaultValue
     * @see TextFormatterGenerator
     * */
    private static Pair<String, Object> createRegex(Class<?>[] parameterTypes){
        StringBuilder regexBuilder = new StringBuilder();
        Object defaultValue; //default value in case textformatting requirements are not met

        // Single parameter and multiple parameters distinction
        if (parameterTypes.length == 1) {
            Class<?> parameterType = parameterTypes[0];
            if (parameterType == int.class) {

                regexBuilder.append(INT_REGEX);
                defaultValue = 0;
            } else if (parameterType == double.class) {
                regexBuilder.append(DOUBLE_REGEX);
                defaultValue = 0.0;
            } else {
                throw new IllegalArgumentException("Unsupported parameter type: " + parameterType.getSimpleName());
            }
        } else {
            regexBuilder.append(MULTI_REGEX);
            defaultValue = new Object[parameterTypes.length];

            for (Class<?> parameterType : parameterTypes) {
                if (parameterType != int.class && parameterType != double.class) {
                    throw new IllegalArgumentException("Unsupported parameter type: " + parameterType.getSimpleName());
                }
            }
        }

        return new Pair<>(regexBuilder.toString(), defaultValue);
    }
}
