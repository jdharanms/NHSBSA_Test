package nhs.test.UnitTest;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import nhs.test.Frequency;
import nhs.test.RegularAmount;

public class RegularAmountTest {

	private Set<ConstraintViolation<RegularAmount>> constraintViolations;
	private Validator validator;
	private RegularAmount regularAmount;
	private Frequency frequency;

	@Before
	public void initialiseTest() {
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		this.validator = vf.getValidator();
		this.regularAmount = new RegularAmount();
	}

	@SuppressWarnings("static-access")
	@Test
	public void InvalidRegularAmount() {
		// Given
		regularAmount.setAmount("regularAmount");
		regularAmount.setFrequency(frequency.TWO_WEEK);
		this.constraintViolations = this.validator.validate(regularAmount);
		// Then
		Assert.assertEquals(this.constraintViolations.iterator().next().getMessage(), "Inappropriate Amount");

	}

	@SuppressWarnings("static-access")
	@Test
	public void NotWholeNumberRegularAmount() {
		// Given
		regularAmount.setAmount("95");
		regularAmount.setFrequency(frequency.TWO_WEEK);
		this.constraintViolations = this.validator.validate(regularAmount);
		// Then
		Assert.assertEquals(this.constraintViolations.iterator().next().getMessage(), "Inappropriate Amount");

	}
	
	@SuppressWarnings("static-access")
	@Test
	public void NullRegularAmount() {
		// Given
		regularAmount.setAmount("");
		regularAmount.setFrequency(frequency.MONTH);
		this.constraintViolations = this.validator.validate(regularAmount);
		// Then
		Assert.assertEquals(this.constraintViolations.iterator().next().getMessage(), "Inappropriate Amount");

	}
	
	@SuppressWarnings("static-access")
	@Test
	public void NullFrequency() {
		// Given
		regularAmount.setAmount("100");
		this.constraintViolations = this.validator.validate(regularAmount);
		// Then
		Assert.assertEquals(this.constraintViolations.iterator().next().getMessage(), "Inappropriate Amount");

	}

	@SuppressWarnings("static-access")
	@Test
	public void ValidRegularAmount() {
		// Given
		regularAmount.setAmount("100");
		regularAmount.setFrequency(frequency.TWO_WEEK);
		this.constraintViolations = this.validator.validate(regularAmount);
		// Then
		Assert.assertTrue(this.constraintViolations.isEmpty());

	}

	@SuppressWarnings("static-access")
	@Test
	public void MonthlyRegularAmount() {
		// Given
		regularAmount.setAmount("95");
		regularAmount.setFrequency(frequency.MONTH);
		this.constraintViolations = this.validator.validate(regularAmount);
		// Then
		Assert.assertTrue(this.constraintViolations.isEmpty());

	}
}
