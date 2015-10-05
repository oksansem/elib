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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alexandr
 */
@Entity
@Table(name = "file_types")
@NamedQueries({
    @NamedQuery(name = "FileType.findAll", query = "SELECT f FROM FileType f"),
    @NamedQuery(name = "FileType.findByFileTypeId", query = "SELECT f FROM FileType f WHERE f.fileTypeId = :fileTypeId"),
    @NamedQuery(name = "FileType.findByFileTypeName", query = "SELECT f FROM FileType f WHERE f.fileTypeName = :fileTypeName"),
    @NamedQuery(name = "FileType.findByFileTypeValue", query = "SELECT f FROM FileType f WHERE f.fileTypeValue = :fileTypeValue")})
public class FileType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "file_type_id")
    private Integer fileTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "file_type_name")
    private String fileTypeName;
    @Size(max = 20)
    @Column(name = "file_type_value")
    private String fileTypeValue;

    public FileType() {
    }

    public FileType(Integer fileTypeId) {
        this.fileTypeId = fileTypeId;
    }

    public FileType(Integer fileTypeId, String fileTypeName) {
        this.fileTypeId = fileTypeId;
        this.fileTypeName = fileTypeName;
    }

    public Integer getFileTypeId() {
        return fileTypeId;
    }

    public void setFileTypeId(Integer fileTypeId) {
        this.fileTypeId = fileTypeId;
    }

    public String getFileTypeName() {
        return fileTypeName;
    }

    public void setFileTypeName(String fileTypeName) {
        this.fileTypeName = fileTypeName;
    }

    public String getFileTypeValue() {
        return fileTypeValue;
    }

    public void setFileTypeValue(String fileTypeValue) {
        this.fileTypeValue = fileTypeValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fileTypeId != null ? fileTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FileType)) {
            return false;
        }
        FileType other = (FileType) object;
        if ((this.fileTypeId == null && other.fileTypeId != null) || (this.fileTypeId != null && !this.fileTypeId.equals(other.fileTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FileType{" + "fileTypeId=" + fileTypeId + ", fileTypeName=" + fileTypeName + ", fileTypeValue=" + fileTypeValue + '}';
    }

    
    
}
