package com.veio007.jtinyframe.tool.data;

import com.veio007.jtinyframe.tool.Args;
import com.veio007.jtinyframe.tool.annotation.Runner;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author ww
 * @version [版本号, 2017/5/24]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DBConnection implements Runner {

    @Override
    public void execute(Args args) {
        /*
        String url = "jdbc:mysql://" + args[0] + ":3306/lts";
        String username = args[1];
        String password = args[2];
        try {
            Connection con = DriverManager.getConnection(url, username, password);
        } catch (SQLException se) {
            System.out.println("数据库连接失败！");
            se.printStackTrace();
        }
        */
    }
}
