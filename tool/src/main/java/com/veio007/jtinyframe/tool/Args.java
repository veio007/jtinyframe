package com.veio007.jtinyframe.tool;

import com.beust.jcommander.Parameter;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author ww
 * @version [版本号, 2017/5/24]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Args {
    @Parameter(names = {"--class", "-c"}, description = "指定实现类")
    public String impClass;

    public static void main(String[] args) {


    }
}
