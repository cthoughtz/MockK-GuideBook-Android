package com.example.mockkguidebookandroid

class CustomButton {

    private var clickListener: (()-> Unit)? =null

    fun setOnClickListener(listener:()-> Unit) {
        clickListener = listener
    }

    fun performClick(){
        clickListener?.invoke()
    }
}

class NavigationView(
        private val navigator: Navigator
){
    val goToParkButton = CustomButton()

    init {
        goToParkButton.setOnClickListener { // <-- When this is clicked
            navigator.navigateTo("Park") // <-- verify that this method is called
        }
    }
}