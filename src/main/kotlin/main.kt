fun main(){
    println(transfer("Vk pay", amountTransfer = 15000F))
}

fun transferFee(cardType: String = "Vk pay", amountTransefer: Float): Float {
    var fee = when (cardType){
        "Visa", "Мир" -> (amountTransefer / 100) * 0.75F
        "Mastercard", "Maestro" -> ((amountTransefer / 100) * 0.6F) + 20
        else -> 0F
    }
    return fee
}
fun transfer( cardType: String, amountPreviousTransfers:Float = 0F, amountTransfer: Float): String {
    val  cards = arrayListOf<String>("Visa", "Мир", "Mastercard", "Maestro")
    val maxTransferAtOnce: Float = 15_000F
    val maxTransferPerMonthWithVkPay: Float = 40_000F
        var transfer = if (cardType in cards){
            return checkTransferAmountWithCard(amountTransfer = amountTransfer, cardType = cardType, amountPreviousTransfers = amountPreviousTransfers)
        }else{
            return checkTransferAmountWithVkPay(amountTransfer = amountTransfer, cardType = cardType, amountPreviousTransfers = amountPreviousTransfers)
        }
    return transfer.toString()
}

fun checkTransferAmountWithCard(amountTransfer: Float, cardType: String, amountPreviousTransfers: Float = 0F): String{
    val  cards = arrayListOf<String>("Visa", "Мир", "Mastercard", "Maestro")
    val maxTransferPerMonthWithCard: Float = 600_000F
    val maxTransferPerDayWithCard: Float = 150_000F
    var checkAmount = if (amountTransfer > maxTransferPerDayWithCard && cardType in cards && amountTransfer < maxTransferPerMonthWithCard){
        return ("Ваш лимит ограничен! Вы можете перевести ${maxTransferPerDayWithCard} рублей в день.")
    }else if ((amountTransfer+amountPreviousTransfers) > maxTransferPerMonthWithCard  && cardType in cards){
        return ("Ваш лимит ограничен! Вы можете перевести ${maxTransferPerMonthWithCard} рублей в месяц.")
    }else{
        var fee = transferFee( cardType = cardType, amountTransefer = amountTransfer)
        return (("Сумма на перевод - ${amountTransfer}, комиссия - ${fee}," +
                "снимается - ${amountTransfer + fee}, Ваш последний перевод - ${amountPreviousTransfers}").toString())
    }
    amountPreviousTransfers + amountTransfer
    return checkAmount.toString()
}

fun checkTransferAmountWithVkPay(amountTransfer: Float, cardType: String, amountPreviousTransfers: Float = 0F): String{
    val  cards = arrayListOf<String>("Vk pay")
    val maxTransferAtOnce: Float = 15_000F
    val maxTransferPerMonthWithVkPay: Float = 40_000F
    var checkAmount = if (amountTransfer > maxTransferAtOnce && cardType in cards && amountTransfer < maxTransferPerMonthWithVkPay){
        return ("Ваш лимит ограничен! Вы можете перевести ${maxTransferAtOnce} рублей в день.")
    }else if ((amountTransfer+amountPreviousTransfers) > maxTransferPerMonthWithVkPay  && cardType in cards){
        return ("Ваш лимит ограничен! Вы можете перевести ${maxTransferPerMonthWithVkPay} рублей в месяц.")
    }else{
        var fee = transferFee( cardType = cardType, amountTransefer = amountTransfer)
        return (("Сумма на перевод - ${amountTransfer}, комиссия - ${fee}," +
                "снимается - ${amountTransfer + fee}, Ваш последний перевод - ${amountPreviousTransfers}").toString())
    }
    amountPreviousTransfers + amountTransfer
    return checkAmount.toString()
}