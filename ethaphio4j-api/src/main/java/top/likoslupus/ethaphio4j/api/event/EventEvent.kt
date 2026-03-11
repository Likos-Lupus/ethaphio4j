package top.likoslupus.ethaphio4j.api.event

data class EventEvent(
    override val sourceId: String? = null,
    val eventId: String,
) : Event
