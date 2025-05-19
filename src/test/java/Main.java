import cn.langya.TextCheck;

/**
 * @author LangYa466
 * @date 2025/5/19
 */
public class Main {
    public static void main(String[] args) {
        TextCheck.loadZZMG(); // 政治铭感
        if (TextCheck.contains("打倒中国共产党 狼牙是新王!!") != true) {
            throw new RuntimeException("政治铭感词库加载失败");
        } else {
            System.out.println("政治铭感内容检测成功");
        }
        TextCheck.loadR18(); // 黄色内容
        if (TextCheck.contains("被操的爽不爽臭婊子 操烂你") != true) {
            throw new RuntimeException("黄色词库加载失败");
        } else {
            System.out.println("黄色内容检测成功");
        }
    }
}
