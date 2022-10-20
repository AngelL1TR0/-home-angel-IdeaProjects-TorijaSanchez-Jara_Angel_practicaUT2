package entity;

public class FileEntity {

    private String articulo;

    private String tipo;

    private String fechaDeVenta;

    private double precioDeVenta;

    private double costeDerivados;

    private double costesProduccion;

    private double impuestos;

    private double beneficio;

    public FileEntity(String articulo, String tipo, String fechaDeVenta, double precioDeVenta, double costeDerivados, double costesProduccion, double impuestos, double beneficio) {
        this.articulo = articulo;
        this.tipo = tipo;
        this.fechaDeVenta = fechaDeVenta;
        this.precioDeVenta = precioDeVenta;
        this.costeDerivados = costeDerivados;
        this.costesProduccion = costesProduccion;
        this.impuestos = impuestos;
        this.beneficio = beneficio;
    }

    public FileEntity() {
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

    public double getCostesProduccion() {
        return costesProduccion;
    }

    public void setCostesProduccion(double costesProduccion) {
        this.costesProduccion = costesProduccion;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public double getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(double beneficio) {
        this.beneficio = beneficio;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "article='" + articulo + '\'' +
                ", type='" + tipo + '\'' +
                ", saleDate='" + fechaDeVenta + '\'' +
                ", salePrice=" + precioDeVenta +
                ", derivedCosts=" + costeDerivados +
                ", productionCosts=" + costesProduccion +
                ", taxes=" + impuestos +
                ", benefit=" + beneficio +
                '}';
    }
}