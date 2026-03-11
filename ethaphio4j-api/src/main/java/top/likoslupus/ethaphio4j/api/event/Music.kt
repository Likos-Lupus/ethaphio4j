package top.likoslupus.ethaphio4j.api.event

object Music {

    data class Start(
        override val sourceId: String? = null,
        val musicId: String,
        val volume: Double? = 1.0,
        val repeat: Boolean? = true,
        val fadeIn: Double? = 0.0,
        val fadeOut: Double? = 0.0,
    ) : Event

    data class Control(
        override val sourceId: String? = null,
        val controlSourceId: String,
        val volume: Double? = 1.0,
        val pitch: Double? = 1.0,
        val repeat: Boolean? = true,
        val fadeIn: Double? = 0.0,
        val fadeOut: Double? = 0.0,
        val keepPlaying: Boolean? = true,
    ) : Event

    data class Stop(
        override val sourceId: String? = null,
        val stopSourceId: String,
    ) : Event

}
