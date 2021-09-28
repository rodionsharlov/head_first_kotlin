enum class BandMember (val instrument: String)
{ 	JERRY("lead guitar") {
    	override fun sings() = "plaintively"
	}, 
    BOBBY("rhythm guitar") {
        override fun sings() = "hoarsely"
    }, 
    PHIL("bass");
    
    open fun sings() = "occasionally"
}

fun main() {
// 	var selectedBandMember: BandMember
//     selectedBandMember = BandMember.JERRY
//     println(selectedBandMember.instrument)
//     println(selectedBandMember.sings())
    
    BandMember.values().forEach{ println("$it: \n ${it.instrument} \n ${it.sings()} \n") }
}