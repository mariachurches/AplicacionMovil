package com.example.rutasasturias;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ruta_table")
public class Ruta {
    @PrimaryKey
    @NonNull
    private String Nombre;
    private String Contacto;
    private String Concejos;
    private String Zona;
    private double Distancia;
    private int Dificultad;
    private String TiempoAPie;
    private String TiempoBTT;
    private String TiempoCoche;
    private String TiempoViasVerdes;
    private String TiempoAscension;
    private String ContactoTexto;
    private String Codigo;
    private String TipoDeRecorrido;
    private String Altitud;
    private String Desnivel;
    private String SituacionGeografica;
    private String PuntoDePartida;
    private String Informacion;
    private String Resumen;
    private String InformacionTexto;
    private String Observaciones;
    private String Itinerario;
    private String TextoTramos;
    private String Detalle;
    private String DetalleImagen;
    private String DetalleTexto;
    private String Visualizador;
    private String Slide;
    private String SlideTitulo;
    private String SlideUrl;
    private String TrazadoRuta;
    private String TrazadoRutaGPX;
    private String TipoRuta;
    private String Folletos;
    private String Folleto;
    private String Tramos;
    private String OrigenDestino;
    private int DistanciaTramo;
    private String DescripcionTramo;
    private String Geolocalizacion;
    private String Coordenadas;

    public Ruta(String nombre, String contacto, String concejos, String zona, double distancia, int dificultad, String tiempoAPie, String tiempoBTT, String tiempoCoche, String tiempoViasVerdes, String tiempoAscension, String contactoTexto, String codigo, String tipoDeRecorrido, String altitud, String desnivel, String situacionGeografica, String puntoDePartida, String informacion, String resumen, String informacionTexto, String observaciones, String itinerario, String textoTramos, String detalle, String detalleImagen, String detalleTexto, String visualizador, String slide, String slideTitulo, String slideUrl, String trazadoRuta, String trazadoRutaGPX, String tipoRuta, String folletos, String folleto, String tramos, String origenDestino, int distanciaTramo, String descripcionTramo, String geolocalizacion, String coordenadas) {
        Nombre = nombre;
        Contacto = contacto;
        Concejos = concejos;
        Zona = zona;
        Distancia = distancia;
        Dificultad = dificultad;
        TiempoAPie = tiempoAPie;
        TiempoBTT = tiempoBTT;
        TiempoCoche = tiempoCoche;
        TiempoViasVerdes = tiempoViasVerdes;
        TiempoAscension = tiempoAscension;
        ContactoTexto = contactoTexto;
        Codigo = codigo;
        TipoDeRecorrido = tipoDeRecorrido;
        Altitud = altitud;
        Desnivel = desnivel;
        SituacionGeografica = situacionGeografica;
        PuntoDePartida = puntoDePartida;
        Informacion = informacion;
        Resumen = resumen;
        InformacionTexto = informacionTexto;
        Observaciones = observaciones;
        Itinerario = itinerario;
        TextoTramos = textoTramos;
        Detalle = detalle;
        DetalleImagen = detalleImagen;
        DetalleTexto = detalleTexto;
        Visualizador = visualizador;
        Slide = slide;
        SlideTitulo = slideTitulo;
        SlideUrl = slideUrl;
        TrazadoRuta = trazadoRuta;
        TrazadoRutaGPX = trazadoRutaGPX;
        TipoRuta = tipoRuta;
        Folletos = folletos;
        Folleto = folleto;
        Tramos = tramos;
        OrigenDestino = origenDestino;
        DistanciaTramo = distanciaTramo;
        DescripcionTramo = descripcionTramo;
        Geolocalizacion = geolocalizacion;
        Coordenadas = coordenadas;
    }

