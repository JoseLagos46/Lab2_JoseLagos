package lab2_joselagos;

/**
 *
 * @author Tony
 */
public class restaurantes {
    private String franquicia;
    private String nombre;
    private String ubicacion;
    private String parqueo;
    private String juegos;
    private int mesas;
    private int cajeros;
    private String gerente;
    private String especialidad;
    private String estado;
    private int empleados;
    
    public restaurantes(){
        
    }
    public restaurantes(String franquicia, String nombre, String estado, String ubicacion, int empleados, String parqueo, String juegos, int mesas, int cajeros, String gerente, String especialidad){
        setFranquicia(franquicia);
        setNombre(nombre);
        setEstado(estado);
        setUbicacion(ubicacion);
        setEmpleados(empleados);
        setParqueo(parqueo);
        setJuegos(juegos);
        setMesas(mesas);
        setCajeros(cajeros);
        setGerente(gerente);
        setEspecialidad(especialidad);
    }
    public void setFranquicia(String franquicia){
        this.franquicia = franquicia;
    }
    public String getFranquicia(){
        return franquicia;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public void setEstado(String estado){
        String aux = estado.toLowerCase();
        if("remodelacion".equals(aux) || "demolicion".equals(aux) || "funcional".equals(aux)){
            this.estado = aux;
        }
        else{
            this.estado = "invalido";
        }
    }
    public String getEstado(){
        return estado;
    }
    public void setUbicacion(String ubicacion){
        
        this.ubicacion = ubicacion;
    }
    public String getUbicacion(){
        return ubicacion;
    }
    public void setEmpleados(int empleados){
        this.empleados = empleados;
    }
    public int getEmpleados(){
        return empleados;
    }
    public void setParqueo(String parqueo){
        String aux = parqueo.toLowerCase();
        if("si".equals(aux) || "no".equals(aux)){
            this.parqueo = aux;
        }
        else{
            this.parqueo = "";
        }
    }
    public boolean getParqueo(){
        boolean park = true;
        if("si".equals(parqueo)){
            park = true;
        }
        else if("no".equals(parqueo)){
            park = false;
        }
        return park;
    }
    public void setJuegos(String juegos){
        String aux = juegos.toLowerCase();
        if("si".equals(aux) || "no".equals(aux)){
            this.juegos = aux;
        }
        else{
            this.juegos = "";
        }
    }
    public boolean getJuegos(){
        boolean play = true;
        if("si".equals(juegos)){
            play = true;
        }
        else if("no".equals(juegos)){
            play = false;
        }
        return play;
    }
    public void setMesas(int mesas){
        this.mesas = mesas;
    }
    public int getMesas(){
        return mesas;
    }
    public void setCajeros(int cajeros){
        this.cajeros = cajeros;
    }
    public int getCajeros(){
        return cajeros;
    }
    public void setGerente(String gerente){
        this.gerente = gerente;
    }
    public String getGerente(){
        return gerente;
    }
    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }
    public String getEspecialidad(){
        return especialidad;
    }
    
    @Override
    public String toString(){
        return "Franquicia: "+franquicia+"    Nombre de Restaurante: "+nombre+"\n Ubicacion: "+ubicacion+"   Cantidad de empleados: "+empleados+"\n Parqueo: "+parqueo+"   Area de juegos: "+
                juegos+"\n Cantidad de mesas: "+mesas+"   Cantidad de cajeros: "+cajeros+"\n Gerente: "+gerente+"    Especialidad: "+especialidad+"\n Estado del retaurante: "+estado;
    }
}
