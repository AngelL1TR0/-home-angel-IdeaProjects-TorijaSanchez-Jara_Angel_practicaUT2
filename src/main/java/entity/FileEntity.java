package entity;

public class FileEntity {

    private String nombreArchivo;
    private String articulo;
    private String tipo;
    private String fechaDeVenta;
    private double precioDeVenta;
    private double costeDerivados;
    private double costeProduccion;
    private double impuestos;

    public FileEntity(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public FileEntity(String articulo, String tipo, String fechaDeVenta, double precioDeVenta, double costeDerivados, double costeProduccion, double impuestos) {
        this.articulo = articulo;
        this.tipo = tipo;
        this.fechaDeVenta = fechaDeVenta;
        this.precioDeVenta = precioDeVenta;
        this.costeDerivados = costeDerivados;
        this.costeProduccion = costeProduccion;
        this.impuestos = impuestos;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaDeVenta() {
        return fechaDeVenta;
    }

    public void setFechaDeVenta(String fechaDeVenta) {
        this.fechaDeVenta = fechaDeVenta;
    }

    public double getPrecioDeVenta() {
        return precioDeVenta;
    }

    public void setPrecioDeVenta(double precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }

    public double getCosteDerivados() {
        return costeDerivados;
    }

    public void setCosteDerivados(double costeDerivados) {
        this.costeDerivados = costeDerivados;
    }

    public double getCosteProduccion() {
        return costeProduccion;
    }

    public void setCosteProduccion(double costeProduccion) {
        this.costeProduccion = costeProduccion;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "articulo='" + articulo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", fechaDeVenta='" + fechaDeVenta + '\'' +
                ", precioDeVenta=" + precioDeVenta +
                ", costeDerivados=" + costeDerivados +
                ", costeProduccion=" + costeProduccion +
                ", impuestos=" + impuestos +
                '}';
    }
}
