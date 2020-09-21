package com.lucky.ut.effective.h2;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @Author xiuyin.cui@luckincoffee.com
 * @Date 2020/9/18 10:18
 * @Description h2 function
 */
public class H2Function {

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
