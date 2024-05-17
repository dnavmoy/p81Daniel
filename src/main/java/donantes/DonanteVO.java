/*
 * Clase para mapear los datos de la tabla Persona
 */

package donantes;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;


public class DonanteVO {
    private int id_paciente;
    private String nombre;
    private String fechaNacimiento; 
    private String grupoSanguineo;
    private String rh;
    private int numeroDonaciones;

    public DonanteVO(int id_paciente, String nombre, String fechaNacimiento, String grupoSanguineo, String rh, int numeroDonaciones) {
        this.id_paciente = id_paciente;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.grupoSanguineo = grupoSanguineo;
        this.rh = rh;
        this.numeroDonaciones = numeroDonaciones;
    }

   

    public DonanteVO(){
        
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        
    }
    
    public void setFechaNacimiento(LocalDate fechalocaldate) {
        this.fechaNacimiento = fechalocaldate.format(DateTimeFormatter.ofPattern("MM/dd/uuuu"));
    }
    
    public LocalDate getFechaLocalDate(){
        return LocalDate.parse(this.fechaNacimiento, DateTimeFormatter.ofPattern("MM/dd/uuuu"));
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public int getNumeroDonaciones() {
        return numeroDonaciones;
    }

    public void setNumeroDonaciones(int numeroDonaciones) {
        this.numeroDonaciones = numeroDonaciones;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DonanteVO{");
        sb.append("id_paciente=").append(id_paciente);
        sb.append(", nombre=").append(nombre);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", grupoSanguineo=").append(grupoSanguineo);
        sb.append(", rh=").append(rh);
        sb.append(", numeroDonaciones=").append(numeroDonaciones);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id_paciente;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DonanteVO other = (DonanteVO) obj;
        return this.id_paciente == other.id_paciente;
    }
    
   
}
