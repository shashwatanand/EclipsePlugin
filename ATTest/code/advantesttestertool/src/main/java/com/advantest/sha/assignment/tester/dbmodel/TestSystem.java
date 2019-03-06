package com.advantest.sha.assignment.tester.dbmodel;

import java.util.List;

import com.advantest.sha.assignment.tester.utils.SupportedOS;

public class TestSystem {
	private String id;
	private String name;
	private SupportedOS supportedOS;
	private boolean isBusy;
	private List<Devices> devices;
}
