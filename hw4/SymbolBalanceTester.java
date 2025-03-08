class SymbolBalanceTester {
    public static void main(String[] args) {
        SymbolBalance balance = new SymbolBalance();
        for (int i=1; i<=6; i++) {
            balance.setFile(String.format("TestFiles/Test%d.java", i));
            System.out.println(balance.checkFile());
        }

    }
} 