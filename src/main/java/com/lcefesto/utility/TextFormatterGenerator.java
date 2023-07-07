package com.lcefesto.utility;

import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextFormatterGenerator {
    public static <T> TextFormatter<T> createTextFormatter(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        StringBuilder regexBuilder = new StringBuilder();
        StringBuilder toStringBuilder = new StringBuilder();
        Object defaultValue = null;

        if (parameterTypes.length == 1) {
            Class<?> parameterType = parameterTypes[0];
            if (parameterType == int.class) {
                regexBuilder.append("-?\\d+");
                defaultValue = (T) Integer.valueOf(0);
            } else if (parameterType == double.class) {
                regexBuilder.append("-?(([1-9][0-9]*)|0)?(\\.[0-9]*)?([Ee][+-]?[0-9]+)?");
                defaultValue = (T) Double.valueOf(0.0);
            } else {
                throw new IllegalArgumentException("Unsupported parameter type: " + parameterType.getSimpleName());
            }
        } else {
            regexBuilder.append("[-\\d.,\\s]+");
            defaultValue = (T) new Object[parameterTypes.length];

            for (Class<?> parameterType : parameterTypes) {
                if (parameterType != int.class && parameterType != double.class) {
                    throw new IllegalArgumentException("Unsupported parameter type: " + parameterType.getSimpleName());
                }
            }
        }

        String regex = regexBuilder.toString();
        String toStringPattern = toStringBuilder.toString();

        Pattern validEditingState = Pattern.compile("^" + regex + "$");

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
                if (t == null) {
                    return "";
                } else {
                    if (parameterTypes.length == 1) {
                        return t.toString();
                    } else {
                        Object[] values = (Object[]) t;
                        return Arrays.stream(values)
                                .map(Object::toString)
                                .collect(Collectors.joining(", "));
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

        return new TextFormatter<T>(converter,(T) defaultValue, filter);
    }




    /*public static <T> TextFormatter<T> createTextFormatter(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        StringBuilder regexBuilder = new StringBuilder();
        StringBuilder toStringBuilder = new StringBuilder();
        Object defaultValue = null;

        for (Class<?> parameterType : parameterTypes) {
            if (parameterType == int.class) {
                regexBuilder.append("-?\\d+");
                defaultValue = 0;
            } else if (parameterType == double.class) {
                regexBuilder.append("-?(([1-9][0-9]*)|0)?(\\.[0-9]*)?([Ee][+-]?[0-9]+)?");
                defaultValue = 0.0;
            } else {
                throw new IllegalArgumentException("Unsupported parameter type: " + parameterType.getSimpleName());
            }

            regexBuilder.append(",");
            toStringBuilder.append("%s,");
        }

        String regex = regexBuilder.substring(0, regexBuilder.length() - 1);
        String toStringPattern = toStringBuilder.substring(0, toStringBuilder.length() - 1);

        Pattern validEditingState = Pattern.compile("^" + regex + "$");

        StringConverter<T> converter = new StringConverter<>() {
            @Override
            public T fromString(String s) {
                if (s.isEmpty()) {
                    return null;
                } else {
                    String[] parts = s.split(",");
                    Object[] values = new Object[parameterTypes.length];
                    for (int i = 0; i < parameterTypes.length; i++) {
                        Class<?> type = parameterTypes[i];
                        if (type == int.class) {
                            values[i] = Integer.parseInt(parts[i]);
                        } else if (type == double.class) {
                            values[i] = Double.parseDouble(parts[i]);
                        }
                        // Add more cases for additional parameter types if needed
                    }
                    return (T) values;
                }
            }

            @Override
            public String toString(T t) {
                if (t == null) {
                    return "";
                } else {
                    Object[] values = (Object[]) t;
                    return String.format(toStringPattern, values);
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

        return new TextFormatter<T>(converter, (T) defaultValue, filter);
    }*/
}
