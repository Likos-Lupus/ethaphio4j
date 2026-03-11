package top.likoslupus.ethaphio4j.api;

import top.likoslupus.ethaphio4j.api.value.ValueStore;

public interface RuntimeSession {

    RunnerState getRunnerState();

    ValueStore getVariables();

    default void log(String message) {
    }

}
