class StockSpanner {
    List<Integer> stocks;

    public StockSpanner() {
        this.stocks = new LinkedList<>();

    }
    
    public int next(int price) {
        this.stocks.add(price);
        int right = this.stocks.size()-1;
        int count  = 0;
        while(right >= 0 && this.stocks.get(right) <= price){
            count++;
            right--;
        }
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */