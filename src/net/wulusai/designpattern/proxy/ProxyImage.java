package net.wulusai.designpattern.proxy;

/**
 * 代理图像类 - 代理模式的代理对象
 * 控制对真实图像的访问，实现延迟加载
 */
public class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage;
    
    /**
     * 构造函数，只保存文件名，不立即加载图像
     * @param fileName 图像文件名
     */
    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public void display() {
        // 延迟加载：只有在真正需要显示时才创建真实图像对象
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
