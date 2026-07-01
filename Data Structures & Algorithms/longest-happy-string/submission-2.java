class Node {
    char currChar;
    int freq;

    Node(char c, int count) {
        this.currChar = c;
        this.freq = count;
    }
}
class Solution {
    private boolean canPlace(StringBuilder sb , char c){
        int n = sb.length();
        return ! (sb.charAt(n-1) == c && sb.charAt(n-2) == c);
    }
    public String longestDiverseString(int a, int b, int c) {
        if (a == 0 && b == 0 && c == 0)
            return "";
        PriorityQueue<Node> pq =
            new PriorityQueue<>((m, n) ->  n.freq - m.freq );
        if(a != 0)
        pq.add(new Node('a', a));
        if(b != 0)
        pq.add(new Node('b', b));
        if(c != 0)
        pq.add(new Node('c', c));

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Node currNode = pq.poll();
            if (sb.length() < 2) {
                sb.append(currNode.currChar);
                if (currNode.freq > 1)
                    pq.add(new Node(currNode.currChar, currNode.freq - 1));
            } else {
                if (canPlace(sb, currNode.currChar)) {
                    sb.append(currNode.currChar);
                    if (currNode.freq > 1)
                        pq.add(new Node(currNode.currChar, currNode.freq - 1));
                } else {
                    if(pq.isEmpty()){
                        return sb.toString();
                    }else{
                        Node newNode = pq.poll();
                        sb.append(newNode.currChar);
                        if (newNode.freq > 1)
                            pq.add(new Node(newNode.currChar, newNode.freq - 1));
                        pq.add(currNode);
                        
                    }
                }
            }
        }

        return sb.toString();
    }
}