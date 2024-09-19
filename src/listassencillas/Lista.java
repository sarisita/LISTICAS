/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listassencillas;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SARIC
 */
public class Lista {
    
 Nodo cab;
    
    
    public Lista{
        cab=null;
    }
    
    public Nodo getBuscarId(String iDE){
        if(cab==null)
            return null;
        else{
            Nodo p = cab;
            while(p!=null){
                if((p.getiD()).equals(iDE))
                    return p;
                else
                    p=p.sig;  
            }
            return null;
        }
    }
    
    public boolean getEsVacia(){
        
        return cab==null?true:false;
        
    }
    
    public int getLongLista(){
        int cont=0;
        Nodo p=null;
        if(cab==null)
            return 0;
        else{
            p=cab;
            while(p!=null){
                
                cont++;
                
                p=p.sig;
                
            }
            
            return cont;
        }
    }
    public Nodo getCrearNodo(
        JTextField JtfID,
        JTextField Jtfnomb,
        JTextField JtfSexo,
        JTextField JtfEdad,
        JTextField JtfCurso,
        JTextField JtfAcudiente,
        JTextField JtTlfAcudiente
    
    
    ){
        Nodo buscar = null;        
        try {                        
            buscar = getBuscarId(JtfID.getText());
            if (buscar != null) {
                JOptionPane.showMessageDialog(null,
                    "Error: Este Id ya se encuentra "
                    + "registrado.  Reemplazar código!"); 
                JtfID.setText("");
                JtfID.requestFocus();                
                return null;
            }            
            //Una vez capturados los datos, se crea en memoria el nodo
            Nodo info = new Nodo(
                JtfID.getText(), 
                Jtfnomb.getText(),
                JtfSexo.getText(),
                Integer.parseInt(JtfEdad.getText()),
                Integer.parseInt(JtfCurso.getText()),
                JtfAcudiente.getText(),
                JtTlfAcudiente.getText());
            return info;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);            
            return null;
        }
    }
    public void setAddInicio(
        JTextField JtfID,
        JTextField Jtfnomb,
        JTextField JtfSexo,
        JTextField JtfEdad,
        JTextField JtfCurso,
        JTextField JtfAcudiente,
        JTextField JtTlfAcudiente){
        //Creamos el nodo que se desea registrar
        //en la lista
        Nodo info = getCrearNodo(
             JtfID,
         Jtfnomb,
         JtfSexo,
         JtfEdad,
         JtfCurso,
         JtfAcudiente,
         JtTlfAcudiente
        );
        
        if (info != null) {
            if (cab == null) {
                cab = info;
                JOptionPane.showMessageDialog(null,
                        "Se ha registrado un nuevo elemento "
                        + "a la lista.  La lista estaba vacía.");
            } else {
                //Enlazamos el nuevo nodo a la lista
                info.sig = cab;
                //Ahora se debe mover cab al primer 
                //nuevo elemento
                cab = info;
                JOptionPane.showMessageDialog(null,
                        "Se ha registrado un nuevo elemento al "
                        + "inicio de la lista.");
            }
        }else{            
        }
    }
    
    //Método: getUltimo
    //Coloca un apuntador en el último nodo de la lista.
    public Nodo getUltimo(){
        if(cab==null)
            return null;
        else{
            Nodo p = cab;
            while (p.sig != null) {
                p = p.sig;
            }
            return p;
        }
    }
    public void setAddFinal(
        JTextField JtfID,
        JTextField Jtfnomb,
        JTextField JtfSexo,
        JTextField JtfEdad,
        JTextField JtfCurso,
        JTextField JtfAcudiente,
        JTextField JtTlfAcudiente){
        //Creamos el nuevo nodo a registrar
        Nodo info = getCrearNodo(
             JtfID,
         Jtfnomb,
       JtfSexo,
        JtfEdad,
        JtfCurso,
        JtfAcudiente,
        JtTlfAcudiente
        );
        Nodo p;
        if (info != null) {
            if (cab == null) {
                cab = info;
                JOptionPane.showMessageDialog(null,
                        "Se ha registrado un nuevo elemento "
                        + "a la lista.  La lista estaba vacía.");
            } else {
                
                Nodo ultimo=getUltimo();
                ultimo.sig = info;
                JOptionPane.showMessageDialog(null,
                        "Se ha registrado un nuevo elemento al "
                        + "final de la lista.");
            }
        }else{            
        }
    }
    
    public void setRegistrarFilaJTable(DefaultTableModel miModelo,
        int Fila, Nodo info){
        miModelo.setValueAt(info.getiD(), Fila, 0);
        miModelo.setValueAt(info.getNombre(), Fila, 1);
        miModelo.setValueAt(info.getSexo(), Fila, 2);
        miModelo.setValueAt(info.getEdad(), Fila, 3);
        miModelo.setValueAt(info.getCurso(), Fila, 4);
        miModelo.setValueAt(info.getAcudiente(), Fila, 5);
        miModelo.setValueAt(info.getTelefonoAcudiente(), Fila, 6);
    }
    
    public void setLlenarJTable(JTable tab){
        Nodo p=cab;
        int i=0;
        DefaultTableModel miModelo=new DefaultTableModel();
        miModelo.addColumn("ID");
        miModelo.addColumn("Nombre");
        miModelo.addColumn("Sexo");
        miModelo.addColumn("Edad");
        miModelo.addColumn("Curso");
        miModelo.addColumn("Acudiente");
        miModelo.addColumn("Telefono Acudiente");
        while(p!=null){                        
            miModelo.addRow(new Object[]{"", "", "", "", "","",""});              
            setRegistrarFilaJTable(miModelo,i,p);
            p=p.sig;
            i++;
        }
        tab.setModel(miModelo);
    }public void setModificarData(
        String JtfID,
        String Jtfnomb,
        String JtfSexo,
        int JtfEdad,
        int JtfCurso,
        String JtfAcudiente,
        String JtTlfAcudiente
    ){
        if(cab==null)
            JOptionPane.showMessageDialog(null, 
                "Lista vacía");
        else{
            Nodo buscar=getBuscarId(JtfID);
            if(buscar==null)
                JOptionPane.showMessageDialog(null, 
                    "El ID seleccionado no existe!");
            else{
                try{
                    buscar.setiD(JtfID);
                    buscar.setNombre(Jtfnomb);
                    buscar.setSexo(JtfSexo);
                    buscar.setEdad(JtfEdad);
                    buscar.setCurso(JtfCurso);
                    buscar.setAcudiente(JtfAcudiente);
                    buscar.setTelefonoAcudiente(JtTlfAcudiente);
                  
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, 
                        ""+e);                    
                }
            }
        }
    }
    public Nodo getAnterior(Nodo actual){
        Nodo anterior=null;
        if(getEsVacia())
            return null;
        else{
            anterior=cab;
            while(anterior.sig!=actual)
                anterior=anterior.sig;
            return anterior;
        }
    }
    public void setElimCodigo(String id){
        if(getEsVacia()){
            JOptionPane.showMessageDialog(null, 
                "La lista no tiene elementos!");
        }else{
            Nodo p, q, anterior=null;            
            p=getBuscarId(id);
            if(p==null)
               JOptionPane.showMessageDialog(null, 
                "El id buscado para eliminar NO"
                + " se encuentra registrado!");
            else{
                if((p==cab)&&(cab.sig==null)){
                    cab=null;
                    JOptionPane.showMessageDialog(null, 
                    "Elemento eliminado, la lista esta vacía!");
                }
                else if((p==cab)&&(cab.sig!=null)){
                    cab=cab.sig;
                    p.sig=null;
                    p=null;
                    JOptionPane.showMessageDialog(null, 
                    "Elemento eliminado, en el inicio de la"
                    + " lista!");
                }
                else if(p.sig==null){
                    anterior=getAnterior(p);
                    anterior.sig=null;
                    p=null;
                    JOptionPane.showMessageDialog(null, 
                    "Elemento eliminado, al final de la"
                    + " lista!");
                }else{                    
                    anterior=getAnterior(p);
                    anterior.sig=p.sig;
                    p.sig=null;
                    p=null;
                    JOptionPane.showMessageDialog(null, 
                    "Elemento eliminado!");
                }
            }
        }
    }
    
    
}
