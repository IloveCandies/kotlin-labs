
data class Contact(var name: String = "default", var number: String? = "default")

// я думаю целесообразней было бы использовать Set потому, что контакты на мой взгляд должны быть уникальными, но тогда нельзя выполнить задание -_-
// String? потому, что регулярка может вернуть null
class MobilePhone(val myPhone: String? = "default", val myContacts: MutableList<Contact> = mutableListOf<Contact>())
{
    fun addNewContact(newContact: Contact = Contact("default","default")) {
        myContacts.add(newContact)
    }

    fun updateContact(needToUpdateContact: Contact = Contact("default","default") , updateContact: Contact = Contact("default","default")): Boolean {
        var answer = false
        //будет странное поведение при ситуации, когда обьектов несколько они же не уникальные
        //решил  изменять первый найденный, чтобы ответ был более ожидаем
        for(iterContact in myContacts){
            if( (iterContact.equals(needToUpdateContact) ) && (answer == false) ) {
                iterContact.number = updateContact.number
                iterContact.name = updateContact.name
                answer = true
            }
            else continue
        }
        return answer
    }

    fun removeContact(Contact: Contact = Contact("default","default")): Boolean {
        if(myContacts.contains(Contact)) {
            myContacts.remove(Contact)
            return true
        }
        else {
            return false
        }
    }

    fun findContact(Contact: Contact = Contact("default","default")): Int {
        if(myContacts.contains(Contact)) {
            return myContacts.indexOf(Contact)
        }
        else {
            return -1
        }
    }

    // если бы у нас были уникальные поля...
    fun queryContact(searchQuery: String): String
    {
        var answer = "null"
        for(iterContact in myContacts){
            if(iterContact.name == searchQuery && answer == "null") {
                answer = iterContact.toString()
            }
            else continue
        }
        return answer
    }

}