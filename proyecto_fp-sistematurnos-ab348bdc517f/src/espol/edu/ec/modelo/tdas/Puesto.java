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
public class Puesto {
    private int id;
    private Medico medico;
    private Paciente paciente;
//    private boolean libre;
    public static int contadorPuesto = 0;
    
    public Puesto(){
        this.id= ++contadorPuesto;
        //Al inicio el puesto no tendra un medico asignado
        this.medico= null;
        this.paciente= null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
   public boolean tieneEncargado(){
       return medico != null;
   }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Puesto other = (Puesto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
   
   
    
    
}
