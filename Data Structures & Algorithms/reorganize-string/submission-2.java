class Node {
    char c;
    int count;

    Node(char c, int count) {
        this.c = c;
        this.count = count;
    }

    public String toString() {
        return this.c + "->" + this.count;
    }
}
class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.count != b.count)
                return b.count - a.count;
            return b.c - a.c;
        });
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // now adding in the priorityQueue

        for (char c : charCountMap.keySet()) {
            // if(charCountMap.get(c) > Math.ceil(s.length()/2))return "";
            pq.add(new Node(c, charCountMap.get(c)));
        }

        char prevChar = '@';

        StringBuilder answer = new StringBuilder();
        while (!pq.isEmpty()) {
             System.out.println(pq + "->" + answer.toString()) ;
            Node currNode = pq.poll();
            if(currNode.c == prevChar){
                if(pq.isEmpty())return "";
                Node currNewNode = pq.poll();
                answer.append(currNewNode.c);
                prevChar = currNewNode.c;
                if(currNewNode.count != 1){
                    pq.add(new Node(currNewNode.c , currNewNode.count-1));
                }
                pq.add(currNode);
                
            }else{
                answer.append(currNode.c);
                prevChar = currNode.c;
                 if(currNode.count != 1){
                    pq.add(new Node(currNode.c , currNode.count-1));
                }
                

            }
           

               
            
        }

        return answer.toString();
    }
}