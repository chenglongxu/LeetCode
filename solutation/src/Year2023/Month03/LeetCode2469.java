package Year2023.Month03;

/**
 * https://leetcode.cn/problems/convert-the-temperature/description/
 * 开氏度 = 摄氏度 + 273.15
 * 华氏度 = 摄氏度 * 1.80 + 32.00
 *
 * @author xuchenglong
 */
public class LeetCode2469 {

    public static void main(String[] args) {

    }

    public static double[] convertTemperature(double celsius) {
        double kelvin = celsius + 273.15;
        double fahrenheit = celsius * 1.80 + 32.00;
        return new double[]{kelvin, fahrenheit};
    }

}
