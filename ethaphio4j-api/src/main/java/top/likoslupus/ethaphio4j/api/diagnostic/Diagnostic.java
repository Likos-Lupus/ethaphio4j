package top.likoslupus.ethaphio4j.api.diagnostic;

public record Diagnostic(
        Severity severity,
        String code,
        String message,
        SourceRef sourceRef
) {

}
