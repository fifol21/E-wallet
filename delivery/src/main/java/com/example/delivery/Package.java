package com.example.delivery;

public class Package {
    private int packageId;
    private float weight;
    private String size;
    private boolean ifFragile;

    public Package(int packageID,float weight, String size, boolean ifFragile) {
        this.packageId = packageID;
        this.weight = weight;
        this.size = size;
        this.ifFragile = ifFragile;
    }

    public Package(float weight, String size, boolean ifFragile, PackageDAO packageDAO) {
        this.packageId = packageDAO.getLastPackage().getPackageId() +1;
        this.weight = weight;
        this.size = size;
        this.ifFragile = ifFragile;
    }

    public int getPackageId() {
        return packageId;
    }
    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public boolean isIfFragile() {
        return ifFragile;
    }
    public void setIfFragile(boolean ifFragile) {
        this.ifFragile = ifFragile;
    }

    public float calculateCost() {
        float costSmall = 20;
        float costMedium = 30;
        float costLarge = 40;
        float weightSmall = 1;
        float weightMedium = 3;

        if(getSize().equals("small") && getWeight() <= weightSmall) {
            return costSmall;
        }else if(getSize().equals("medium") && getWeight() <= weightMedium) {
            return costMedium;
        }else{
            return costLarge;
        }
    }
}
