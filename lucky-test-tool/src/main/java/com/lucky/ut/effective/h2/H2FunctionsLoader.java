package com.lucky.ut.effective.h2;

import com.lucky.ut.effective.h2.H2Functions.H2Function;
import org.h2.tools.RunScript;
import org.h2.util.IOUtils;

import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * H2 functions loader
 *
 * @author xiuyin.cui@luckincoffee.com
 */
public class H2FunctionsLoader {

    private static final String BLANK_SPACE = " ";

    public static void loadMysqlFunctions(DataSource dataSource) {
        try {
            // 获取 H2Functions 所有子类列表，并执行 add 方法
            for (Class<?> c : getAllAssignedClass(H2Functions.class)) {
                Object newInstance = c.newInstance();
                Method add = c.getDeclaredMethod("add");
                add.setAccessible(true);
                add.invoke(newInstance);
            }
            StringBuilder sBuilder = new StringBuilder();
            for (H2Function h2Function : H2Functions.H2_FUNCTIONS) {
                sBuilder.append("CREATE").append(BLANK_SPACE).append("ALIAS").append(BLANK_SPACE)
                        .append(h2Function.getFunction()).append(BLANK_SPACE).append("FOR").append(BLANK_SPACE)
                        .append("\"").append(h2Function.getFullClassName()).append("\";");
            }
            Connection conn = dataSource.getConnection();
            RunScript.execute(conn, IOUtils.getReader(new ByteArrayInputStream(sBuilder.toString().getBytes())));
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取同一路径下所有子类或接口实现类
     *
     * @param cls
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static List<Class<?>> getAllAssignedClass(Class<?> cls) throws IOException, ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        for (Class<?> c : getClasses(cls)) {
            if (cls.isAssignableFrom(c) && !cls.equals(c)) {
                classes.add(c);
            }
        }
        return classes;
    }

    /**
     * 取得当前类路径下的所有类
     *
     * @param cls
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static List<Class<?>> getClasses(Class<?> cls) throws ClassNotFoundException {
        String pk = cls.getPackage().getName();
        String path = pk.replace('.', '/');
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource(path);
        return getClasses(new File(url.getFile()), pk);
    }

    /**
     * 迭代查找类
     *
     * @param dir
     * @param pk
     * @return
     * @throws ClassNotFoundException
     */
    private static List<Class<?>> getClasses(File dir, String pk) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        if (!dir.exists()) {
            return classes;
        }
        for (File f : dir.listFiles()) {
            if (f.isDirectory()) {
                classes.addAll(getClasses(f, pk + "." + f.getName()));
            }
            String name = f.getName();
            if (name.endsWith(".class")) {
                classes.add(Class.forName(pk + "." + name.substring(0, name.length() - 6)));
            }
        }
        return classes;
    }
}
