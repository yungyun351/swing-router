package com.marttapps.swingrouter.feature;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.marttapps.swingrouter.RoutePanel;
import com.marttapps.swingrouter.Router;
import com.marttapps.swingrouter.config.Routes;

public class FormPanel extends RoutePanel {

	private static final long serialVersionUID = 1L;

	public FormPanel(Router router) {
		super(router);
		this.render();
	}

	private void render() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		//
		Box headerBox = Box.createHorizontalBox();
		JLabel headerLabel = new JLabel();
		headerLabel.setText("Form Page");
		headerBox.add(headerLabel);
		this.add(headerBox);

		Box nameBox = Box.createHorizontalBox();
		JLabel nameLabel = new JLabel("name：");
		JTextField nameInput = new JTextField();
		nameInput.setColumns(15);
		nameInput.setMaximumSize(nameInput.getPreferredSize());
		nameBox.add(nameLabel);
		nameBox.add(nameInput);
		this.add(nameBox);

		Box ageBox = Box.createHorizontalBox();
		JLabel ageLabel = new JLabel("age：");
		SpinnerNumberModel model = new SpinnerNumberModel(1, 0, 120, 1);
		JSpinner ageSpinner = new JSpinner(model);
		ageSpinner.setMaximumSize(ageSpinner.getPreferredSize());
		ageBox.add(ageLabel);
		ageBox.add(ageSpinner);
		this.add(ageBox);

		//
		Box footerBox = Box.createHorizontalBox();
		JButton execBtn = new JButton("Go Article Page");
		execBtn.addActionListener(e -> {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("name", nameInput.getText());
			params.put("age", (Integer) ageSpinner.getValue());
			router.navigate(Routes.ARTICLE, params);
		});
		footerBox.add(execBtn, BorderLayout.CENTER);
		this.add(footerBox);
	}

}
