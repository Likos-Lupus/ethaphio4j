package top.likoslupus.ethaphio4j.api;

import top.likoslupus.ethaphio4j.api.event.Event;
import top.likoslupus.ethaphio4j.api.event.EventResult;

import java.util.concurrent.CompletionStage;

public interface VnRuntime {

    CompletionStage<EventResult> execute(Event event);

    default void attachSession(RuntimeSession session) {
    }

    default void dispose() {
    }

}
