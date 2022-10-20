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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bryan
 */
@Entity
@Table(name = "Estados")
public class Estado implements Serializable {

    @Column(name = "id_est")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre_est", nullable = false, unique = true, length = 20)
    private String nombre;

    @Column(name = "create_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name = "update_at", nullable = true)
    private Date updateAt;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Rol> roles;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Catalogo> catalogos;

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

    public Date getCreateAt() {
        return createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public List<Catalogo> getCatalogos() {
        return catalogos;
    }

    public void setCatalogos(List<Catalogo> catalogos) {
        this.catalogos = catalogos;
    }

    @Override
    public String toString() {
        return "Estado{" + "id=" + id + ", nombre=" + nombre + ", createAt=" + createAt + ", updateAt=" + updateAt + ", roles=" + roles + ", catalogos=" + catalogos + '}';
    }
}
