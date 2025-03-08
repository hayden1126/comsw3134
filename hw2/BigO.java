class BigO implements BigOInterface {

	public void cubic(int n) { //O(n^3)
        int k = 0;
        for (int i=0; i<n*n*n; i++){
            k++;
        }
    }


	public void exp(int n) { //O(2^n)
        int dummy = 1+1;
        
        // if (n==1) {
        //     return;
        // }
        if (n>1) {
            exp(n-1);
            exp(n-1);
        }
    }


	public void constant(int n) { //o(1)
        int dummy = 1+1;
    }

}