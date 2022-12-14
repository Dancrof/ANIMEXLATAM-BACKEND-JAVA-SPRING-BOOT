/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.animexlatam.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.PrePersist;

/**
 *
 * @author Bryan
 */
@Entity
@Table(name = "Capitulos")
public class Capitulo implements Serializable {

    @Column(name = "id_cap")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "numero_cap", unique = true, nullable = false)
    private int numeroCapitulo;

    @Column(name = "capitulo_url_cap", nullable = false)
    private String capituloUrl;

    @Column(name = "create_at", nullable = false)  
    private LocalDateTime createAt;

    @Column(name = "update_at", nullable = true)
    private LocalDateTime updateAt;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnoreProperties(value = "capitulos")
    @JoinColumn(name = "id_cat")   
    private Catalogo catalogo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumeroCapitulo() {
        return numeroCapitulo;
    }

    public void setNumeroCapitulo(int numeroCapitulo) {
        this.numeroCapitulo = numeroCapitulo;
    }

    public String getCapituloUrl() {
        return capituloUrl;
    }

    public void setCapituloUrl(String capituloUrl) {
        this.capituloUrl = capituloUrl;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    @Override
    public String toString() {
        return "Capitulo{" + "id=" + id + ", numeroCapitulo=" + numeroCapitulo + ", capituloUrl=" + capituloUrl + ", createAt=" + createAt + ", updateAt=" + updateAt + ", catalogo=" + catalogo + '}';
    }
    
    @PrePersist
    void registroDeCreacion(){
       this.createAt = LocalDateTime.now();
    }
}
