package main.view;

import java.awt.Color;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import main.Main;
import main.viewmodel.LectorNotas;

@SuppressWarnings("serial")
public class LectorNotasView extends SimpleWindow<LectorNotas> {


	public LectorNotasView(WindowOwner parent) {
		super(parent, new LectorNotas());
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
		
		new Button(actionsPanel).setCaption("CONSULTAR DATOS")
								.onClick(this::consultarDatosEstudiante());

//		new Button(actionsPanel).setCaption("CARGAR DATOS")
//								.onClick(this.cargarDatosEstudiante());
		
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("LECTOR DE NOTAS");
		this.setIconImage("src/main/icono.png");
		
		mainPanel.setLayout(new VerticalLayout());
		
		new Label(mainPanel).setText("BIENVENIDO!! \n SELECCIONE UNA OPCIÓN")
							.setBackground(Color.ORANGE);		
	}
	
	public void cargarDatosEstudiante() {
		Dialog<?> dialog = new CargarDatosView(this);
		dialog.open();
	}

	public void consultarDatosEstudiante() {
		Dialog<?> dialog = new ConsultarDatosView(this);
		dialog.open();
	}	
}
