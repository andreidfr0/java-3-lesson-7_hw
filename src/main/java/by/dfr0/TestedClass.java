package by.dfr0;

public class TestedClass {
//    private int i = 0;
    private String s = "test String";

    public TestedClass() {
    }

//    public TestedClass(int i, String s) {
//        this.i = i;
//        this.s = s;
//    }

    @AfterSuite()
    public void end() {
        this.s = "Test stoped";
        System.out.println("аннотация @AfterSuite" + s);
    }

    @BeforeSuite()
    public void prepare() {
        this.s = "Teast started";
        System.out.println("аннотация @BeforeSuite" + s);
    }

    @Test(i = 1)
    public void test7() {
        System.out.println("in test7 аннотация @Test priority 1");
    }

    @Test(i = 1)
    public void test2() {
        System.out.println("in test2 аннотация @Test priority 1");
    }

    @Test(i = 7)
    public void test0() {
        System.out.println("in test0 аннотация @Test priority 7");
    }

    @Test(i = 3)
    public void test9() {
        System.out.println("in test9 аннотация @Test priority 3");
    }

//    @BeforeSuite()
//    public void prepare1(){
//        this.s = "Teast started";
//        System.out.println("аннотация @BeforeSuite" + s);
//    }

//    @AfterSuite()
//    public void stoped(){
//        this.s = "Test stoped";
//        System.out.println("аннотация @AfterSuite" + s);
//    }

}


