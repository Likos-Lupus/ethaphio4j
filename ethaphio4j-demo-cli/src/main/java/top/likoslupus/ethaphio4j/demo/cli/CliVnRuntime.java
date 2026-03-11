package top.likoslupus.ethaphio4j.demo.cli;

import top.likoslupus.ethaphio4j.api.VnRuntime;
import top.likoslupus.ethaphio4j.api.event.Event;
import top.likoslupus.ethaphio4j.api.event.EventResult;

import java.util.concurrent.CompletionStage;

public class CliVnRuntime implements VnRuntime {

    @Override
    public CompletionStage<EventResult> execute(Event event) {
        return null;
    }

}
