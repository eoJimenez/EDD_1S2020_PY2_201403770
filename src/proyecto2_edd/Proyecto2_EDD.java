
package proyecto2_edd;

public class Proyecto2_EDD {

    public static void main(String[] args) {
        /*String cadena1, cadena2;
        cadena1 = "total";
        cadena2 = "prueba";

        if (cadena1.compareTo(cadena2) == 0) {
            System.out.println("cadena1 y cadena2 son iguales");
        } else if (cadena1.compareTo(cadena2) < 0) {
            System.out.println("cadena1 va antes que cadena2");
        } else if (cadena1.compareTo(cadena2) > 0) {
            System.out.println("cadena2 va después que cadena1");
        }*/
        
        ArbolAVL arbol = new ArbolAVL();
        arbol.insertar("luis");
        arbol.insertar("ana");
        arbol.insertar("ricardo");
        arbol.insertar("edgar");
        arbol.insertar("antonio");
        arbol.insertar("pedro");
        arbol.insertar("carlos");
        arbol.insertar("juan");
        arbol.PreOrden(arbol.obtenerRaiz());
        System.out.println("");
        arbol.InOrden(arbol.obtenerRaiz());
        System.out.println("");
        arbol.PostOrden(arbol.obtenerRaiz());
        System.out.println("");
    }

}
