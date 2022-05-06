fun main(){
    var amount: Float = 50000F
    val percent = 0.75
    fun transferFee(){
        val fee = (amount / 100)*percent
        println(fee)
    }
    transferFee()
}