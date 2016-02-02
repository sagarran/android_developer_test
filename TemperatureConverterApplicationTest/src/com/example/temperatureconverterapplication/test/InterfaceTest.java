package com.example.temperatureconverterapplication.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.example.temperatureconverterapplication.R;
import com.example.temperatureconverterapplication.MainActivity;

public class InterfaceTest extends
		ActivityInstrumentationTestCase2<MainActivity> {
	private EditText et;

	public InterfaceTest() {
		super("com.example.temperatureconverterapplication", MainActivity.class);
		
	}

	protected void setUp() throws Exception {
		super.setUp();
		MainActivity mainActivity = getActivity();
		et = (EditText) mainActivity.findViewById(R.id.editText);
		
	}
	public final void testHasInputFields() {
		  assertNotNull(et);
		  //assertNotNull(mFahrenheit);
		}
	
	public final void testFieldsShouldStartEmpty() {
		  assertEquals("", et.getText().toString());
		  //assertEquals("", mFahrenheit.getText().toString());
		}
}
