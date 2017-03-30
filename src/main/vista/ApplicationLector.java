package main.vista;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;

import main.modelo.Estudiante;

@SuppressWarnings("serial")
public class ApplicationLector extends MainWindow<Estudiante>{

	public ApplicationLector() {
		super(new Estudiante());
	}

	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Lector de Notas");
		mainPanel.setLayout(new VerticalLayout());
		
		new Label(mainPanel).setText("Bienvenido, seleccione una opción");

		new Button(mainPanel).setCaption("Consultar notas");
		
		new Button(mainPanel).setCaption("Cargar notas");
	}
}
