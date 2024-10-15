package com.arvgord

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE
)
class FirstObject {
    @field:JsonAnySetter
    @field:JsonAnyGetter
    val data: Map<String, Any?> = LinkedHashMap()

    val transactionId: String
        get() = data["transactionId"] as String
}

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE
)
class SecondObject(
    val transactionId: String
) {
    @field:JsonAnySetter
    @field:JsonAnyGetter
    val data: Map<String, Any?> = LinkedHashMap()
}

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE
)
class ThirdObject(
    val transactionId: String,
    @field:JsonAnySetter
    @field:JsonAnyGetter
    val data: Map<String, Any?> = LinkedHashMap()
)