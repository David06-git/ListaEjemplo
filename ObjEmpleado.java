public class ObjEmpleado {
    private String Nombre;
    private double Salario;
    

    public ObjEmpleado() {
    }

    public ObjEmpleado(String Nombre, double Salario) {
        this.Nombre = Nombre;
        this.Salario = Salario;
        
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }

}
