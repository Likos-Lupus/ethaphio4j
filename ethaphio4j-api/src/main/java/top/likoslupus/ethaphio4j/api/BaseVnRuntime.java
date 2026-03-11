package top.likoslupus.ethaphio4j.api;

import org.jspecify.annotations.NonNull;
import top.likoslupus.ethaphio4j.api.event.*;
import top.likoslupus.ethaphio4j.api.event.Character;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public abstract class BaseVnRuntime implements VnRuntime {

    @Override
    public CompletionStage<EventResult> execute(Event switchEvent) {
        return switch (switchEvent) {
            case TextEvent text -> onText(text);
            case SelectionEvent selection -> onSelection(selection);
            case BackgroundEvent background -> onBackground(background);
            case Character.Visibility characterVisibility -> onCharacterVisibility(characterVisibility);
            case Character.Activity characterActivity -> onCharacterActivity(characterActivity);
            case Character.Movement characterMovement -> onCharacterMovement(characterMovement);
            case Character.Animation characterAnimation -> onCharacterAnimation(characterAnimation);
            case Character.Appearance characterAppearance -> onCharacterAppearance(characterAppearance);
            case Music.Start musicStart -> onMusicStart(musicStart);
            case Music.Control musicControl -> onMusicControl(musicControl);
            case Music.Stop musicStop -> onMusicStop(musicStop);
            case SoundEffectEvent soundEffect -> onSoundEffect(soundEffect);
            case WaitEvent wait -> onWait(wait);
            case EventEvent event -> onEvent(event);
            case null, default -> CompletableFuture.completedFuture(EventResult.None.INSTANCE);
        };
    }

    protected @NonNull CompletionStage<EventResult> onText(TextEvent text) {
        return CompletableFuture.completedFuture(EventResult.None.INSTANCE);
    }

    protected @NonNull CompletionStage<EventResult> onSelection(SelectionEvent selection) {
        return CompletableFuture.completedFuture(EventResult.None.INSTANCE);
    }

    protected @NonNull CompletionStage<EventResult> onBackground(BackgroundEvent background) {
        return CompletableFuture.completedFuture(EventResult.None.INSTANCE);
    }

    protected @NonNull CompletionStage<EventResult> onCharacterVisibility(Character.Visibility characterVisibility) {
        return CompletableFuture.completedFuture(EventResult.None.INSTANCE);
    }

    protected @NonNull CompletionStage<EventResult> onCharacterActivity(Character.Activity characterActivity) {
        return CompletableFuture.completedFuture(EventResult.None.INSTANCE);
    }

    protected @NonNull CompletionStage<EventResult> onCharacterMovement(Character.Movement characterMovement) {
        return CompletableFuture.completedFuture(EventResult.None.INSTANCE);
    }

    protected @NonNull CompletionStage<EventResult> onCharacterAnimation(Character.Animation characterAnimation) {
        return CompletableFuture.completedFuture(EventResult.None.INSTANCE);
    }

    protected @NonNull CompletionStage<EventResult> onCharacterAppearance(Character.Appearance characterAppearance) {
        return CompletableFuture.completedFuture(EventResult.None.INSTANCE);
    }

    protected @NonNull CompletionStage<EventResult> onMusicStart(Music.Start musicStart) {
        return CompletableFuture.completedFuture(EventResult.None.INSTANCE);
    }

    protected @NonNull CompletionStage<EventResult> onMusicControl(Music.Control musicControl) {
        return CompletableFuture.completedFuture(EventResult.None.INSTANCE);
    }

    protected @NonNull CompletionStage<EventResult> onMusicStop(Music.Stop musicStop) {
        return CompletableFuture.completedFuture(EventResult.None.INSTANCE);
    }

    protected @NonNull CompletionStage<EventResult> onSoundEffect(SoundEffectEvent soundEffect) {
        return CompletableFuture.completedFuture(EventResult.None.INSTANCE);
    }

    protected @NonNull CompletionStage<EventResult> onWait(WaitEvent wait) {
        return CompletableFuture.completedFuture(EventResult.None.INSTANCE);
    }

    protected @NonNull CompletionStage<EventResult> onEvent(EventEvent event) {
        return CompletableFuture.completedFuture(EventResult.None.INSTANCE);
    }

}
