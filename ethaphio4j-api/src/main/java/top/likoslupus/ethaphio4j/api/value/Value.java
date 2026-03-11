package top.likoslupus.ethaphio4j.api.value;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Objects;

public final class Value {

    private static final Value NULL = new Value(ValueType.NULL, null);

    private final ValueType type;
    private final Object raw;

    private Value(
            @NonNull ValueType type,
            Object raw
    ) {
        this.type = Objects.requireNonNull(type);
        this.raw = raw;
    }

    public static Value nullValue() {
        return NULL;
    }

    public static @NonNull Value of(boolean value) {
        return new Value(ValueType.BOOLEAN, value);
    }

    public static @NonNull Value of(long value) {
        return new Value(ValueType.INTEGER, value);
    }

    public static @NonNull Value of(double value) {
        return new Value(ValueType.DECIMAL, BigDecimal.valueOf(value));
    }

    public static Value of(BigDecimal value) {
        return value == null ? NULL : new Value(ValueType.DECIMAL, value);
    }

    public static Value of(String value) {
        return value == null ? NULL : new Value(ValueType.STRING, value);
    }

    public ValueType getType() {
        return type;
    }

    public Object getRaw() {
        return raw;
    }

    public boolean isNull() {
        return type == ValueType.NULL;
    }

    public boolean requireBoolean() {
        if (type != ValueType.BOOLEAN) {
            throw typeError("BOOLEAN");
        }
        return (Boolean) raw;
    }

    private ValueConversionException typeError(String expected) {
        return new ValueConversionException(
                "Expected " + expected + " but was " + type
        );
    }

    public long requireLong() {
        if (type != ValueType.INTEGER) {
            throw typeError("INTEGER");
        }
        return (Long) raw;
    }

    public BigDecimal requireDecimal() {
        if (type != ValueType.DECIMAL) {
            throw typeError("DECIMAL");
        }
        return (BigDecimal) raw;
    }

    public String requireString() {
        if (type != ValueType.STRING) {
            throw typeError("STRING");
        }
        return (String) raw;
    }

    public long toLong() {
        return switch (type) {
            case NULL -> throw conversionError("INTEGER", "NULL cannot be converted to INTEGER");
            case BOOLEAN -> (Boolean) raw ? 1L : 0L;
            case INTEGER -> (Long) raw;
            case DECIMAL -> decimalToLong((BigDecimal) raw);
            case STRING -> parseLong((String) raw);
        };
    }

    private @NonNull ValueConversionException conversionError(String target, String detail) {
        return new ValueConversionException(
                "Cannot convert " + type + " to " + target + ": " + detail
        );
    }

    private long decimalToLong(BigDecimal decimal) {
        try {
            return decimal.longValueExact();
        } catch (ArithmeticException e) {
            throw conversionError("INTEGER", "decimal is not an exact integer: " + decimal);
        }
    }

    private long parseLong(String s) {
        String v = normalize(s);
        try {
            return Long.parseLong(v);
        } catch (NumberFormatException e) {
            throw conversionError("INTEGER", "invalid string: \"" + s + "\"");
        }
    }

    private @NonNull String normalize(String s) {
        return s == null ? "" : s.trim().toLowerCase(Locale.ROOT);
    }

    public BigDecimal toDecimal() {
        return switch (type) {
            case NULL -> throw conversionError("DECIMAL", "NULL cannot be converted to DECIMAL");
            case BOOLEAN -> (Boolean) raw ? BigDecimal.ONE : BigDecimal.ZERO;
            case INTEGER -> BigDecimal.valueOf((Long) raw);
            case DECIMAL -> (BigDecimal) raw;
            case STRING -> parseDecimal((String) raw);
        };
    }

    private @NonNull BigDecimal parseDecimal(String s) {
        String v = normalize(s);
        try {
            return new BigDecimal(v);
        } catch (NumberFormatException e) {
            throw conversionError("DECIMAL", "invalid string: \"" + s + "\"");
        }
    }

    public @Nullable String toStringValue() {
        return switch (type) {
            case NULL -> null;
            case BOOLEAN -> ((Boolean) raw).toString();
            case INTEGER -> Long.toString((Long) raw);
            case DECIMAL -> ((BigDecimal) raw).stripTrailingZeros().toPlainString();
            case STRING -> (String) raw;
        };
    }

    public boolean isTruthy() {
        return toBoolean();
    }

    public boolean toBoolean() {
        return switch (type) {
            case NULL -> false;
            case BOOLEAN -> (Boolean) raw;
            case INTEGER -> (Long) raw != 0L;
            case DECIMAL -> ((BigDecimal) raw).compareTo(BigDecimal.ZERO) != 0;
            case STRING -> parseBoolean((String) raw);
        };
    }

    private boolean parseBoolean(String s) {
        String v = normalize(s);
        return switch (v) {
            case "true", "1", "yes", "y", "on" -> true;
            case "false", "0", "no", "n", "off", "" -> false;
            default -> throw conversionError("BOOLEAN", "invalid string: \"" + s + "\"");
        };
    }

    @Override
    public String toString() {
        return "Value{type=" + type + ", raw=" + raw + '}';
    }

}
