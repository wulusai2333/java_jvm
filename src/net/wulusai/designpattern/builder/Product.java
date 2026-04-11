package net.wulusai.designpattern.builder;

/**
 * 产品类 - 房屋
 * 建造者模式中要创建的复杂对象
 */
public class Product {
    private String foundation;   // 地基
    private String structure;    // 结构
    private String roof;         // 屋顶
    private String interior;     // 内部装修

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    /**
     * 显示房屋的建造信息
     */
    public void show() {
        System.out.println("===== 房屋建造完成 =====");
        System.out.println("地基: " + foundation);
        System.out.println("结构: " + structure);
        System.out.println("屋顶: " + roof);
        System.out.println("内部装修: " + interior);
        System.out.println("=======================");
    }
}
