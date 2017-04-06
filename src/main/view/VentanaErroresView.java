package main.view;

import java.awt.Color;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import main.model.VentanaErroresViewModel;

@SuppressWarnings("serial")
public class VentanaErroresView extends Dialog<VentanaErroresViewModel> {
	
	private String mensajeError = null;
	
	public VentanaErroresView(WindowOwner parent, String sMensajeError) {
		super(parent, new VentanaErroresViewModel(sMensajeError));
		mensajeError = sMensajeError;
	}
	
	protected void addActions(Panel actionsPanel) {
		
		new Button(actionsPanel).setCaption("ACEPTAR").onClick(this::close);
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		new Label(mainPanel).setText(mensajeError)
				.setBackground(Color.RED);		
	}	
}
