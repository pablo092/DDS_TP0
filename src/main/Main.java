package main;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import main.view.LoginView;

public class Main extends Application {
	
	public static void main(String[] args) {
		new Main().start();
	}

	@Override
	protected Window<?> createMainWindow() {
		return new LoginView(this);
	}

}
