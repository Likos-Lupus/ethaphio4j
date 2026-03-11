package top.likoslupus.ethaphio4j.api.event

import java.time.Duration

@JvmRecord
data class BackgroundEvent(
    override val sourceId: String? = null,
    val backgroundId: String? = null,
    val backgroundColor: String? = "000000",
    val duration: Duration? = null,
) : Event
