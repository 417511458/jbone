package cn.jbone.common.utils;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Id生成器
 */
public class IdGenerator {

    public static String getId(IdTargetEnum targetEnum){
        long time = new Date().getTime();
        Random random = new Random();
        int rv = random.nextInt(99999);
        DecimalFormat df=new DecimalFormat("00000");

        String endVal = df.format(rv);

        String id = targetEnum.getTarget() + "" + time + endVal;
        return id;
    }

    public static void main(String[] args) {
        for (int i =0; i< 10;i++)System.out.println(getId(IdTargetEnum.CMS));
    }
}
