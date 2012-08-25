package org.tju.ebs.entity;

public class Company extends AbstractEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -751016597207199848L;

	private String id;

    private String shortName;

    private String fullName;

    private Integer productCount;

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

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }
}