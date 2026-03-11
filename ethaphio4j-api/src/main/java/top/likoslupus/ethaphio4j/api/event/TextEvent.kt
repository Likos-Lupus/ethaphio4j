package top.likoslupus.ethaphio4j.api.event

data class TextEvent(
    override val sourceId: String? = null,
    val characterId: String?,
    val content: String,
    val displayName: String? = null,
    val voiceId: String? = null
) : Event
