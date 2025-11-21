package com.marttapps.swingrouter;

import javax.swing.JPanel;

public class RoutePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	protected final transient Router router;

	protected RoutePanel(Router router) {
		this.router = router;
	}

}
