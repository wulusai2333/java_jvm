package net.wulusai.designpattern.builder;

/**
 * 具体建造者2 - 豪华房屋建造者
 * 实现Builder接口，负责创建豪华房屋的各个部件
 */
public class ConcreteBuilder2 implements Builder {
    private Product product;

    public ConcreteBuilder2() {
        this.product = new Product();
    }

    @Override
    public void buildFoundation() {
        product.setFoundation("豪华地基 - 钢筋混凝土深基础");
        System.out.println("ConcreteBuilder2: 建造豪华地基");
    }

    @Override
    public void buildStructure() {
        product.setStructure("豪华结构 - 钢结构框架");
        System.out.println("ConcreteBuilder2: 建造豪华结构");
    }

    @Override
    public void buildRoof() {
        product.setRoof("豪华屋顶 - 欧式斜顶");
        System.out.println("ConcreteBuilder2: 建造豪华屋顶");
    }

    @Override
    public void buildInterior() {
        product.setInterior("豪华装修 - 精装修带智能家居");
        System.out.println("ConcreteBuilder2: 进行豪华装修");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
