package net.wulusai.designpattern.facade;

/**
 * 外观模式: 外观模式定义了一个高层接口，这个接口使得这一子系统更加容易使用
 */
public class HomeTheaterTestDrive {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(new Amplifier(), new CdPlayer(), new DvdPlayer(),
                new PopcornPopper(), new Projector(), new Screen(), new TheaterLights(), new Tuner());
        homeTheater.watchMovie("Raiders of the Lost Ark");
        homeTheater.endMovie();
        homeTheater.listenToCd("Surfer Rosa");
    }
}
