package io.github.xiami0725.request;

/**
 * @author lzz
 * @create 2021-04-22 16:13
 */

public class Field {

    public Field() {
    }

    public Field(String name, Object value) {
        this.name = name;
        this.value = value;
        this.queryMethod = QueryMethod.eq;
    }

    public Field(String name, Object value, QueryMethod queryMethod) {
        this.name = name;
        this.value = value;
        this.queryMethod = queryMethod;
    }

    private String name;
    private Object value;
    private QueryMethod queryMethod;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public QueryMethod getQueryMethod() {
        return queryMethod;
    }

    public void setQueryMethod(QueryMethod queryMethod) {
        this.queryMethod = queryMethod;
    }
}
