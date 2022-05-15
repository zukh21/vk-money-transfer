fun main(){
    println(transfer("Visa", amountTransefer = 20000F))
}

fun transferFee(cardType: String = "Vk pay", amountTransefer: Float): Float {
    var fee = when (cardType){
        "Visa", "Мир" -> (amountTransefer / 100) * 0.75F
        "Mastercard", "Maestro" -> ((amountTransefer / 100) * 0.6F) + 20
        else -> 0F
    }
    return fee
}
fun transfer( cardType: String, amountPreviousTransfers:Float = 0F, amountTransefer: Float): String {
    var fee = transferFee( cardType = cardType, amountTransefer = amountTransefer)
    var lastTransfer = amountPreviousTransfers + amountTransefer
    return ("Сумма на перевод - ${amountTransefer}, комиссия - ${fee}, снимается - ${amountTransefer + fee}, Ваш последний перевод - ${lastTransfer}").toString()
}
