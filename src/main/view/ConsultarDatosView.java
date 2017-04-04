package main.view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import main.model.Asignacion;
import main.model.Nota;
import main.viewmodel.ConsultarDatos;

@SuppressWarnings("serial")
public class ConsultarDatosView extends Dialog<ConsultarDatos> {

	public ConsultarDatosView(WindowOwner owner) {
		super(owner, new ConsultarDatos());
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel).setCaption("CONSULTAR")
								.onClick(()-> this.getModelObject().consultarDatosEstudiante());
		
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
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
		
		Table<Asignacion> tareas = new Table<Asignacion>(mainPanel, Asignacion.class);
		tareas.bindItemsToProperty("assignments");
		
		new Label(mainPanel).setText("Notas: ");
		
		Table<Nota> notas = new Table<Nota>(mainPanel, Nota.class);
		notas.bindItemsToProperty("grades");		
	}
}
