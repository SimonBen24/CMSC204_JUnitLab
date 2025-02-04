public class ProductSalesTracker {
    private double[] sales;
    private int salesSize;

    public ProductSalesTracker(int capacity) {
        sales = new double[capacity];
        salesSize = 0;
    }

    public boolean addSale(double sale) {
        if (salesSize >= sales.length) {
            return false; // Tracker is full
        }
        sales[salesSize++] = sale;
        return true;
    }


    public double totalSales() {
        double total = 0;
        for (int i = 0; i < salesSize; i++) {
            total += sales[i];
        }
        return total;
    }

    public double lowestSale() {
        if (salesSize == 0) return 0;
        double lowest = sales[0];
        for (int i = 1; i < salesSize; i++) {
            if (sales[i] < lowest) {
                lowest = sales[i];
            }
        }
        return lowest;
    }

    public double finalSalesTotal() {
        if (salesSize < 2) return 0;
        return totalSales() - lowestSale();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < salesSize; i++) {
            sb.append(sales[i]);
            if (i < salesSize - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
