/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;

/**
 *
 * @author S
 */
public class PermissionId implements Serializable{
    private Integer id_documento;
    private Integer id_usuario;

    public PermissionId(){}

        public PermissionId(Integer id_documento, Integer id_usuario) {
            this.id_documento = id_documento;
            this.id_usuario = id_usuario;
        }

        public Integer getId_documento() {
            return id_documento;
        }

        public void setId_documento(Integer id_documento) {
            this.id_documento = id_documento;
        }

        public Integer getId_usuario() {
            return id_usuario;
        }

        public void setId_usuario(Integer usuario) {
            this.id_usuario = usuario;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PermissionId that = (PermissionId) o;

            if (!Objects.equals(this.id_usuario, that.id_usuario)) return false;

            return !Objects.equals(this.id_documento, that.id_documento);
        }

        @Override
        public int hashCode() {
            int result=id_usuario^id_documento;
            return result;
        }
    }