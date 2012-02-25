package jp.co.hatena.d.digitalsoul.loansyndicate.models

trait SharePie {
	
	var shares:Map[Int, Share]
	
    def totalAmount:BigInt = {
	    var sum:BigInt = 0
		shares.values foreach { share => sum += share.amount }
		sum		
	}
	
    def add(share:Share) = {
		shares += { share.ownerId -> share }
	}
    
    def allot(ownerId:Int, whole:BigInt, totalAmount:BigInt):BigInt = {
    	whole * shares(ownerId).amount / totalAmount
    }
    
    def transfer(from:Company, to:Company, amount:Int) = {
		assert(BigInt(amount) <= shares(from.id).amount)
		
		shares(from.id).amount -= amount
		shares(to.id).amount += amount
	}

}