package com.example.temperatureconverterapplication.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.temperatureconverterapplication.R;
import com.example.temperatureconverterapplication.MainActivity;

public class MathValidation extends
		ActivityInstrumentationTestCase2<MainActivity> {
	
	private TextView result;
	private static final String NUMBER_104 = "1 0 4 ENTER ";
	//private static final String NUMBER_40 = "4 0 ENTER ";
	private static final String CONVERT_RESULT_CELCIUS = "40.0Degree C";
	private static final String CONVERT_RESULT_FAHRENHEIT = "219.2Degree F";

	public MathValidation() {
		super("com.example.temperatureconverterapplication", MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		MainActivity mainActivity = getActivity();
		result = (TextView) mainActivity.findViewById(R.id.result);
		
	}
	
	public void testToCelciusConvertValues() {
		sendKeys(NUMBER_104);
		sendKeys("ENTER");
		String mathResult = result.getText().toString();
		assertTrue("Convert result should be " + CONVERT_RESULT_CELCIUS + " but was " + mathResult.toString(), mathResult.equals(CONVERT_RESULT_CELCIUS));

}
	public void testToFahrenheitConvertValues() {
		sendKeys(NUMBER_104 + "DPAD_RIGHT ENTER");
		//sendKeys("DPAD_RIGHT ENTER");
		String mathResult = result.getText().toString();
		
		assertTrue("Convert result should be " + CONVERT_RESULT_FAHRENHEIT + " but was " + mathResult.toString(), mathResult.equals(CONVERT_RESULT_FAHRENHEIT));
}
}