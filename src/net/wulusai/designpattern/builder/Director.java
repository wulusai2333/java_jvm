package net.wulusai.designpattern.builder;

/**
 * 指挥者类 - 控制房屋的建造过程
 * 负责安排复杂对象的建造次序，与抽象建造者交互
 */
public class Director {
    private Builder builder;

    /**
     * 设置建造者
     * @param builder 具体的建造者对象
     */
    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    /**
     * 构建产品 - 控制建造顺序
     * 按照固定顺序调用建造者的方法
     * @return 建造完成的Product对象
     */
    public Product construct() {
        System.out.println("\n开始建造房屋...");
        builder.buildFoundation();
        builder.buildStructure();
        builder.buildRoof();
        builder.buildInterior();
        System.out.println("房屋建造完成！\n");
        return builder.getResult();
    }
}
