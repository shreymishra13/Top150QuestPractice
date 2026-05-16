class Solution {
    public int numUniqueEmails(String[] emails) {
        //first split the words from @ symbol
        //filter the first part 

        // List<String[]> emailList = new LinkedList<>();
        Set<String> emailSet = new HashSet<>();

        for(String email : emails){
            String parts[] = email.split("@");

            parts[0] = parts[0].replace(".","");
            int index = parts[0].indexOf("+");
            if(index != -1)
            parts[0] = parts[0].substring(0 , index);
            System.out.println(parts[0]+"@"+ parts[1]);
            emailSet.add(parts[0]+"@"+ parts[1]);
        }
        return emailSet.size();
    }
}