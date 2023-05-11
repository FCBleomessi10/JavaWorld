package pattern.bridge;

public class AviFile implements VideoFile {
    public void decode(String fileName) {
        System.out.println("avi视频文件: " + fileName);
    }
}
