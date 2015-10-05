/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensource.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Alexandr
 */
@Entity
@Table(name = "access_types")
@NamedQueries({
    @NamedQuery(name = "AccessType.findAll", query = "SELECT a FROM AccessType a"),
    @NamedQuery(name = "AccessType.findByAccessTypeId", query = "SELECT a FROM AccessType a WHERE a.accessTypeId = :accessTypeId"),
    @NamedQuery(name = "AccessType.findByAccessTypeName", query = "SELECT a FROM AccessType a WHERE a.accessTypeName = :accessTypeName"),
    @NamedQuery(name = "AccessType.findByAccessTypeDescription", query = "SELECT a FROM AccessType a WHERE a.accessTypeDescription = :accessTypeDescription")})
public class AccessType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "access_type_id")
    private Integer accessTypeId;
    @Size(max = 20)
    @Column(name = "access_type_name")
    private String accessTypeName;
    @Size(max = 50)
    @Column(name = "access_type_description")
    private String accessTypeDescription;

    public AccessType() {
    }

    public AccessType(Integer accessTypeId) {
        this.accessTypeId = accessTypeId;
    }

    public Integer getAccessTypeId() {
        return accessTypeId;
    }

    public void setAccessTypeId(Integer accessTypeId) {
        this.accessTypeId = accessTypeId;
    }

    public String getAccessTypeName() {
        return accessTypeName;
    }

    public void setAccessTypeName(String accessTypeName) {
        this.accessTypeName = accessTypeName;
    }

    public String getAccessTypeDescription() {
        return accessTypeDescription;
    }

    public void setAccessTypeDescription(String accessTypeDescription) {
        this.accessTypeDescription = accessTypeDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessTypeId != null ? accessTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessType)) {
            return false;
        }
        AccessType other = (AccessType) object;
        if ((this.accessTypeId == null && other.accessTypeId != null) || (this.accessTypeId != null && !this.accessTypeId.equals(other.accessTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AccessType{" + "accessTypeId=" + accessTypeId + ", accessTypeName=" + accessTypeName + ", accessTypeDescription=" + accessTypeDescription + '}';
    }

   
    
}
