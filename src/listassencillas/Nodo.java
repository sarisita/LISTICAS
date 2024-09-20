/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listassencillas;

import javax.swing.JOptionPane;

/**
 *
 * @author SARIC
 */
public class Nodo {

    private String iD;
    private String nombre;
    private String sexo;
    private int edad;
    private int curso;
    private String Acudiente;
    private String telefonoAcudiente;
    Nodo sig;

    public Nodo(String iD, String nombre, String sexo, int edad, int curso, String Acudiente, String telefonoAcudiente) {
        this.iD = iD;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.curso = curso;
        this.Acudiente = Acudiente;
        this.telefonoAcudiente = telefonoAcudiente;
        sig = null;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getAcudiente() {
        return Acudiente;
    }

    public void setAcudiente(String Acudiente) {
        this.Acudiente = Acudiente;
    }

    public String getTelefonoAcudiente() {
        return telefonoAcudiente;
    }

    public void setTelefonoAcudiente(String telefonoAcudiente) {
        this.telefonoAcudiente = telefonoAcudiente;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public void mostrarEst() {
        String msg = "ID : " + iD + "\n"
                + "Nombre : " + nombre + "\n"
                + "Sexo : " + sexo + "\n"
                + "Edad : " + edad + "\n"
                + "Curso: " + curso + "\n";
        JOptionPane.showMessageDialog(null, msg);
    }

    public void mostrarAcu() {
        String msg = "Nombre de Acudiente: " + Acudiente + "\nTelefono Acudiente: " + telefonoAcudiente;
        JOptionPane.showMessageDialog(null, msg);
    }

}
