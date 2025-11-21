package com.marttapps.swingrouter.feature;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.marttapps.swingrouter.RoutePanel;
import com.marttapps.swingrouter.Router;
import com.marttapps.swingrouter.config.Routes;

public class HomePanel extends RoutePanel {

	private static final long serialVersionUID = 1L;

	public HomePanel(Router router) {
		super(router);
		this.render();
	}

	private void render() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		//
		Box headerBox = Box.createHorizontalBox();
		JLabel headerLabel = new JLabel();
		headerLabel.setText("Home Page");
		headerBox.add(headerLabel);
		this.add(headerBox);

		//
		Box footerBox = Box.createHorizontalBox();
		JButton execBtn = new JButton("Go Form Page");
		execBtn.addActionListener(e -> {
			router.navigate(Routes.FORM);
		});
		footerBox.add(execBtn, BorderLayout.CENTER);
		this.add(footerBox);
	}

}
