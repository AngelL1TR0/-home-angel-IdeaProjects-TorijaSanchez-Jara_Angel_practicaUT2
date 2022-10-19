package entity;

import java.util.Objects;

public class FileEntity {
    private String article;
    private String type;
    private String date;
    private double sellPrice;
    private double derivedCosts;
    private double productionCosts;
    private double taxes;

    public FileEntity() {
    }

    public FileEntity(String article, String type, String date, double sellPrice, double derivedCosts, double productionCosts, double taxes) {
        this.article = article;
        this.type = type;
        this.date = date;
        this.sellPrice = sellPrice;
        this.derivedCosts = derivedCosts;
        this.productionCosts = productionCosts;
        this.taxes = taxes;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getDerivedCosts() {
        return derivedCosts;
    }

    public void setDerivedCosts(double derivedCosts) {
        this.derivedCosts = derivedCosts;
    }

    public double getProductionCosts() {
        return productionCosts;
    }

    public void setProductionCosts(double productionCosts) {
        this.productionCosts = productionCosts;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileEntity that = (FileEntity) o;
        return Double.compare(that.sellPrice, sellPrice) == 0 && Double.compare(that.derivedCosts, derivedCosts) == 0 && Double.compare(that.productionCosts, productionCosts) == 0 && Double.compare(that.taxes, taxes) == 0 && Objects.equals(article, that.article) && Objects.equals(type, that.type) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article, type, date, sellPrice, derivedCosts, productionCosts, taxes);
    }

    @Override
    public String toString() {
        return "Article{" +
                "article='" + article + '\'' +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                ", sellPrice=" + sellPrice +
                ", derivedCosts=" + derivedCosts +
                ", productionCosts=" + productionCosts +
                ", taxes=" + taxes +
                '}';
    }


}