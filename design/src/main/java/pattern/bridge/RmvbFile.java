package pattern.bridge;

public class RmvbFile implements VideoFile {
    public void decode(String fileName) {
        System.out.println("rmvb视频文件: " + fileName);
    }
}
