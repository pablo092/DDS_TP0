package main.view;

import java.awt.Color;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;

import main.viewmodel.LectorNotas;

@SuppressWarnings("serial")
public class LectorNotasView extends MainWindow<LectorNotas> {

	public LectorNotasView() {
		super(new LectorNotas());
	}

	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("LECTOR DE NOTAS");
		this.setIconImage("src/main/icono.png");
		
		mainPanel.setLayout(new VerticalLayout());
		
		new Label(mainPanel).setText("BIENVENIDO!! \n SELECCIONE UNA OPCIÓN")
							.setBackground(Color.ORANGE);

		new Button(mainPanel).setCaption("CONSULTAR DATOS")
							 .onClick(()-> this.getModelObject().consultarDatosEstudiante());
		
		new Button(mainPanel).setCaption("CARGAR DATOS")
							 .onClick(()-> this.getModelObject().cargarDatosEstudiante());
	}
	
	public static void main(String[] args) {
		new LectorNotasView().startApplication();
	}
}
