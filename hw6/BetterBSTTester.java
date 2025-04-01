class BetterBSTTester {
    public static void main (String[] args) {
        BinarySearchTree<Integer> test = new BetterBST<Integer>();
        test.insert(3);
        test.insert(1);
        test.insert(2);
        test.insert(6);
        test.insert(5);
        test.insert(7);
        test.insert(4);
        test.insert(8);
        test.insert(9);

        System.out.println(test.height());
        System.out.println(test.imbalance());
        System.out.println(test.smallestGreaterThan(10));
        System.out.println(test.smallestGreaterThan(4));
        for(int i = 0; i < 9; i++) {
            System.out.println(test.levelOrderTraversal().get(i).data);
        }
        for(int i = 0; i < 9; i++) {
            System.out.println(test.mirror().levelOrderTraversal().get(i).data);
        }
    }
}