fun main(){
    transferFee()
}
fun transferFee(){
    var amount: Float = 50000F
    val percent = 0.75
    val fee = (amount / 100)*percent
    println(fee)
}