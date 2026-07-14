package com.mycopilotx.common.utils;

import com.mycopilotx.common.constant.GlobalConstant;

import java.util.ArrayList;
import java.util.List;

public class WorkflowUtil {

    /**
     * 从模型响应中提取 Markdown {@code ```json ... ```} 代码块里的 JSON 内容。
     * 未找到完整代码块时返回原字符串；提取成功后会移除内容中的换行符。
     *
     * @param data 模型返回的非空原始文本
     * @return 提取后的 JSON 字符串，或未匹配代码块时的原字符串
     */
    public static String cleanJsonStr(String data) {
        int startIndex = data.indexOf("```json");
        int endIndex = data.lastIndexOf("```");

        if (startIndex == -1 || endIndex == -1) {
            return data;
        }

        return data.substring(startIndex + "```json".length(), endIndex).replace("\n", "");
    }

    /**
     * 使用系统公共前缀和业务索引名生成内部索引名称。
     *
     * @param indexName 业务索引名称
     * @return 格式为“公共前缀_业务索引名”的内部索引名称
     */
    public static String innerIndexName(String indexName) {
        return "%s_%s".formatted(GlobalConstant.COMMON_INDEX_NAME, indexName);
    }

    // 切割字符串为指定长度的子字符串
    public static List<String> splitString(String str, int chunkSize) {
        List<String> chunks = new ArrayList<>();
        if (str == null || str.isEmpty() || chunkSize <= 0) {
            return chunks;
        }
        for (int i = 0; i < str.length(); i += chunkSize) {
            int end = Math.min(str.length(), i + chunkSize);
            chunks.add(str.substring(i, end));
        }
        return chunks;
    }
}
