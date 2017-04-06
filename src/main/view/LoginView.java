package main.view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.PasswordField;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import main.viewmodel.Login;

@SuppressWarnings("serial")
public class LoginView extends SimpleWindow<Login> {
	
	public LoginView(WindowOwner parent) {
		super(parent, new Login());
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		
		new Button(actionsPanel).setCaption("ACEPTAR")
								.onClick(this::login);
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("LOGIN");
		this.setIconImage("src/main/icono.png");
		
		mainPanel.setLayout(new VerticalLayout());
		
		new Label(mainPanel).setText("TOKEN: ");
		
		new PasswordField(mainPanel).setWidth(200).bindValueToProperty("token");
	}
	
	public void login() {
		Dialog<?> dialog = null;
		if(this.getModelObject().isValidToken(this)) {
			dialog = new LectorNotasView(this);
			dialog.open();
		}
	}	
}