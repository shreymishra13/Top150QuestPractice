class TimeMap {
    Map<String, String[]> timeMap ;
    public TimeMap() {
       timeMap = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key , new String[1002]);
        timeMap.get(key)[timestamp] = value;
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key))return "";
         String answer = this.timeMap.get(key)[timestamp];;
         while(answer == null && timestamp > 1){
            timestamp--;
            answer = this.timeMap.get(key)[timestamp];
            
         }
         return answer == null?"" :answer;
    }
}
