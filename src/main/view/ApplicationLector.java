package main.view;

import java.awt.Color;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;

import main.model.Estudiante;

@SuppressWarnings("serial")
public class ApplicationLector extends MainWindow<Estudiante>{

	public ApplicationLector() {
		super(new Estudiante());
	}

	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("LECTOR DE NOTAS");
		this.setIconImage("src/main/icono.png");
		mainPanel.setLayout(new VerticalLayout());
		
		new Label(mainPanel).setText("BIENVENIDO!!").setBackground(Color.ORANGE);
		new Label(mainPanel).setText("SELECCIONE UNA OPCIÓN").setBackground(Color.ORANGE);

		new Button(mainPanel).setCaption("CONSULTAR DATOS");
		
		new Button(mainPanel).setCaption("CARGAR DATOS");
	}
}
