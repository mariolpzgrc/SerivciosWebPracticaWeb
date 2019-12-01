package pojos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mariolpzgrc
 */
public class Documentos {
    private Integer id;
    private Integer idAlumno;
    private String identificacionOficial;
    private String actaNacimiento;
    private String comprobanteDomicilio;
    private String fotoInfatil;
    private String certificadoBachillerato;

    public Documentos(Integer id, Integer idAlumno, String identificacionOficial, String actaNacimiento, String comprobanteDomicilio, String fotoInfatil, String certificadoBachillerato) {
        this.id = id;
        this.idAlumno = idAlumno;
        this.identificacionOficial = identificacionOficial;
        this.actaNacimiento = actaNacimiento;
        this.comprobanteDomicilio = comprobanteDomicilio;
        this.fotoInfatil = fotoInfatil;
        this.certificadoBachillerato = certificadoBachillerato;
    }

    public Documentos() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getIdentificacionOficial() {
        return identificacionOficial;
    }

    public void setIdentificacionOficial(String identificacionOficial) {
        this.identificacionOficial = identificacionOficial;
    }

    public String getActaNacimiento() {
        return actaNacimiento;
    }

    public void setActaNacimiento(String actaNacimiento) {
        this.actaNacimiento = actaNacimiento;
    }

    public String getComprobanteDomicilio() {
        return comprobanteDomicilio;
    }

    public void setComprobanteDomicilio(String comprobanteDomicilio) {
        this.comprobanteDomicilio = comprobanteDomicilio;
    }

    public String getFotoInfatil() {
        return fotoInfatil;
    }

    public void setFotoInfatil(String fotoInfatil) {
        this.fotoInfatil = fotoInfatil;
    }

    public String getCertificadoBachillerato() {
        return certificadoBachillerato;
    }

    public void setCertificadoBachillerato(String certificadoBachillerato) {
        this.certificadoBachillerato = certificadoBachillerato;
    }
    
    
    
}
