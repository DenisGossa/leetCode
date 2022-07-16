class AttemptedSolution {
    public String convert(String s, int numRows) {
        int len=s.length();
        if (numRows <= 1|| len==0) {
            return s;
        }

        char[][] array = new char[numRows][len / 2 + 1];
        boolean dirDown = true;
        int index = 0;
        char currentChar;
        int currentRow = 0, currentColumn = 0;

        while (true) {

            if (dirDown) {
                if (currentRow < numRows) {
                    currentChar = s.charAt(index);
                    array[currentRow++][currentColumn] = currentChar;
                    index++;
                } else {
                    dirDown = false;
                    currentRow = numRows - 2;
                    continue;
                }
            } else {

                if (currentRow >= 0) {
                    currentChar = s.charAt(index++);
                    array[currentRow--][++currentColumn] = currentChar;
                } else {
                    dirDown = true;
                    currentRow = 1;
                }
            }
            if (index >= len) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                currentChar=array[i][j];
                if(currentChar!='\u0000'){
                    sb.append(currentChar);
                }
            }
        }
        return sb.toString();
    }
}