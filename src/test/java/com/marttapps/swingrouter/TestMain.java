package com.marttapps.swingrouter;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.junit.Test;

import com.marttapps.swingrouter.config.Routes;

public class TestMain {

	@Test
	public void testRouter() //
//			throws InterruptedException //
	{
		Router router = new Router(Routes.HOME);

		JFrame frame = new JFrame("Swing Router Example");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(1000, 300);
		frame.setLayout(new BorderLayout(10, 10));
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);

		Box container = Box.createVerticalBox();

		Box headerBox = Box.createHorizontalBox();
		JLabel headerLabel = new JLabel();
		headerLabel.setText("This is header");
		headerBox.add(headerLabel);
		container.add(headerBox);
		container.add(router.getRouterView());

		Box footerBox = Box.createHorizontalBox();
		JLabel footerLabel = new JLabel();
		footerLabel.setText("This is footer");
		footerBox.add(footerLabel);
		container.add(footerBox);

		frame.add(container);
		frame.setVisible(true);

//		synchronized (frame) {
//			frame.wait();
//		}
	}

}