    //Gets
    public String getNombre() { return Nombre; }
    public String getContacto() { return Contacto; }
    public String getConcejos() { return Concejos; }
    public String getZona() { return Zona; }
    public double getDistancia() { return Distancia; }
    public int getDificultad() { return Dificultad; }
    public String getTiempoAPie() { return TiempoAPie; }
    public String getTiempoBTT() { return TiempoBTT; }
    public String getTiempoCoche() { return TiempoCoche; }
    public String getTiempoViasVerdes() { return TiempoViasVerdes; }
    public String getTiempoAscension() { return TiempoAscension; }
    public String getContactoTexto() { return ContactoTexto; }
    public String getCodigo() { return Codigo; }
    public String getTipoDeRecorrido() { return TipoDeRecorrido; }
    public String getAltitud() { return Altitud; }
    public String getDesnivel() { return Desnivel; }
    public String getSituacionGeografica() { return SituacionGeografica; }
    public String getPuntoDePartida() { return PuntoDePartida; }
    public String getInformacion() { return Informacion; }
    public String getResumen() { return Resumen; }
    public String getInformacionTexto() { return InformacionTexto; }
    public String getObservaciones() { return Observaciones; }
    public String getItinerario() { return Itinerario; }
    public String getTextoTramos() { return TextoTramos; }
    public String getDetalle() { return Detalle; }
    public String getDetalleImagen() { return DetalleImagen; }
    public String getDetalleTexto() { return DetalleTexto; }
    public String getVisualizador() { return Visualizador; }
    public String getSlide() { return Slide; }
    public String getSlideTitulo() { return SlideTitulo; }
    public String getSlideUrl() { return SlideUrl; }
    public String getTrazadoRuta() { return TrazadoRuta; }
    public String getTrazadoRutaGPX() { return TrazadoRutaGPX; }
    public String getTipoRuta() { return TipoRuta; }
    public String getFolletos() { return Folletos; }
    public String getFolleto() { return Folleto; }
    public String getTramos() { return Tramos; }
    public String getOrigenDestino() { return OrigenDestino; }
    public int getDistanciaTramo() { return DistanciaTramo; }
    public String getDescripcionTramo() { return DescripcionTramo; }
    public String getGeolocalizacion() { return Geolocalizacion; }
    public String getCoordenadas() { return Coordenadas;}

    //Sets
    public void setNombre(String nombre) { Nombre = nombre; }
    public void setContacto(String contacto) { Contacto = contacto; }
    public void setConcejos(String concejos) { Concejos = concejos; }
    public void setZona(String zona) { Zona = zona; }
    public void setDistancia(double distancia) { Distancia = distancia; }
    public void setDificultad(int dificultad) { Dificultad = dificultad; }
    public void setTiempoAPie(String tiempoAPie) { TiempoAPie = tiempoAPie; }
    public void setTiempoBTT(String tiempoBTT) { TiempoBTT = tiempoBTT; }
    public void setTiempoCoche(String tiempoCoche) { TiempoCoche = tiempoCoche; }
    public void setTiempoViasVerdes(String tiempoViasVerdes) { TiempoViasVerdes = tiempoViasVerdes; }
    public void setTiempoAscension(String tiempoAscension) { TiempoAscension = tiempoAscension; }
    public void setContactoTexto(String contactoTexto) { ContactoTexto = contactoTexto; }
    public void setCodigo(String codigo) { Codigo = codigo; }
    public void setTipoDeRecorrido(String tipoDeRecorrido) { TipoDeRecorrido = tipoDeRecorrido; }
    public void setAltitud(String altitud) { Altitud = altitud; }
    public void setDesnivel(String desnivel) { Desnivel = desnivel; }
    public void setSituacionGeografica(String situacionGeografica) { SituacionGeografica = situacionGeografica; }
    public void setPuntoDePartida(String puntoDePartida) { PuntoDePartida = puntoDePartida; }
    public void setInformacion(String informacion) { Informacion = informacion; }
    public void setResumen(String resumen) { Resumen = resumen; }
    public void setInformacionTexto(String informacionTexto) { InformacionTexto = informacionTexto; }
    public void setObservaciones(String observaciones) { Observaciones = observaciones; }
    public void setItinerario(String itinerario) { Itinerario = itinerario; }
    public void setTextoTramos(String textoTramos) { TextoTramos = textoTramos; }
    public void setDetalle(String detalle) { Detalle = detalle; }
    public void setDetalleImagen(String detalleImagen) { DetalleImagen = detalleImagen; }
    public void setDetalleTexto(String detalleTexto) { DetalleTexto = detalleTexto; }
    public void setVisualizador(String visualizador) { Visualizador = visualizador; }
    public void setSlide(String slide) { Slide = slide; }
    public void setSlideTitulo(String slideTitulo) { SlideTitulo = slideTitulo; }
    public void setSlideUrl(String slideUrl) { SlideUrl = slideUrl; }
    public void setTrazadoRuta(String trazadoRuta) { TrazadoRuta = trazadoRuta; }
    public void setTrazadoRutaGPX(String trazadoRutaGPX) { TrazadoRutaGPX = trazadoRutaGPX; }
    public void setTipoRuta(String tipoRuta) { TipoRuta = tipoRuta; }
    public void setFolletos(String folletos) { Folletos = folletos; }
    public void setFolleto(String folleto) { Folleto = folleto; }
    public void setTramos(String tramos) { Tramos = tramos; }
    public void setOrigenDestino(String origenDestino) { OrigenDestino = origenDestino; }
    public void setDistanciaTramo(int distanciaTramo) { DistanciaTramo = distanciaTramo; }
    public void setDescripcionTramo(String descripcionTramo) { DescripcionTramo = descripcionTramo; }
    public void setGeolocalizacion(String geolocalizacion) { Geolocalizacion = geolocalizacion; }
    public void setCoordenadas(String coordenadas) { Coordenadas = coordenadas; }
}
