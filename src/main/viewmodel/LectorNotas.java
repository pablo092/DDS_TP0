package main.viewmodel;

import main.view.CargarDatosView;
import main.view.ConsultarDatosView;
import main.view.LectorNotasView;

public class LectorNotas {
	
	private ConsultarDatos consultar = new ConsultarDatos();
	private CargarDatos cargar = new CargarDatos();
	
	public void consultarDatosEstudiante(LectorNotasView lectorNotasView) {
		new ConsultarDatosView(lectorNotasView, consultar).open();
	}
	
	public void cargarDatosEstudiante(LectorNotasView lectorNotasView) {
		new CargarDatosView(lectorNotasView, cargar).open();
	}
}
