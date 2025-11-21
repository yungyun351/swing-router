package com.marttapps.swingrouter;

import java.awt.BorderLayout;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import javax.swing.JPanel;

public class Router {

	private final JPanel routerView = new JPanel(new BorderLayout());
	private final Map<String, Supplier<Route>> routes = new HashMap<>();
	private final Map<String, Object> params = new HashMap<>();

	public JPanel getRouterView() {
		return routerView;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void register(String path, Supplier<Route> builder) {
		routes.put(path, builder);
	}

	public void navigate(Route route, Map<String, Object> params) {
		this.params.clear();
		this.params.putAll(params);
		
		RoutePanel routePanel;
		try {
			routePanel = route.getPanelClass() //
					.getConstructor(Router.class) //
					.newInstance(this);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return;
		}

		this.routerView.removeAll();
		this.routerView.add(routePanel, BorderLayout.CENTER);
		this.routerView.revalidate();
		this.routerView.repaint();
	}

	public void navigate(Route route) {
		navigate(route, new HashMap<>());
	}
}
