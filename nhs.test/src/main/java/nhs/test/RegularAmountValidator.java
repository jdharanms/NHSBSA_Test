package nhs.test;

import java.util.ArrayList;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegularAmountValidator implements ConstraintValidator<RegularAmountConstrain, RegularAmount>  {
	
	private ArrayList<String> al = new ArrayList<String>();

	public void initialize(RegularAmountConstrain constraintAnnotation) {
		al.add("WEEK");
		al.add("TWO_WEEK");
		al.add("FOUR_WEEK");
		
	}

	public boolean isValid(RegularAmount value, ConstraintValidatorContext context) {
		
		try{
	        Integer.parseInt(value.getAmount());
		if((!value.getAmount().isEmpty())&&(al.contains(value.getFrequency().toString()))&&(Integer.parseInt(value.getAmount())%2==0)){
			return true;
		}else if(!al.contains(value.getFrequency().toString())){
			return true;
		}
	   }catch(Exception e ){
	        return false;
	    }
		 return false;
		
	}



}
