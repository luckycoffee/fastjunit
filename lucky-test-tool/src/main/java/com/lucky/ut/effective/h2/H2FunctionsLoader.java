package com.lucky.ut.effective.h2;

import org.h2.tools.RunScript;
import org.h2.util.IOUtils;

import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * H2 functions loader
 *
 * @author xiuyin.cui@luckincoffee.com
 */
public class H2FunctionsLoader {

    private static final String BLANK_SPACE = " ";

    public static final Set<H2Function> H2_FUNCTIONS = new CopyOnWriteArraySet<>();

    /**
     * @param h2Function
     */
    protected static void add(H2Function h2Function) {
        H2_FUNCTIONS.add(h2Function);
    }

    /**
     * @param collection
     */
    protected static void addAll(Collection<H2Function> collection) {
        H2_FUNCTIONS.addAll(collection);
    }

    public static void loadMysqlFunctions(DataSource dataSource) {
        try {
            // H2_FUNCTIONS 集合，子类实现可自行添加
            addAll(new DefaultH2Functions().defaultH2Functions());
            StringBuilder sBuilder = new StringBuilder();
            for (H2Function h2Function : H2_FUNCTIONS) {
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
}
