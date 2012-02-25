package jp.co.hatena.d.digitalsoul.loansyndicate.models

class Facility(val id:Int) {
	var limit:BigInt = 0
	var loan:Loan = null
	var shares = Map[Int, Share]()
}