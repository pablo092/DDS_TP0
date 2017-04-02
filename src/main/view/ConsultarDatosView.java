package main.view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import main.viewmodel.ConsultarDatos;

@SuppressWarnings("serial")
public class ConsultarDatosView extends Window<ConsultarDatos>{

	public ConsultarDatosView(WindowOwner owner, ConsultarDatos model) {
		super(owner, model);
	}

	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("CONSULTAR DATOS DE ESTUDIANTE");
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
		
		new Label(mainPanel).setText("Asignaciones: ");
		
		new Table(mainPanel, null).bindValueToProperty("assignments");
		
		new Label(mainPanel).setText("Notas: ");
		
		new Table(mainPanel, null).bindValueToProperty("grades");
		
		new Button(mainPanel).setCaption("CONSULTAR")
							 .onClick(()-> this.getModelObject().consultarDatosEstudiante());
	}
}
