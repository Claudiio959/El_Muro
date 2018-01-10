package App;
import Window.VentanaPrincipal;

/** 
*	Clase principal que lanzará la aplicación completa
* @author Paco Gomez
* @author www.cookingsoftware.es
* @version 1.0
*/
public class Principal {

	public static void main(String[] args) {
		try {
			VentanaPrincipal frame = new VentanaPrincipal();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
