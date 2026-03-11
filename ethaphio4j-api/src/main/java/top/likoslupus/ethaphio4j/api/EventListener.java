package top.likoslupus.ethaphio4j.api;

import top.likoslupus.ethaphio4j.api.event.Event;

public interface EventListener {

    default void onRunnerStarted(RunnerState state) {
    }

    default void onBeforeEvent(RunnerState state, Event event) {
    }

    default void onAfterEvent(RunnerState state, Event event) {
    }

    default void onRunnerCompleted(RunnerState state) {
    }

    default void onRunnerFailed(RunnerState state, Throwable error) {
    }

}
