package com.lucky.ut.effective.h2;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author xiuyin.cui@luckincoffee.com
 * @Date 2020/9/8 20:00
 * @Description H2 针对 MySQL 函数的自定义实现
 */
public abstract class H2Functions {

    protected static final Set<H2Function> H2_FUNCTIONS = new CopyOnWriteArraySet<>();

    /**
     * add a mysql function implementation to  {@link H2Functions#H2_FUNCTIONS}
     */
    protected abstract void add();

    /**
     * @param h2Function
     */
    protected void add(H2Function h2Function) {
        H2_FUNCTIONS.add(h2Function);
    }

    /**
     * @param collection
     */
    protected void addAll(Collection<H2Function> collection) {
        H2_FUNCTIONS.addAll(collection);
    }


    protected static class H2Function {
        /**
         * Mysql function alias，etc：version
         */
        private String function;

        /**
         * The full class name for this function implementation
         */
        private String fullClassName;

        public H2Function(String function, String fullClassName) {
            this.function = function;
            this.fullClassName = fullClassName;
        }

        public String getFunction() {
            return function;
        }

        public void setFunction(String function) {
            this.function = function;
        }

        public String getFullClassName() {
            return fullClassName;
        }

        public void setFullClassName(String fullClassName) {
            this.fullClassName = fullClassName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (!(o instanceof H2Function)) return false;

            H2Function that = (H2Function) o;

            return new EqualsBuilder()
                    .append(getFunction(), that.getFunction())
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37)
                    .append(getFunction())
                    .toHashCode();
        }
    }


}
