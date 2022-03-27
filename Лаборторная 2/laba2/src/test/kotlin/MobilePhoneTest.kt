
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MobilePhoneTest {
    val check = "(\\+7|7|8)?[\\s\\-]?\\(?[489][0-9]{2}\\)?[\\s\\-]?[0-9]{3}[\\s\\-]?[0-9]{2}[\\s\\-]?[0-9]{2}".toRegex()
    // ТУТ НЕ РАБОТАЕТ INPUT
    val num = "+79855310868"
    val number = check.find(num)?.value
    var coolPhone = MobilePhone("+79822910868")

    @Test
    fun addNewContact() {
        val a = Contact("Jack",number)
        val b = Contact("Bob",number)
        val c = Contact("Marry",number)
        //json
        val string = Json.encodeToString(a)
        println(string)
        // back into object
        val obj = Json.decodeFromString<Contact>(string)
        assertEquals(obj, a,"Ошибка")
        coolPhone.addNewContact(obj)
        coolPhone.addNewContact(b)
        coolPhone.addNewContact(c)
        assertEquals(3



            , coolPhone.myContacts.count(),"Ошибка")
    }
}
