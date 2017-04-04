package main.view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import main.viewmodel.CargarDatos;

@SuppressWarnings("serial")
public class CargarDatosView extends Dialog<CargarDatos> {

	public CargarDatosView(WindowOwner owner) {
		super(owner, new CargarDatos());
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel).setCaption("GUARDAR")
		 						.onClick(()-> this.getModelObject().cargarDatosEstudiante());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("CARGAR DATOS DE ESTUDIANTE");
		this.setIconImage("src/main/icono.png");
		
		mainPanel.setLayout(new VerticalLayout());
		
		new Label(mainPanel).setText("Nombre: ");
		
		new TextBox(mainPanel).bindValueToProperty("first_name");
		
		new Label(mainPanel).setText("Apellido: ");
		
		new TextBox(mainPanel).bindValueToProperty("last_name");
		
		new Label(mainPanel).setText("Legajo: ");
		
		new TextBox(mainPanel).bindValueToProperty("code");
		
		new Label(mainPanel).setText("Usuario de GitHub: ");
		
		new TextBox(mainPanel).bindValueToProperty("github_user");
	}
}
