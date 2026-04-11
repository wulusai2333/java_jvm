package net.wulusai.designpattern.builder;

/**
 * 具体建造者1 - 普通房屋建造者
 * 实现Builder接口，负责创建普通房屋的各个部件
 */
public class ConcreteBuilder1 implements Builder {
    private Product product;

    public ConcreteBuilder1() {
        this.product = new Product();
    }

    @Override
    public void buildFoundation() {
        product.setFoundation("普通地基 - 混凝土基础");
        System.out.println("ConcreteBuilder1: 建造普通地基");
    }

    @Override
    public void buildStructure() {
        product.setStructure("普通结构 - 砖混结构");
        System.out.println("ConcreteBuilder1: 建造普通结构");
    }

    @Override
    public void buildRoof() {
        product.setRoof("普通屋顶 - 平顶");
        System.out.println("ConcreteBuilder1: 建造普通屋顶");
    }

    @Override
    public void buildInterior() {
        product.setInterior("普通装修 - 简单装修");
        System.out.println("ConcreteBuilder1: 进行普通装修");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
