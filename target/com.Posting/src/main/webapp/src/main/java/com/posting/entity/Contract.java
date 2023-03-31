package com.posting.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Contract {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "service_id", nullable = false)
    private int serviceId;
    @Basic
    @Column(name = "period_id", nullable = false)
    private int periodId;
    @Basic
    @Column(name = "materials_id", nullable = false)
    private int materialsId;
    @Basic
    @Column(name = "price_id", nullable = false)
    private int priceId;
    @Basic
    @Column(name = "quantity", nullable = false, precision = 2)
    private double quantity;
    @Basic
    @Column(name = "subtotal", nullable = false, precision = 2)
    private double subtotal;
    @Basic
    @Column(name = "invoice_id", nullable = false)
    private int invoiceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getPeriodId() {
        return periodId;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
    }

    public int getMaterialsId() {
        return materialsId;
    }

    public void setMaterialsId(int materialsId) {
        this.materialsId = materialsId;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return id == contract.id && serviceId == contract.serviceId && periodId == contract.periodId && materialsId == contract.materialsId && priceId == contract.priceId && Double.compare(contract.quantity, quantity) == 0 && Double.compare(contract.subtotal, subtotal) == 0 && invoiceId == contract.invoiceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceId, periodId, materialsId, priceId, quantity, subtotal, invoiceId);
    }
}
