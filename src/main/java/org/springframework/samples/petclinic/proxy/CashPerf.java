package org.springframework.samples.petclinic.proxy;

import org.springframework.util.StopWatch;

public class CashPerf implements Payment {

	Payment cash = new Cash();

	@Override
	public void pay(int amount) {
		StopWatch st = new StopWatch();
		st.start();

		cash.pay(amount);

		st.stop();
		System.out.println(st.prettyPrint());
	}
}
