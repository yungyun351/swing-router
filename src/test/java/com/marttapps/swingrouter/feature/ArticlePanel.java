package com.marttapps.swingrouter.feature;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.marttapps.swingrouter.RoutePanel;
import com.marttapps.swingrouter.Router;
import com.marttapps.swingrouter.config.Routes;

public class ArticlePanel extends RoutePanel {

	private static final long serialVersionUID = 1L;

	public ArticlePanel(Router router) {
		super(router);
		this.render();
	}

	private void render() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		//
		Box headerBox = Box.createHorizontalBox();
		JLabel headerLabel = new JLabel();
		headerLabel.setText("Article Page");
		headerBox.add(headerLabel);
		this.add(headerBox);

		Box descBox = Box.createHorizontalBox();
		String name = (String) router.getParams().get("name");
		int age = (int) router.getParams().get("age");
		JLabel desclabel = new JLabel(String.format("Hi, %s. You are %s years old.", name, age));
		descBox.add(desclabel);
		this.add(descBox);

		//
		Box footerBox = Box.createHorizontalBox();
		JButton execBtn = new JButton("Go Home Page");
		execBtn.addActionListener(e -> {
			router.navigate(Routes.HOME);
		});
		footerBox.add(execBtn, BorderLayout.CENTER);
		this.add(footerBox);
	}

}
