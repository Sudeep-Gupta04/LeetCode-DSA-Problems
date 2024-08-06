class Solution {
   public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int p = 0;
            int q = image[i].length - 1;

            while (p <= q) {
                // Swap values
                int temp = image[i][p];
                image[i][p] = image[i][q];
                image[i][q] = temp;

                // Invert values
                image[i][p] = 1 - image[i][p];

                if (p < q) {
                    image[i][q] = 1 - image[i][q];
                }

                p++;
                q--;
            }

             //Print or perform any other operations as needed
            // for (int j = 0; j < image[i].length; j++) {
            //     System.out.print(image[i][j] + " ");
            // }
            // System.out.println();
        }

        return image;
    }
}