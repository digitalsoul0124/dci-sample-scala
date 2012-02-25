package jp.co.hatena.d.digitalsoul.loansyndicate.roles

import jp.co.hatena.d.digitalsoul.loansyndicate.models.Share

trait Lender {
	
	var limit:BigInt
	
	def draw(amount:BigInt, amountPie:AmountPie, percentagePie:PercentagePie) = {
		amountPie.increase(amount, percentagePie)
        decreaseLimit(amount)
	}
	
	def pay(amount:BigInt, amountPie:AmountPie) = {
		amountPie.decrease(amount, amountPie)
		increaseLimit(amount)
	}
	
	private def decreaseLimit(amount:BigInt) = { limit -= amount }
	
	private def increaseLimit(amount:BigInt) = { limit += amount }

}