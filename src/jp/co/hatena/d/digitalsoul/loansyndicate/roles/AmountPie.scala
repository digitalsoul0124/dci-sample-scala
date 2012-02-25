package jp.co.hatena.d.digitalsoul.loansyndicate.roles

import jp.co.hatena.d.digitalsoul.loansyndicate.models.SharePie
import jp.co.hatena.d.digitalsoul.loansyndicate.models.Share

trait AmountPie extends SharePie {
	
	def increase(amount:BigInt, criterion:SharePie) = {
		val currentTotalAmount:BigInt = criterion.totalAmount
		criterion.shares.values foreach { share =>
		   shares(share.ownerId).amount += criterion.allot(share.ownerId, amount, currentTotalAmount)
		}
	}
	
	def decrease(amount:BigInt, criterion:SharePie) = {
		val currentTotalAmount:BigInt = criterion.totalAmount
		criterion.shares.values foreach { share =>
	        shares(share.ownerId).amount -= criterion.allot(share.ownerId, amount, currentTotalAmount)
		}
	}

}