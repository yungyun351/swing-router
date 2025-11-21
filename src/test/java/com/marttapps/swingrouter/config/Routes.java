package com.marttapps.swingrouter.config;

import com.marttapps.swingrouter.Route;
import com.marttapps.swingrouter.RoutePanel;
import com.marttapps.swingrouter.feature.ArticlePanel;
import com.marttapps.swingrouter.feature.FormPanel;
import com.marttapps.swingrouter.feature.HomePanel;

public enum Routes implements Route {
	HOME(HomePanel.class), //
	FORM(FormPanel.class), //
	ARTICLE(ArticlePanel.class), //
	//
	;

	private final Class<? extends RoutePanel> panelClass;

	private Routes(Class<? extends RoutePanel> panelClass) {
		this.panelClass = panelClass;
	}

	public Class<? extends RoutePanel> getPanelClass() {
		return panelClass;
	}

}
