package main.view;

import java.awt.Color;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import main.viewmodel.Login;

//public class LoginView 
@SuppressWarnings("serial")
public class LoginView extends SimpleWindow<Login> {
	
	public LoginView(WindowOwner parent) {
		super(parent, new Login());
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		
		new Button(actionsPanel).setCaption("ACEPTAR")
								.onClick(this::corroborarToken);
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("LOGIN");
		this.setIconImage("src/main/icono.png");
		
		mainPanel.setLayout(new VerticalLayout());
		
		new Label(mainPanel).setText("BIENVENIDO!! \n INGRESE UN TOKEN")
		.setBackground(Color.BLUE);	
		
		new Label(mainPanel).setText("TOKEN: ");
		
		new TextBox(mainPanel).bindValueToProperty("token");
	}
	
	public void corroborarToken() {
		Dialog<?> dialog = new LectorNotasView(this);
		dialog.open();
	}	

}

	
