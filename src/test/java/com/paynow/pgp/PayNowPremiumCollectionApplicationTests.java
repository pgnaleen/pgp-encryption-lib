package com.paynow.pgp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest(classes = PayNowPremiumCollectionApplicationTests.class)
@ComponentScan(basePackages = {"com.paynow.*"})
class PayNowPremiumCollectionApplicationTests {

	@Test
	void contextLoads() {
	}
}
