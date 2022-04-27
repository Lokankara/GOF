package com.luxoft.bank.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.luxoft.bank.employees.AbstractSpecialist;
import com.luxoft.bank.employees.FinancialSpecialist;
import com.luxoft.bank.employees.HousingPropertySpecialist;

public class Test9 {
	
    private static AbstractSpecialist getChainOfSpecialists(){ 
		AbstractSpecialist financialSpecialist = new FinancialSpecialist(); 
		AbstractSpecialist housingPropertySpecialist = new HousingPropertySpecialist();
		
		financialSpecialist.setNextSpecialist(housingPropertySpecialist); 
		
		return financialSpecialist; 
	}
	
	@Test
	public void testAnalysis() {
		AbstractSpecialist specialistsChain = getChainOfSpecialists();
		assertEquals(200.0, AbstractSpecialist.calculateAnalysisCommission(100000.0, true), 0);
		assertEquals(1000.0, AbstractSpecialist.calculateAnalysisCommission(200000.0, false), 0);
		assertFalse(specialistsChain.makeDecision(100000.0, 1000.00, 2600.00, true));
		System.out.println();
		assertFalse(specialistsChain.makeDecision(100000.0, 1000.00, 3600.00, false));
		System.out.println();
		assertTrue(specialistsChain.makeDecision(100000.0, 1000.00, 3600.00, true));
	}

}