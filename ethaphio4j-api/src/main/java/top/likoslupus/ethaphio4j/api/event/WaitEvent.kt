package top.likoslupus.ethaphio4j.api.event

import java.time.Duration

data class WaitEvent(
    override val sourceId: String? = null,
    val duration: Duration,
) : Event
