package jp.co.hatena.d.digitalsoul.loansyndicate.unit

import org.junit._
import Assert._
import jp.co.hatena.d.digitalsoul.loansyndicate.models._
import jp.co.hatena.d.digitalsoul.loansyndicate.contexts._

class LoanSyndicateTest {

	@Test def shouldBuildFacility() = {
		
        val a:Company = new Company(10, "A")
        val b:Company = new Company(20, "B")
        val c:Company = new Company(30, "C")
        
        val syndicate:LoanSyndicate = new LoanSyndicate().buildFacility(1)
        syndicate.joinFacility(a, 50)
        syndicate.joinFacility(b, 30)
        syndicate.joinFacility(c, 20)

        assertEquals(BigInt(50), syndicate.facility.shares(10).amount)
        assertEquals(BigInt(30), syndicate.facility.shares(20).amount)
        assertEquals(BigInt(20), syndicate.facility.shares(30).amount)
        
        assertTrue(syndicate.validatePercentage);
	}
	
	@Test def shouldCauseValidateErrorWhenIllegalPercentage() = {
		
		val a:Company = new Company(10, "A")
        
        val syndicate:LoanSyndicate = new LoanSyndicate().buildFacility(1)
        syndicate.joinFacility(a, 50)
        
        assertFalse(syndicate.validatePercentage);
	}

	@Test def shouldDrawFromFacility() = {
		
        val a:Company = new Company(10, "A")
        val b:Company = new Company(20, "B")
        val c:Company = new Company(30, "C")
        
        val syndicate:LoanSyndicate = new LoanSyndicate().buildFacility(1)
        syndicate.joinFacility(a, 50)
        syndicate.joinFacility(b, 30)
        syndicate.joinFacility(c, 20)
        syndicate.facilityLimit(BigInt(100000))

        syndicate.draw(BigInt(10000))

        assertEquals(BigInt(5000), syndicate.facility.loan.shares(10).amount)
        assertEquals(BigInt(3000), syndicate.facility.loan.shares(20).amount)
        assertEquals(BigInt(2000), syndicate.facility.loan.shares(30).amount)
        
        assertEquals(BigInt(90000), syndicate.facility.limit)
	}
	
	@Test def shouldPayToFacility() = {
		
		val a:Company = new Company(10, "A")
        val b:Company = new Company(20, "B")
        val c:Company = new Company(30, "C")
        
        val syndicate:LoanSyndicate = new LoanSyndicate().buildFacility(1)
        syndicate.joinFacility(a, 50)
        syndicate.joinFacility(b, 30)
        syndicate.joinFacility(c, 20)
        syndicate.facilityLimit(BigInt(100000))

        syndicate.draw(BigInt(10000))           
        syndicate.pay(BigInt(5000))

        assertEquals(BigInt(2500), syndicate.facility.loan.shares(10).amount)
        assertEquals(BigInt(1500), syndicate.facility.loan.shares(20).amount)
        assertEquals(BigInt(1000), syndicate.facility.loan.shares(30).amount)
        
        assertEquals(BigInt(95000), syndicate.facility.limit)
	}
	
	@Test def shouldTransferBetweenWithdrawal() = {
		
		val a:Company = new Company(10, "A")
        val b:Company = new Company(20, "B")
        val c:Company = new Company(30, "C")
        
        val syndicate:LoanSyndicate = new LoanSyndicate().buildFacility(1)
        syndicate.joinFacility(a, 50)
        syndicate.joinFacility(b, 30)
        syndicate.joinFacility(c, 20)
        syndicate.facilityLimit(BigInt(10000)) // a:50% b:30% c:20%

        syndicate.draw(BigInt(1000))            // a:500 b:300 c:200
        syndicate.transferPercentage(b, a, 10)  // a:60% b:20% c:20%
        syndicate.draw(BigInt(1000))            // a:1100(55%) b:500(25%) c:400(20%)
        syndicate.pay(BigInt(500))              // a:825 b:375 c:300

        assertEquals(BigInt(825), syndicate.facility.loan.shares(10).amount)
        assertEquals(BigInt(375), syndicate.facility.loan.shares(20).amount)
        assertEquals(BigInt(300), syndicate.facility.loan.shares(30).amount)
        
        assertEquals(BigInt(8500), syndicate.facility.limit)
	}
}