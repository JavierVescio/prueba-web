package vista.sectorProducto;

import negocio.sectorProducto.ProductoABM;

public class AgregarBebida {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProductoABM abmProducto = new ProductoABM();
		String nombreProducto = "Manaos";
		String descripcionProducto = "Bebida de cola";
		String imagenProducto = "-";
		String notasBebida = "Botella pl�stica 600ml";
		
		try {
			int idProducto = abmProducto.agregarBebida(nombreProducto, descripcionProducto, imagenProducto, notasBebida);
			System.out.println("idProducto: " + idProducto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
