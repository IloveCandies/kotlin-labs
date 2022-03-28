import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
internal class MobilePhoneTest {

    phone: MobilePhone = MobilePhone("88999000")
    @org.junit.jupiter.api.Test
    fun addNewContact() {
        var testContact = Contact("Bob","8951431345")
        phone.addNewContact(testContact)
        asserTrue(phone.myContacts.component1.equals(testContact))

    }

    @org.junit.jupiter.api.Test
    fun updateContact() {
        var testContact = Contact("Bob","8951431345")
        var secondTestContact = Contact("Martin","8951431345")
        phone.addNewContact(testContact)
        phone.updateContact(testContact,secondTestContact)
        asserTrue(phone.myContacts.component1.equals(secondTestContact))
    }

    @org.junit.jupiter.api.Test
    fun removeContact() {
        var testContact = Contact("Bob","8951431345")
        var secondTestContact = Contact("Martin","8951431345")
        phone.updateContact(testContact,secondTestContact)
        phone.addNewContact(testContact)
        phone.addNewContact(secondTestContact)
        phone.deleteContact(testContact)
        asserTrue(phone.myContacts.component1.equals(secondTestContact))
    }

    @org.junit.jupiter.api.Test
    fun findContact() {
        var testContact = Contact("Bob","8951431345")
        phone.addNewContact(testContact)
        var secondTestContact = phone.findContact(testContact)
        asserTrue(testContact.equals(secondTestContact))
    }

    @org.junit.jupiter.api.Test
    fun queryContact() {
        var testContact = Contact("Bob","8951431345")
        phone.addNewContact(testContact)
        var str = "Bob"
        var secondStr = phone.queryContact("Bob")
        asserTrue(str.equals(secondStr))
    }
}