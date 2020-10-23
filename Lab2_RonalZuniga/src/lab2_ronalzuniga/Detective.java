package lab2_ronalzuniga;

public class Detective {

    private String nombre;
    private int edad;
    private String nacionalidad;
    private int laborales;
    private int nivel;

    public Detective() {
    }

    public Detective(String nombre, int edad, String nacionalidad, int laborales, int nivel) {
        this.nombre = nombre;
        setEdad(edad);
        this.nacionalidad = nacionalidad;
        this.laborales = laborales;
        setNivel(nivel);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 18 && edad <= 80) {
            this.edad = edad;
        }
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getLaborales() {
        return laborales;
    }

    public void setLaborales(int laborales) {
        this.laborales = laborales;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if (nivel >= 1 && nivel <= 10) {
            this.nivel = nivel;
        }
    }

    @Override
    public String toString() {
        return "Detective \n"+" Nombre = " + nombre + "\n Edad = " + edad + "\n Nacionalidad = " + nacionalidad + "\n Años Laborales = " + laborales + "\n Nivel = " + nivel;
    }
}
