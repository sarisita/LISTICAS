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

    public Lista() {
        cab = null;
    }

    public Nodo getBuscarNomb(String nomb) {
        if (cab == null) {
            return null;
        } else {
            Nodo p = cab;
            while (p != null) {
                if ((p.getNombre()).equalsIgnoreCase(nomb)) {
                    return p;
                } else {
                    p = p.sig;
                }
            }
            return null;
        }
    }

    public Nodo getBuscarId(String iDE) {
        if (cab == null) {
            return null;
        } else {
            Nodo p = cab;
            while (p != null) {
                if ((p.getiD()).equalsIgnoreCase(iDE)) {
                    return p;
                } else {
                    p = p.sig;
                }
            }
            return null;
        }
    }

    public boolean getEsVacia() {

        return cab == null ? true : false;

    }

    public int getLongLista() {
        int cont = 0;
        Nodo p = null;
        if (cab == null) {
            return 0;
        } else {
            p = cab;
            while (p != null) {

                cont++;

                p = p.sig;

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
    ) {
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
        } catch (Exception e) {
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
            JTextField JtTlfAcudiente) {
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
        } else {
        }
    }

    //Método: getUltimo
    //Coloca un apuntador en el último nodo de la lista.
    public Nodo getUltimo() {
        if (cab == null) {
            return null;
        } else {
            Nodo p = cab;
            while (p.sig != null) {
                p = p.sig;
            }
            return p;
        }
    }
    public void setAddMedio(
        JTextField JtfID,
        JTextField Jtfnomb,
        JTextField JtfSexo,
        JTextField JtfEdad,
        JTextField JtfCurso,
        JTextField JtfAcudiente,
        JTextField JtTlfAcudiente,
        int posicion) {
    
    // Crear el nuevo nodo con los datos de los JTextField
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
        // Si la lista está vacía o la posición es 0, insertar al inicio
        if (cab == null || posicion == 0) {
            setAddInicio(JtfID, Jtfnomb, JtfSexo, JtfEdad, JtfCurso, JtfAcudiente, JtTlfAcudiente);
        } else {
            // Recorremos la lista hasta la posición anterior a donde queremos insertar
            Nodo temp = cab;
            int contador = 0;

            while (temp != null && contador < posicion - 1) {
                temp = temp.sig;
                contador++;
            }

            // Si alcanzamos una posición válida, insertamos el nodo en medio
            if (temp != null) {
                info.sig = temp.sig;
                temp.sig = info;
                JOptionPane.showMessageDialog(null,
                        "Se ha registrado un nuevo elemento en la posición " + posicion + ".");
            } else {
                JOptionPane.showMessageDialog(null, "La posición es mayor al tamaño de la lista.");
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Error al crear el nodo.");
    }
}


    public void setAddFinal(
            JTextField JtfID,
            JTextField Jtfnomb,
            JTextField JtfSexo,
            JTextField JtfEdad,
            JTextField JtfCurso,
            JTextField JtfAcudiente,
            JTextField JtTlfAcudiente) {
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

                Nodo ultimo = getUltimo();
                ultimo.sig = info;
                JOptionPane.showMessageDialog(null,
                        "Se ha registrado un nuevo elemento al "
                        + "final de la lista.");
            }
        } else {
        }
    }

    public void setRegistrarFilaJTable(DefaultTableModel miModelo,
            int Fila, Nodo info) {
        miModelo.setValueAt(info.getiD(), Fila, 0);
        miModelo.setValueAt(info.getNombre(), Fila, 1);
        miModelo.setValueAt(info.getSexo(), Fila, 2);
        miModelo.setValueAt(info.getEdad(), Fila, 3);
        miModelo.setValueAt(info.getCurso(), Fila, 4);
        miModelo.setValueAt(info.getAcudiente(), Fila, 5);
        miModelo.setValueAt(info.getTelefonoAcudiente(), Fila, 6);
    }

    public void setLlenarJTable(JTable tab) {
        Nodo p = cab;
        int i = 0;
        DefaultTableModel miModelo = new DefaultTableModel();
        miModelo.addColumn("ID");
        miModelo.addColumn("Nombre");
        miModelo.addColumn("Sexo");
        miModelo.addColumn("Edad");
        miModelo.addColumn("Curso");
        miModelo.addColumn("Acudiente");
        miModelo.addColumn("Telefono Acudiente");
        while (p != null) {
            miModelo.addRow(new Object[]{"", "", "", "", "", "", ""});
            setRegistrarFilaJTable(miModelo, i, p);
            p = p.sig;
            i++;
        }
        tab.setModel(miModelo);
    }

    public void setModificarData(
            String JtfID,
            String Jtfnomb,
            String JtfSexo,
            int JtfEdad,
            int JtfCurso,
            String JtfAcudiente,
            String JtTlfAcudiente
    ) {
        if (cab == null) {
            JOptionPane.showMessageDialog(null,
                    "Lista vacía");
        } else {
            Nodo buscar = getBuscarId(JtfID);
            if (buscar == null) {
                JOptionPane.showMessageDialog(null,
                        "El ID seleccionado no existe!");
            } else {
                try {
                    buscar.setiD(JtfID);
                    buscar.setNombre(Jtfnomb);
                    buscar.setSexo(JtfSexo);
                    buscar.setEdad(JtfEdad);
                    buscar.setCurso(JtfCurso);
                    buscar.setAcudiente(JtfAcudiente);
                    buscar.setTelefonoAcudiente(JtTlfAcudiente);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "" + e);
                }
            }
        }
    }

    public Nodo getAnterior(Nodo actual) {
        Nodo anterior = null;
        if (getEsVacia()) {
            return null;
        } else {
            anterior = cab;
            while (anterior.sig != actual) {
                anterior = anterior.sig;
            }
            return anterior;
        }
    }

    public void getEstudiantesMdadPrQuin() {
        if (cab == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía");
            return;
        }

        Nodo p = cab;
        Nodo MayorP = null;
        Nodo MayorQ = null;

        while (p != null) {
            if (p.getCurso() == 1) {
                if (MayorP == null || p.getEdad() > MayorP.getEdad()) {
                    MayorP = p;
                }
            } else if (p.getCurso() == 5) {
                if (MayorQ == null || p.getEdad() > MayorQ.getEdad()) {
                    MayorQ = p;
                }
            }
            p = p.sig;
        }

        if (MayorP != null) {
            JOptionPane.showMessageDialog(null, "El estudiante de mayor edad en el primer curso es: " + MayorP.getNombre() + "\nSexo: " + MayorP.getSexo());
        } else {
            JOptionPane.showMessageDialog(null, "No hay estudiantes en el primer curso");
        }

        if (MayorQ != null) {
            JOptionPane.showMessageDialog(null, "El estudiante de mayor edad en el quinto curso es:" + MayorQ.getNombre() + "\nSexo: " + MayorQ.getSexo());
        } else {
            JOptionPane.showMessageDialog(null, "No hay estudiantes en el quinto curso");
        }
    }

    public void getMostrarNomb(String nom) {
        if (cab == null) {
            JOptionPane.showMessageDialog(null, "No hay Elementos en la lista");
        } else {
            Nodo p = getBuscarNomb(nom);
            if (p == null) {
                JOptionPane.showMessageDialog(null, "No Existe Este Estudiante");
            } else {
                p.mostrarEst();
                p.mostrarAcu();
            }
        }

    }

    public void getMostrarId(String id) {
        if (cab == null) {
            JOptionPane.showMessageDialog(null, "No hay Elementos en la lista");
        } else {
            Nodo p = getBuscarId(id);
            if (p == null) {
                JOptionPane.showMessageDialog(null, "No Existe Este Estudiante");
            } else {
                p.mostrarEst();
                p.mostrarAcu();
            }
        }

    }

    public void getInformeGPrim() {
        if (cab == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía");
            return;
        }

        Nodo p = cab;
        int cantidadMujeres = 0;
        int cantidadHombres = 0;

        while (p != null) {
            if (p.getCurso() == 1) {
                if (p.getSexo().equalsIgnoreCase("F")) {
                    cantidadMujeres++;
                } else if (p.getSexo().equalsIgnoreCase("M")) {
                    cantidadHombres++;
                }
            }
            p = p.sig;
        }

        JOptionPane.showMessageDialog(null, "Informe de primer curso:\nEL total Mujeres es: " + cantidadMujeres + "\nEl total Hombres es: " + cantidadHombres);
    }

    public void getInfoMujeresGradoQuinto() {
        if (cab == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía");
            return;
        }

        Nodo p = cab;
        int cantMujeres = 0;
        int sumaEdades = 0;
        StringBuilder nombres = new StringBuilder();

        while (p != null) {
            if (p.getCurso() == 5 && p.getSexo().equalsIgnoreCase("F")) {
                cantMujeres++;
                sumaEdades += p.getEdad();

            }
            p = p.sig;
        }

        if (cantMujeres > 0) {
            double edadPromedio = (double) sumaEdades / cantMujeres;
            JOptionPane.showMessageDialog(null, "El informe de las mujeres que hay en el curso quinto es:\n"
                    + "Nombres:\n" + nombres.toString()
                    + "Cantidad de mujeres: " + cantMujeres + "\n"
                    + "Edad promedio: " + edadPromedio + "\n");
        } else {
            JOptionPane.showMessageDialog(null, "No hay mujeres en el grado quinto.");
        }
    }

    public void setElim5toG(String id) {
        if (getEsVacia()) {
            JOptionPane.showMessageDialog(null,
                    "La lista no tiene elementos!");
        } else {
            Nodo p, q, anterior = null;
            p = getBuscarId(id);
            if (p == null) {
                JOptionPane.showMessageDialog(null,
                        "El estudiante buscado para eliminar NO"
                        + " se encuentra registrado!");
            } else {
                if (p.getCurso() != 5) {
                    JOptionPane.showMessageDialog(null,
                            "El Estudiante no se puede eliminar"
                            + " porque  no es de quinto grado!!");
                } else if ((p == cab) && (cab.sig == null)) {
                    cab = null;
                    JOptionPane.showMessageDialog(null,
                            "Elemento eliminado, la lista esta vacía!");
                } else if ((p == cab) && (cab.sig != null)) {
                    cab = cab.sig;
                    p.sig = null;
                    p = null;
                    JOptionPane.showMessageDialog(null,
                            "Elemento eliminado, en el inicio de la"
                            + " lista!");
                } else if (p.sig == null) {
                    anterior = getAnterior(p);
                    anterior.sig = null;
                    p = null;
                    JOptionPane.showMessageDialog(null,
                            "Elemento eliminado, al final de la"
                            + " lista!");
                } else {
                    anterior = getAnterior(p);
                    anterior.sig = p.sig;
                    p.sig = null;
                    p = null;
                    JOptionPane.showMessageDialog(null,
                            "Elemento eliminado!");
                }
            }
        }
    }
}
