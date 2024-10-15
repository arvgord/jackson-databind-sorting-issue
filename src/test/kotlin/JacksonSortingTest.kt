import com.arvgord.FirstObject
import com.arvgord.SecondObject
import com.arvgord.ThirdObject
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class JacksonSortingTest {

    private val objectMapper = jacksonObjectMapper()

    private val jsonInput = """
        {
            "b": 2,
            "a": 1,
            "transactionId": "test",
            "c": [
                {
                    "id": "3",
                    "value": "c"
                },
                {
                    "id": "1",
                    "value": "a"
                },
                {
                    "id": "2",
                    "value": "b"
                }
            ]
        }
    """.trimIndent()

    private fun <T> testSerializationDeserialization(clazz: Class<T>) {
        val deserializedObject = objectMapper.readValue(jsonInput, clazz)

        val serializedJson = objectMapper.writeValueAsString(deserializedObject)

        val expectedJson = objectMapper.readTree(jsonInput).toPrettyString()
        val actualJson = objectMapper.readTree(serializedJson).toPrettyString()

        assertEquals(expectedJson, actualJson)
    }

    @Test
    fun `test serialization and deserialization for FirstObject`() {
        testSerializationDeserialization(FirstObject::class.java)
    }

    @Test
    fun `test serialization and deserialization for SecondObject`() {
        testSerializationDeserialization(SecondObject::class.java)
    }

    @Test
    fun `test serialization and deserialization for ThirdObject`() {
        testSerializationDeserialization(ThirdObject::class.java)
    }
}