package main.view;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
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
		new Button(actionsPanel).setCaption("CERRAR").onClick(this::cancel);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("CONSULTAR DATOS DE ESTUDIANTE");
		this.setIconImage("src/main/icono.png");
		
		Panel panel = new Panel(mainPanel);
		panel.setLayout(new ColumnLayout(2));
		
		mainPanel.setLayout(new VerticalLayout());
		
		new Label(panel).setText("Nombre: ");
		
		new Label(panel).setWidth(150)
		                .bindValueToProperty("first_name");
		
		new Label(panel).setText("Apellido: ");
		
		new Label(panel).setWidth(150)
		                .bindValueToProperty("last_name");
		
		new Label(panel).setText("Legajo: ");
		
		new Label(panel).setWidth(150)
		                .bindValueToProperty("code");
		
		new Label(panel).setText("Usuario de GitHub: ");
		
		new Label(panel).setWidth(150)
		                .bindValueToProperty("github_user");
		
		new Label(mainPanel).setText("Asignaciones: ");
		
		Table<Asignacion> tableTareas = new Table<>(mainPanel, Asignacion.class);
		
		Column<Asignacion> columnaTitulo = new Column<Asignacion>(tableTareas);
		columnaTitulo.setTitle("Título").bindContentsToProperty("title");
		
		Column<Asignacion> columnaDescripcion = new Column<Asignacion>(tableTareas);
		columnaDescripcion.setTitle("Descripción").bindContentsToProperty("description");
		
		tableTareas.setHeight(300);
		tableTareas.setWidth(600);
		
		new Label(mainPanel).setText("Notas: ");

		Table<Nota> tableNotas = new Table<>(mainPanel, Nota.class);
//		tableNotas.bindItemsToProperty("grades");
//		
//		Column<Nota> columnaCalificacion = new Column<Nota>(tableNotas);
//		columnaCalificacion.setTitle("Calificación").bindContentsToProperty("calificacion");
//		
//		Column<Nota> columnaFechaCreacion = new Column<Nota>(tableNotas);
//		columnaFechaCreacion.setTitle("Fecha de Creación").bindContentsToProperty("fechaCreacion");
//		
//		Column<Nota> columnaFechaModificacion = new Column<Nota>(tableNotas);
//		columnaFechaModificacion.setTitle("Fecha de Modificación").bindContentsToProperty("fechaModificacion");
		
		tableNotas.setHeight(300);
		tableNotas.setWidth(600);
		tableNotas.setNumberVisibleRows(3);
	}
}
