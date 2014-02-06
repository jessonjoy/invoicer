/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saake.invoicer.entity;

import com.saake.invoicer.util.Utils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jn
 */
@Entity
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByItemId", query = "SELECT i FROM Item i WHERE i.itemId = :itemId"),
    @NamedQuery(name = "Item.findByItemCode", query = "SELECT i FROM Item i WHERE i.itemCode = :itemCode"),
    @NamedQuery(name = "Item.findByName", query = "SELECT i FROM Item i WHERE i.name = :name"),
    @NamedQuery(name = "Item.findByDescription", query = "SELECT i FROM Item i WHERE i.description = :description"),
    @NamedQuery(name = "Item.findByUnitPrice", query = "SELECT i FROM Item i WHERE i.unitPrice = :unitPrice")})
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private Integer itemId;
    
    @Column(name = "ITEM_CODE")
    private String itemCode;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "DESCRIPTION")
    private String description;
    
    @Column(name = "UNIT_PRICE")
    private Double unitPrice;

    @Column(name = "COST_PRICE")
    private Double costPrice;
    
    @Column(name = "ITEM_CATEGORY")
    private String itemCategory;
    
    @Column(name = "STATUS")
    private String status;
    
    @Column(name = "CREATE_TS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTs;
    
    @Column(name = "UPDATE_TS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTs;
    
    @Column(name = "CREATED_BY")
    private String createdBy;
    
    @Column(name = "UPDATED_BY")
    private String updatedBy;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemId")
    private Collection<ItemHist> itemHistCollection;
    private static final long serialVersionUID = 1L ;
        
    
//    @OneToMany(mappedBy = "itemId")
//    private Collection<OrderItem> orderItemCollection;
    
//    @JoinColumn(name = "ITEM_TYPE_ID", referencedColumnName = "ITEM_TYPE_ID")
//    @ManyToOne
//    private ItemType itemTypeId;

    @PostConstruct
    private void init(){
        setCreateTs(new Date());
        
    }
    
    @PreUpdate
    private void preupdate(){
        setUpdateTs(new Date());
    }
    
    public Item() {
    }

    public Item(Integer itemId) {
        this.itemId = itemId;
    }

    public Item(Double unitCost) {
        this.unitPrice = unitCost;
    }        

    public Item(Integer itemId,String description) {
        this.itemId = itemId;
        this.description = description;
    }

    public Item(String description, Double unitCost, String itemCategory) {
        this.description = description;
        this.unitPrice = unitCost;
        this.itemCategory = itemCategory;
    }
        
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }
   
    //    @XmlTransient
    //    public Collection<OrderItem> getOrderItemCollection() {
    //        return orderItemCollection;
    //    }
    //
    //    public void setOrderItemCollection(Collection<OrderItem> orderItemCollection) {
    //        this.orderItemCollection = orderItemCollection;
    //    }
    //    public ItemType getItemTypeId() {
    //        return itemTypeId;
    //    }
    //
    //    public void setItemTypeId(ItemType itemTypeId) {
    //        this.itemTypeId = itemTypeId;
    //    }
    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.saake.invoicer.entity.Item[ itemId=" + itemId + " ]";
    }

    public Date getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }

    public Date getUpdateTs() {
        return updateTs;
    }

    public void setUpdateTs(Date updateTs) {
        this.updateTs = updateTs;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @XmlTransient
    public Collection<ItemHist> getItemHistCollection() {
        return itemHistCollection;
    }

    public void setItemHistCollection(Collection<ItemHist> itemHistCollection) {
        this.itemHistCollection = itemHistCollection;
    }

    public boolean isEmptyForUse() {
        return (unitPrice == null || unitPrice == 0.0)  
//                && (discount == null || discount == 0.0) 
//                && invoiceItemId == null 
                && Utils.isBlank(description) 
//                && (item == null || item.getItemId() == null ) && 
                //(quantity == null || quantity == 0)  
//                && (unitPrice == null || unitPrice == 0.0)
                ;
    } 
}
