package net.wulusai.designpattern.proxy;

/**
 * 真实图像类 - 代理模式的真实主题
 * 负责实际的图像加载和显示操作
 */
public class RealImage implements Image {
    private String fileName;
    
    /**
     * 构造函数，模拟从磁盘或网络加载图像
     * @param fileName 图像文件名
     */
    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }
    
    /**
     * 模拟从磁盘加载图像（耗时操作）
     */
    private void loadFromDisk() {
        System.out.println("正在加载图像: " + fileName);
        // 模拟加载延迟
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("图像加载完成: " + fileName);
    }
    
    @Override
    public void display() {
        System.out.println("显示图像: " + fileName);
    }
}
