package vn.edu.tlu2151173779;

public class CafeItem {
    private int imageResId;
    private String name;
    private double price;

    public CafeItem(int imageResId, String name, double price) {
        this.imageResId = imageResId;
        this.name = name;
        this.price = price;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
