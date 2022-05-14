fun main(){
    println("your fee ${transferFee("Visa",amountTransefer = 2000F)}")
}
fun transferFee(cardType: String = "Vk pay", amountPreviousTransers: Float = 0F, amountTransefer: Float): Float{
    var fee = when (cardType){
        "Visa", "Мир" -> return (amountTransefer / 100) * 0.75F
        "Mastercard", "Maestro" -> return ((amountTransefer / 100) * 0.6F) + 20
        else -> 0F
    }
    var previousTransers = amountPreviousTransers + amountTransefer
    return fee + previousTransers
}
