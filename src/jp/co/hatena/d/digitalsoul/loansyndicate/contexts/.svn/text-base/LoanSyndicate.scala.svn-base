package jp.co.hatena.d.digitalsoul.loansyndicate.contexts

import jp.co.hatena.d.digitalsoul.loansyndicate.models.Company
import jp.co.hatena.d.digitalsoul.loansyndicate.models.Facility
import jp.co.hatena.d.digitalsoul.loansyndicate.models.Loan
import jp.co.hatena.d.digitalsoul.loansyndicate.models.Share
import jp.co.hatena.d.digitalsoul.loansyndicate.roles.AmountPie
import jp.co.hatena.d.digitalsoul.loansyndicate.roles.Lender
import jp.co.hatena.d.digitalsoul.loansyndicate.roles.PercentagePie

class LoanSyndicate {
	
	private var _facility:Facility = null
	private var percentagePie:PercentagePie = null
	private var lender:Lender = null
	private var amountPie:AmountPie = null
	
	def facility:Facility = { _facility }
	
	def buildFacility(id:Int):LoanSyndicate = {
		
		var facility = new Facility(id) with Lender with PercentagePie
		var loan = new Loan with AmountPie
		
		facility.loan = loan
		
		_facility = facility
		
		percentagePie = facility
		lender = facility
		amountPie = loan
		
		this
	}
	
	def joinFacility(company:Company, percentage:Int) = {
		percentagePie.add(new Share(company.id, percentage))
		amountPie.add(new Share(company.id, 0))
	}
	
	def validatePercentage:Boolean = { 
		percentagePie.validate()
	}
	
	def facilityLimit(limit:BigInt) = {
		lender.limit = limit
	}
	
	def draw(amount:BigInt) = {
		lender.draw(amount, amountPie, percentagePie)
	}
	
	def pay(amount:BigInt) = {
		lender.pay(amount, amountPie)
	}
	
	def transferPercentage(from:Company, to:Company, amount:Int) = {
		percentagePie.transfer(from, to, amount)
	}
}