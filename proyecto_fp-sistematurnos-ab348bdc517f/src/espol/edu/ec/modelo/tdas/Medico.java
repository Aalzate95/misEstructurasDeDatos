/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.modelo.tdas;

/**
 *
 * @author Charles
 */
public class Medico {

    

    private String cedula;
    private String nombres;
    private String apellidos;
    private int edad;
    private Puesto puesto;
    private Puesto puestoDeCambio;
//    private int idpuesto;

    public Medico(String cedula, String nombres, String apellidos, int edad) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        puesto = null;
        puestoDeCambio = null;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    

    public String getNombres() {
        return nombres;
    }

    public Puesto getPuestoDeCambio() {
        return puestoDeCambio;
    }

    public void setPuestoDeCambio(Puesto puestoDeCambio) {
        this.puestoDeCambio = puestoDeCambio;
    }

    public void setNombres(String Nombre) {
        this.nombres = Nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.apellidos = Apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String Cedula) {
        this.cedula = Cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int Edad) {
        this.edad = Edad;
    }
    
    public boolean tieneConsultorio(){
        return puesto != null;
    }

    @Override
    public String toString() {
        return "Id: "+cedula+"| Nombre: "+nombres+" "+apellidos;
    }
    
    public boolean ejecutarCambio() {
        if (puestoDeCambio != null) {
            if (puesto != null) {
                puesto.setMedico(null);
            }
            puestoDeCambio.getMedico().setPuesto(null);
            puesto = puestoDeCambio;
            puestoDeCambio.setMedico(this);
            puestoDeCambio = null;
            return true;
        }
        return false;
    }
    
}
