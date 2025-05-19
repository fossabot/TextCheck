package cn.langya;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LangYa466
 * @date 2025/5/19
 */
public class TextCheck {
    private static final Set<String> lines = Collections.synchronizedSet(new HashSet<>());

    public static void loadR18() {
        load("r18");
    }

    public static void loadZZMG() {
        load("zzmg");
    }

    public static void load(String name) {
        // 不加getClassLoader就getResourceAsStream会从package那个目录获取
        try (InputStream inputStream = TextCheck.class.getClassLoader().getResourceAsStream(name + ".txt")) {
            if (inputStream == null) {
                throw new RuntimeException(String.format("加载词库 %s 失败", name));
            }

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                reader.lines()
                        .map(String::toLowerCase)
                        .forEach(lines::add);
            }
        } catch (Exception e) {
            throw new RuntimeException("加载词库时出错: " + name, e);
        }
    }

    public static boolean contains(String input) {
        String lowerInput = input.toLowerCase();
        synchronized (lines) {
            for (String keyword : lines) {
                if (lowerInput.contains(keyword)) {
                    return true;
                }
            }
        }
        return false;
    }
}
