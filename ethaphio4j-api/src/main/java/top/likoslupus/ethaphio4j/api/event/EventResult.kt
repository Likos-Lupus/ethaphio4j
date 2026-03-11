package top.likoslupus.ethaphio4j.api.event

sealed interface EventResult {

    data object None : EventResult

    data class OptionSelected(
        val index: Int? = null,
        val optionId: String? = null
    ) : EventResult

    data class EventResponse(
        val accepted: Boolean = true,
        val payload: Map<String, String> = emptyMap()
    ) : EventResult

}
