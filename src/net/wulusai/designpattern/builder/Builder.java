package net.wulusai.designpattern.builder;

/**
 * 抽象建造者接口
 * 定义创建产品各个部件的抽象方法
 */
public interface Builder {
    /**
     * 建造地基
     */
    void buildFoundation();

    /**
     * 建造结构
     */
    void buildStructure();

    /**
     * 建造屋顶
     */
    void buildRoof();

    /**
     * 建造内部装修
     */
    void buildInterior();

    /**
     * 获取建造完成的产品
     * @return 建造完成的Product对象
     */
    Product getResult();
}
