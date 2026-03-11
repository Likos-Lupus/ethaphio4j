package top.likoslupus.ethaphio4j.api.save;

import top.likoslupus.ethaphio4j.api.value.Value;

import java.util.Collections;
import java.util.Map;

public record SaveData(
        String stageId,
        int instructionPointer,
        Map<String, Value> variables,
        Map<String, String> metadata
) {

    public SaveData(
            String stageId,
            int instructionPointer,
            Map<String, Value> variables,
            Map<String, String> metadata
    ) {
        this.stageId = stageId;
        this.instructionPointer = instructionPointer;
        this.variables = variables == null ? Collections.emptyMap() : Map.copyOf(variables);
        this.metadata = metadata == null ? Collections.emptyMap() : Map.copyOf(metadata);
    }

}
