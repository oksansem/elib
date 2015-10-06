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
@Table(name = "BACKGROUNDS")
@NamedQueries({
    @NamedQuery(name = "Background.findAll", query = "SELECT b FROM Background b"),
    @NamedQuery(name = "Background.findByBackgroundId", query = "SELECT b FROM Background b WHERE b.backgroundId = :backgroundId"),
    @NamedQuery(name = "Background.findByBackgroundName", query = "SELECT b FROM Background b WHERE b.backgroundName = :backgroundName"),
    @NamedQuery(name = "Background.findByBackgroundColor", query = "SELECT b FROM Background b WHERE b.backgroundColor = :backgroundColor"),
    @NamedQuery(name = "Background.findByBackgroundAddress", query = "SELECT b FROM Background b WHERE b.backgroundAddress = :backgroundAddress")})
public class Background implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "background_id")
    private Integer backgroundId;
    @Size(max = 20)
    @Column(name = "background_name")
    private String backgroundName;
    @Column(name = "background_color")
    private Integer backgroundColor;
    @Size(max = 30)
    @Column(name = "background_address")
    private String backgroundAddress;

    public Background() {
    }

    public Background(Integer backgroundId) {
        this.backgroundId = backgroundId;
    }

    public Integer getBackgroundId() {
        return backgroundId;
    }

    public void setBackgroundId(Integer backgroundId) {
        this.backgroundId = backgroundId;
    }

    public String getBackgroundName() {
        return backgroundName;
    }

    public void setBackgroundName(String backgroundName) {
        this.backgroundName = backgroundName;
    }

    public Integer getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Integer backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBackgroundAddress() {
        return backgroundAddress;
    }

    public void setBackgroundAddress(String backgroundAddress) {
        this.backgroundAddress = backgroundAddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (backgroundId != null ? backgroundId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Background)) {
            return false;
        }
        Background other = (Background) object;
        if ((this.backgroundId == null && other.backgroundId != null) || (this.backgroundId != null && !this.backgroundId.equals(other.backgroundId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Background{" + "backgroundId=" + backgroundId + ", backgroundName=" + backgroundName + ", backgroundColor=" + backgroundColor + ", backgroundAddress=" + backgroundAddress + '}';
    }

   
    
}
