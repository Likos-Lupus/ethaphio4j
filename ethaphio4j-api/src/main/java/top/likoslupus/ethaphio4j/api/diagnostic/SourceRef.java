package top.likoslupus.ethaphio4j.api.diagnostic;

public record SourceRef(
        String sourceName,
        int line,
        int column
) {

}
