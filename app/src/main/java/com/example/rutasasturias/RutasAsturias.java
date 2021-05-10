
package com.example.rutasasturias;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RutasAsturias {

    @SerializedName("Nombre")
    @Expose
    private String nombre;
    @SerializedName("Contacto")
    @Expose
    private String contacto;
    @SerializedName("Concejos")
    @Expose
    private String concejos;
    @SerializedName("Zona")
    @Expose
    private String zona;
    @SerializedName("Distancia")
    @Expose
    private String distancia;
    @SerializedName("Dificultad")
    @Expose
    private Integer dificultad;
    @SerializedName("TiempoAPie")
    @Expose
    private String tiempoAPie;
    @SerializedName("TiempoBTT")
    @Expose
    private String tiempoBTT;
    @SerializedName("TiempoCoche")
    @Expose
    private String tiempoCoche;
    @SerializedName("TiempoViasVerdes")
    @Expose
    private String tiempoViasVerdes;
    @SerializedName("TiempoAscension")
    @Expose
    private String tiempoAscension;
    @SerializedName("ContactoTexto")
    @Expose
    private String contactoTexto;
    @SerializedName("Codigo")
    @Expose
    private String codigo;
    @SerializedName("TipoDeRecorrido")
    @Expose
    private String tipoDeRecorrido;
    @SerializedName("Altitud")
    @Expose
    private String altitud;
    @SerializedName("Desnivel")
    @Expose
    private String desnivel;
    @SerializedName("SituacionGeografica")
    @Expose
    private String situacionGeografica;
    @SerializedName("PuntoDePartida")
    @Expose
    private String puntoDePartida;
    @SerializedName("Informacion")
    @Expose
    private String informacion;
    @SerializedName("Resumen")
    @Expose
    private String resumen;
    @SerializedName("InformacionTexto")
    @Expose
    private String informacionTexto;
    @SerializedName("Observaciones")
    @Expose
    private String observaciones;
    @SerializedName("Itinerario")
    @Expose
    private String itinerario;
    @SerializedName("TextoTramos")
    @Expose
    private String textoTramos;
    @SerializedName("Detalle")
    @Expose
    private String detalle;
    @SerializedName("DetalleImagen")
    @Expose
    private String detalleImagen;
    @SerializedName("DetalleTexto")
    @Expose
    private String detalleTexto;
    @SerializedName("Visualizador")
    @Expose
    private String visualizador;
    @SerializedName("Slide")
    @Expose
    private String slide;
    @SerializedName("SlideTitulo")
    @Expose
    private String slideTitulo;
    @SerializedName("SlideUrl")
    @Expose
    private String slideUrl;
    @SerializedName("TrazadoRuta")
    @Expose
    private String trazadoRuta;
    @SerializedName("TrazadoRutaGPX")
    @Expose
    private String trazadoRutaGPX;
    @SerializedName("TipoRuta")
    @Expose
    private String tipoRuta;
    @SerializedName("Folletos")
    @Expose
    private String folletos;
    @SerializedName("Folleto")
    @Expose
    private String folleto;
    @SerializedName("Tramos")
    @Expose
    private String tramos;
    @SerializedName("OrigenDestino")
    @Expose
    private String origenDestino;
    @SerializedName("DistanciaTramo")
    @Expose
    private String distanciaTramo;
    @SerializedName("DescripcionTramo")
    @Expose
    private String descripcionTramo;
    @SerializedName("Geolocalizacion")
    @Expose
    private String geolocalizacion;
    @SerializedName("Coordenadas")
    @Expose
    private String coordenadas;
    @SerializedName("FIELD43")
    @Expose
    private String field43;
    @SerializedName("FIELD44")
    @Expose
    private String field44;
    @SerializedName("FIELD45")
    @Expose
    private String field45;
    @SerializedName("FIELD46")
    @Expose
    private String field46;
    @SerializedName("FIELD47")
    @Expose
    private String field47;
    @SerializedName("FIELD48")
    @Expose
    private String field48;
    @SerializedName("FIELD49")
    @Expose
    private String field49;
    @SerializedName("FIELD50")
    @Expose
    private String field50;
    @SerializedName("FIELD51")
    @Expose
    private String field51;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getConcejos() {
        return concejos;
    }

    public void setConcejos(String concejos) {
        this.concejos = concejos;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public Integer getDificultad() {
        return dificultad;
    }

    public void setDificultad(Integer dificultad) {
        this.dificultad = dificultad;
    }

    public String getTiempoAPie() {
        return tiempoAPie;
    }

    public void setTiempoAPie(String tiempoAPie) {
        this.tiempoAPie = tiempoAPie;
    }

    public String getTiempoBTT() {
        return tiempoBTT;
    }

    public void setTiempoBTT(String tiempoBTT) {
        this.tiempoBTT = tiempoBTT;
    }

    public String getTiempoCoche() {
        return tiempoCoche;
    }

    public void setTiempoCoche(String tiempoCoche) {
        this.tiempoCoche = tiempoCoche;
    }

    public String getTiempoViasVerdes() {
        return tiempoViasVerdes;
    }

    public void setTiempoViasVerdes(String tiempoViasVerdes) {
        this.tiempoViasVerdes = tiempoViasVerdes;
    }

    public String getTiempoAscension() {
        return tiempoAscension;
    }

    public void setTiempoAscension(String tiempoAscension) {
        this.tiempoAscension = tiempoAscension;
    }

    public String getContactoTexto() {
        return contactoTexto;
    }

    public void setContactoTexto(String contactoTexto) {
        this.contactoTexto = contactoTexto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipoDeRecorrido() {
        return tipoDeRecorrido;
    }

    public void setTipoDeRecorrido(String tipoDeRecorrido) {
        this.tipoDeRecorrido = tipoDeRecorrido;
    }

    public String getAltitud() {
        return altitud;
    }

    public void setAltitud(String altitud) {
        this.altitud = altitud;
    }

    public String getDesnivel() {
        return desnivel;
    }

    public void setDesnivel(String desnivel) {
        this.desnivel = desnivel;
    }

    public String getSituacionGeografica() {
        return situacionGeografica;
    }

    public void setSituacionGeografica(String situacionGeografica) {
        this.situacionGeografica = situacionGeografica;
    }

    public String getPuntoDePartida() {
        return puntoDePartida;
    }

    public void setPuntoDePartida(String puntoDePartida) {
        this.puntoDePartida = puntoDePartida;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getInformacionTexto() {
        return informacionTexto;
    }

    public void setInformacionTexto(String informacionTexto) {
        this.informacionTexto = informacionTexto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getItinerario() {
        return itinerario;
    }

    public void setItinerario(String itinerario) {
        this.itinerario = itinerario;
    }

    public String getTextoTramos() {
        return textoTramos;
    }

    public void setTextoTramos(String textoTramos) {
        this.textoTramos = textoTramos;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getDetalleImagen() {
        return detalleImagen;
    }

    public void setDetalleImagen(String detalleImagen) {
        this.detalleImagen = detalleImagen;
    }

    public String getDetalleTexto() {
        return detalleTexto;
    }

    public void setDetalleTexto(String detalleTexto) {
        this.detalleTexto = detalleTexto;
    }

    public String getVisualizador() {
        return visualizador;
    }

    public void setVisualizador(String visualizador) {
        this.visualizador = visualizador;
    }

    public String getSlide() {
        return slide;
    }

    public void setSlide(String slide) {
        this.slide = slide;
    }

    public String getSlideTitulo() {
        return slideTitulo;
    }

    public void setSlideTitulo(String slideTitulo) {
        this.slideTitulo = slideTitulo;
    }

    public String getSlideUrl() {
        return slideUrl;
    }

    public void setSlideUrl(String slideUrl) {
        this.slideUrl = slideUrl;
    }

    public String getTrazadoRuta() {
        return trazadoRuta;
    }

    public void setTrazadoRuta(String trazadoRuta) {
        this.trazadoRuta = trazadoRuta;
    }

    public String getTrazadoRutaGPX() {
        return trazadoRutaGPX;
    }

    public void setTrazadoRutaGPX(String trazadoRutaGPX) {
        this.trazadoRutaGPX = trazadoRutaGPX;
    }

    public String getTipoRuta() {
        return tipoRuta;
    }

    public void setTipoRuta(String tipoRuta) {
        this.tipoRuta = tipoRuta;
    }

    public String getFolletos() {
        return folletos;
    }

    public void setFolletos(String folletos) {
        this.folletos = folletos;
    }

    public String getFolleto() {
        return folleto;
    }

    public void setFolleto(String folleto) {
        this.folleto = folleto;
    }

    public String getTramos() {
        return tramos;
    }

    public void setTramos(String tramos) {
        this.tramos = tramos;
    }

    public String getOrigenDestino() {
        return origenDestino;
    }

    public void setOrigenDestino(String origenDestino) {
        this.origenDestino = origenDestino;
    }

    public String getDistanciaTramo() {
        return distanciaTramo;
    }

    public void setDistanciaTramo(String distanciaTramo) {
        this.distanciaTramo = distanciaTramo;
    }

    public String getDescripcionTramo() {
        return descripcionTramo;
    }

    public void setDescripcionTramo(String descripcionTramo) {
        this.descripcionTramo = descripcionTramo;
    }

    public String getGeolocalizacion() {
        return geolocalizacion;
    }

    public void setGeolocalizacion(String geolocalizacion) {
        this.geolocalizacion = geolocalizacion;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getField43() {
        return field43;
    }

    public void setField43(String field43) {
        this.field43 = field43;
    }

    public String getField44() {
        return field44;
    }

    public void setField44(String field44) {
        this.field44 = field44;
    }

    public String getField45() {
        return field45;
    }

    public void setField45(String field45) {
        this.field45 = field45;
    }

    public String getField46() {
        return field46;
    }

    public void setField46(String field46) {
        this.field46 = field46;
    }

    public String getField47() {
        return field47;
    }

    public void setField47(String field47) {
        this.field47 = field47;
    }

    public String getField48() {
        return field48;
    }

    public void setField48(String field48) {
        this.field48 = field48;
    }

    public String getField49() {
        return field49;
    }

    public void setField49(String field49) {
        this.field49 = field49;
    }

    public String getField50() {
        return field50;
    }

    public void setField50(String field50) {
        this.field50 = field50;
    }

    public String getField51() {
        return field51;
    }

    public void setField51(String field51) {
        this.field51 = field51;
    }

}
