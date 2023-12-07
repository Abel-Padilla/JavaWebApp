
package models.bean;

public class UsuarioBean {
    
    /*
        Creamos una clase que contenga todos 
        los campos de la tabla y los represente 
        en diferentes atributos
    */
    
    /*
    +--------------------+------------------+
    | Field              | Type             |
    +--------------------+------------------+
    | idUsuario          | int(11) unsigned |
    | nombre             | varchar(120)     |
    | fecha_nacimiento   | date             |
    | sexo               | tinyint(1)       |
    | calle_numero       | varchar(120)     |
    | colonia_cp         | varchar(120)     |
    | ciudad_estado      | varchar(120)     |
    | username           | varchar(70)      |
    | password           | varchar(120)     |
    | tipo_usuario       | tinyint(1)       |
    | imahen_usuario     | varchar(150)     |
    | fecha_creacion     | datetime         |
    | fecha_modificacion | datetime         |
    +--------------------+------------------+
    */
    private int    idUsuario;
    private String nombre;
    private String fechaNacimiento;
    private int    sexo;
    private String calleNumero;
    private String coloniaCP;
    private String ciudadEstado;
    private String username;
    private String password;
    private int    tipoUsuario;
    private String imagenUsuario;
    private String fechaCreacion;
    private String fechaModificacion;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getCalleNumero() {
        return calleNumero;
    }

    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }

    public String getColoniaCP() {
        return coloniaCP;
    }

    public void setColoniaCP(String coloniaCP) {
        this.coloniaCP = coloniaCP;
    }

    public String getCiudadEstado() {
        return ciudadEstado;
    }

    public void setCiudadEstado(String ciudadEstado) {
        this.ciudadEstado = ciudadEstado;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getImagenUsuario() {
        return imagenUsuario;
    }

    public void setImagenUsuario(String imagenUsuario) {
        this.imagenUsuario = imagenUsuario;
    }
    
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
}
