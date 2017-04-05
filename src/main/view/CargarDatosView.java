package main.view;

import org.uqbar.arena.layout.ColumnLayout;
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
		
		new Button(actionsPanel).setCaption("CERRAR").onClick(this::cancel);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("CARGAR DATOS DE ESTUDIANTE");
		this.setIconImage("src/main/icono.png");
		
		Panel panel = new Panel(mainPanel);
		panel.setLayout(new ColumnLayout(2));
		
		new Label(panel).setText("Nombre: ");
		
		new TextBox(panel).setWidth(100)
		                  .bindValueToProperty("first_name");
		
		new Label(panel).setText("Apellido: ");
		
		new TextBox(panel).setWidth(100)
		                  .bindValueToProperty("last_name");
		
		new Label(panel).setText("Legajo: ");
		
		new TextBox(panel).setWidth(100)
		                  .bindValueToProperty("code");
		
		new Label(panel).setText("Usuario de GitHub: ");
		
		new TextBox(panel).setWidth(100)
		                  .bindValueToProperty("github_user");
	}
}
