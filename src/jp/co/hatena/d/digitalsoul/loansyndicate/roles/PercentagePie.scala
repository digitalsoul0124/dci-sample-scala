package jp.co.hatena.d.digitalsoul.loansyndicate.roles

import jp.co.hatena.d.digitalsoul.loansyndicate.models.SharePie
import jp.co.hatena.d.digitalsoul.loansyndicate.models.Company
import jp.co.hatena.d.digitalsoul.loansyndicate.models.Share


trait PercentagePie extends SharePie {
	
	def validate():Boolean = {
		BigInt(100) == totalAmount
	}
	
}