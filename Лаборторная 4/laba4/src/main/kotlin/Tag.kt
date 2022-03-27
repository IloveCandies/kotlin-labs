data class Tag(var name: String,var color: String = "Black") {
    fun changeColor(newColor: String) {
        this.color = newColor
    }
    fun changeName(newName: String){
        this.name = newName
    }
}