package controller;

import model.BDD;
import view.ViewApplication;

public class BDDController {
	private BDD model;
	private ViewApplication view;
	
	public BDDController(BDD m, ViewApplication v) {
		model = m;
		view = v;
	}
}
