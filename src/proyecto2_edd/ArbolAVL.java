/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_edd;

/**
 *
 * @author Jimènez
 */
public class ArbolAVL {
    private NodoAVL raiz;

    public ArbolAVL() {
        raiz = null;
    }
    public NodoAVL obtenerRaiz(){
        return raiz;
    }
    
    //MÉTODO BUSCAR NODO
    public NodoAVL buscar(String d, NodoAVL r){
        if(raiz == null){
            return null;
        }else if(r.dato.equals(d)){
            return r;
        }else if(r.dato.compareTo(d)< 0){
            return buscar(d,r.nodoIzq);
        }else{
            return buscar(d,r.nodoDer);
        }
    }
    
    //OBTENER EL FACTOR DE EQUILIBRIO
    public int ObtenerFE(NodoAVL x){
        if(x == null){
            return -1;
        }else{
            return x.fe;
        }
    }
    
    //ROTACIÓN SIMPLE IZQUIERDA
    public NodoAVL RotacionIzquierda(NodoAVL c){
        NodoAVL auxiliar = c.nodoIzq;
        c.nodoIzq = auxiliar.nodoDer;
        auxiliar.nodoDer = c;
        c.fe = Math.max(ObtenerFE(c.nodoIzq), ObtenerFE(c.nodoDer)) + 1;
        auxiliar.fe = Math.max(ObtenerFE(auxiliar.nodoIzq), ObtenerFE(auxiliar.nodoDer)) + 1;
        return auxiliar;
    }
    
    //ROTACION SIMPLE DERECHA
    public NodoAVL RotacionDerecha(NodoAVL c){
        NodoAVL auxiliar = c.nodoDer;
        c.nodoDer = auxiliar.nodoIzq;
        auxiliar.nodoIzq = c;
        c.fe = Math.max(ObtenerFE(c.nodoIzq), ObtenerFE(c.nodoDer)) + 1;
        auxiliar.fe = Math.max(ObtenerFE(auxiliar.nodoIzq), ObtenerFE(auxiliar.nodoDer)) + 1;
        return auxiliar;
    }
    
    //ROTACION DOBLE IZQUIERDA
    public NodoAVL RotacionDobleIzquierda(NodoAVL c){
        NodoAVL temporal;
        c.nodoIzq = RotacionDerecha(c.nodoIzq);
        temporal = RotacionIzquierda(c);
        return temporal;
    }
    
    //ROTACION DOBLE DERECHA
    public NodoAVL RotacionDobleDerecha(NodoAVL c){
        NodoAVL temporal;
        c.nodoDer = RotacionIzquierda(c.nodoDer);
        temporal = RotacionDerecha(c);
        return temporal;
    }
    
    //INSERCION EN EL AVL
    public NodoAVL InsertarAVL(NodoAVL nuevo,NodoAVL subAr){
        NodoAVL nuevoPadre = subAr;
        if(nuevo.dato.compareTo(subAr.dato)< 0)
        {
            if(subAr.nodoIzq == null){
                subAr.nodoIzq = nuevo;
            }else{
                subAr.nodoIzq = InsertarAVL(nuevo, subAr.nodoIzq);
                if((ObtenerFE(subAr.nodoIzq)- ObtenerFE(subAr.nodoDer)== 2)){
                    if(nuevo.dato.compareTo(subAr.nodoIzq.dato)<0){
                        nuevoPadre = RotacionIzquierda(subAr);
                    }else{
                        nuevoPadre = RotacionDobleIzquierda(subAr);
                    }
                }
            }
        }else if(nuevo.dato.compareTo(subAr.dato)> 0){
            if(subAr.nodoDer == null){
                subAr.nodoDer = nuevo;
            }else{
                subAr.nodoDer = InsertarAVL(nuevo, subAr.nodoDer);
                if((ObtenerFE(subAr.nodoDer)- ObtenerFE(subAr.nodoIzq) == 2)){
                    if(nuevo.dato.compareTo(subAr.nodoDer.dato)>0){
                        nuevoPadre = RotacionDerecha(subAr);
                    }else{
                        nuevoPadre = RotacionDobleDerecha(subAr);
                    }
                }
            }
        }else{
            System.out.println("Nodo Duplicado");
        }
        //ACTUALIZANDO ALTURA FE
        if((subAr.nodoIzq == null) && (subAr.nodoDer != null)){
            subAr.fe = subAr.nodoDer.fe + 1;
        }else if((subAr.nodoDer == null) && (subAr.nodoIzq != null)){
            subAr.fe = subAr.nodoIzq.fe + 1;
        }else{
            subAr.fe = Math.max(ObtenerFE(subAr.nodoIzq), ObtenerFE(subAr.nodoDer)) + 1;
        }
        return nuevoPadre;
    }
    
    //INSERTAR
    public void  insertar(String d){
        NodoAVL nuevo = new NodoAVL(d);
        if(raiz == null){
            raiz = nuevo;
        }else{
            raiz = InsertarAVL(nuevo, raiz);
        }
    }
    
    //RECORRIDOS
    //INORDEN
    public void InOrden(NodoAVL r){
        if(r != null){
            InOrden(r.nodoIzq);
            System.out.print(r.dato + ", ");
            InOrden(r.nodoDer);
        }
    }
    //PREORDEN
    public void PreOrden(NodoAVL r) {
        if(r != null){
            System.out.print(r.dato + ", ");
            PreOrden(r.nodoIzq);
            PreOrden(r.nodoDer);
        }
    }
    //POSTORDEN
    public void PostOrden(NodoAVL r){
        if(r != null){
            PostOrden(r.nodoIzq);
            PostOrden(r.nodoDer);
            System.out.print(r.dato + ", ");
        }
    }
}
