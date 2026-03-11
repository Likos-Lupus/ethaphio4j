package top.likoslupus.ethaphio4j.api.event

import java.time.Duration

object Character {

    data class Visibility(
        override val sourceId: String? = null,
        val characterId: String,
        val visible: Boolean,
    ) : Event

    data class Activity(
        override val sourceId: String? = null,
        val characterId: String,
        val active: Boolean,
    ) : Event

    data class Movement(
        override val sourceId: String? = null,
        val characterId: String,
        val duration: Duration? = null,
        val x: Double,
        val y: Double,
        val rotation: Double,
        val flipped: Boolean,
        val animationType: String? = null,
    ) : Event

    data class Animation(
        override val sourceId: String? = null,
        val characterId: String,
        val duration: Duration,
        val animationId: String,
    ) : Event

    data class Appearance(
        override val sourceId: String? = null,
        val characterId: String,
        val appearanceId: String,
    ) : Event

}
