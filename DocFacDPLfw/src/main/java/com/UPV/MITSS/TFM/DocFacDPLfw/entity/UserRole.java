/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author S
 */
@Entity
@Table(name="Roles_Usuario",uniqueConstraints=@UniqueConstraint(columnNames={"rol","id_Usuario"}))
public class UserRole implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name="id_Rol_Usuario", unique = true, nullable = false)
    private int id_Rol_Usuario;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_Usuario",nullable = false)
    private User user;
    
    @Column(name="rol",nullable = false, length=45)
    private String role;
    
    public UserRole(){}
    
    public UserRole(User user, String role){
        this.user = user;
        this.role = role;
    }

    public int getId_RolUsuario() {
        return id_Rol_Usuario;
    }

    public void setId_RolUsuario(int id_Rol_Usuario) {
        this.id_Rol_Usuario = id_Rol_Usuario;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
