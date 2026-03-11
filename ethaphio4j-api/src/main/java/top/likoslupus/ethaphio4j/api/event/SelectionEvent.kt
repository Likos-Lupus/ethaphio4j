package top.likoslupus.ethaphio4j.api.event

import java.time.Duration

data class SelectionEvent(
    override val sourceId: String? = null,
    val prompt: String? = null,
    val duration: Duration? = null,
    val options: List<SelectionOption>
) : Event {

    data class SelectionOption(
        val id: String? = null,
        val text: String,
        val enabled: Boolean = true,
    )

}
