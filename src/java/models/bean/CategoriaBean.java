/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.bean;

/**
 *+------------------+------------------+------+-----+---------+----------------+
| Field            | Type             | Null | Key | Default | Extra          |
+------------------+------------------+------+-----+---------+----------------+
| id_categoria     | int(11) unsigned | NO   | PRI | NULL    | auto_increment |
| nombre           | varchar(120)     | NO   |     |         |                |
| imagen_categoria | varchar(150)     | NO   |     |         |                |
| estatus          | int(1)           | NO   |     | 1       |                |
+------------------+------------------+------+-----+---------+----------------+
 */
public class CategoriaBean {
    private int categoria;
    private String nombre;
    private String imagen;
    private int estatus;

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
}
