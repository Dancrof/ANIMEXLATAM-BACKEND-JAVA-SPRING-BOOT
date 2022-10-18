/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.animexlatam.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bryan
 */
@Entity
@Table(name = "Catalogos")
public class Catalogo implements Serializable{

    @Column(name = "id_cat")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre_cat", nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(name = "portada_url_cat", nullable = false)
    private String portadaUrl;

    @Column(name = "sinopsis_cat", nullable = false)
    private String sinopsis;

    @Column(name = "create_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name = "update_at", nullable = true)
    private Date updateAt;

    @OneToMany(mappedBy = "catalogo", cascade = CascadeType.ALL)
    private List<Genero> generos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_est")
    private Estado estado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cate")
    private Categoria categoria;

    @OneToMany(mappedBy = "catalogo", cascade = CascadeType.ALL)
    private List<Capitulo> capitulos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPortadaUrl() {
        return portadaUrl;
    }

    public void setPortadaUrl(String portadaUrl) {
        this.portadaUrl = portadaUrl;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }

    @Override
    public String toString() {
        return "Catalogo{" + "id=" + id + ", nombre=" + nombre + ", portadaUrl=" + portadaUrl + ", sinopsis=" + sinopsis + ", createAt=" + createAt + ", updateAt=" + updateAt + ", generos=" + generos + ", estado=" + estado + ", categoria=" + categoria + ", capitulos=" + capitulos + '}';
    }
}
