package algorithms.offer;

/**
 * Created by liuwei on 2020/4/7
 */
public class 替换空格 {

    public String replaceSpace(StringBuffer str) {

        int length = str.length();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                result.append("%20");
            } else {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }

    //暴力解法：不断往后移，扩展同一个数组
    //第二种：新增一个数组
    public String replaceSpace02(StringBuffer str) {
        int length = str.length();
        //统计空格的数量
        int blankCount = 0;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                blankCount++;
            }
        }
        //扩展字符串的长度
        int newLength = length + 2 * blankCount;
        str.setLength(newLength);
        //用两个指针开始往前循环，一个指向原数组的末尾，一个指向扩展后数组的末尾,向前移动
        int first = length - 1;
        int last = newLength - 1;
        while(first >=0 || last < first) {
            char temp = str.charAt(first--);
            if (temp == ' ') {
                str.setCharAt(last--, '0');
                str.setCharAt(last--, '2');
                str.setCharAt(last--, '%');
            } else {
                //插入first位置的值
                str.setCharAt(last--, temp);
            }
        }
        return str.toString();
    }

    public String replaceSpace03(StringBuffer str) {
        return str.toString().replaceAll("", "20%");
    }
}
