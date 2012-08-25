package org.tju.ebs.entity;

public class Product extends AbstractEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4386481562817624512L;

	private String id;

    private String shortName;

    private String fullName;

    private Float unitPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }
}