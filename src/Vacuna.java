class Vacuna {
    private int codigoVacuna;
    private double precioSugerido;
    private int cantidad;
    private String nombreVacuna;

    public Vacuna(int codigoVacuna, double precioSugerido, int cantidad, String nombreVacuna) {
        this.codigoVacuna = codigoVacuna;
        this.precioSugerido = precioSugerido;
        this.cantidad = cantidad;
        this.nombreVacuna = nombreVacuna;
    }

    public int getCodigoVacuna() {
        return codigoVacuna;
    }

    public void setCodigoVacuna(int codigoVacuna) {
        this.codigoVacuna = codigoVacuna;
    }

    public double getPrecioSugerido() {
        return precioSugerido;
    }

    public void setPrecioSugerido(double precioSugerido) {
        this.precioSugerido = precioSugerido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }
}