package top.likoslupus.ethaphio4j.api.event

data class SoundEffectEvent(
    override val sourceId: String? = null,
    val soundId: String,
    val volume: Double? = 1.0,
    val pitch: Double? = 1.0,
    val repeatTime: Int? = 1,
) : Event
