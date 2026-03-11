package top.likoslupus.ethaphio4j.api;

import java.util.concurrent.CompletionStage;

public interface Runner {

    CompletionStage<Void> start();

    CompletionStage<Void> resume();

    RunnerState getState();

    RunnerStatus getStatus();

    void addEventListener(EventListener listener);

    void removeEventListener(EventListener listener);

}
