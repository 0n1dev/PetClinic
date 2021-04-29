package org.springframework.samples.petclinic.sample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SampleControllerTest {

	private final ApplicationContext appContext;
//	private final SampleController sampleController;

	@Autowired
	SampleControllerTest(ApplicationContext appContext) {
		this.appContext = appContext;
	}

	@Test
	public void testDI() {
		SampleController bean = appContext.getBean(SampleController.class);
		assertThat(bean).isNotNull();
	}
}
