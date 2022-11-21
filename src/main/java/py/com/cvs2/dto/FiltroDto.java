package py.com.cvs2.dto;

import java.io.Serializable;
import java.util.Date;

public class FiltroDto implements Serializable {

    private Date fechaInicio;

    private Date fechaFin;

    public FiltroDto() {
    }

    public FiltroDto(Date fechaInicio, Date fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "FiltroDto{" +
                "fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
